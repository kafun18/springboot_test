import Vue from 'vue'
import Vuex from 'vuex'
import {Notification} from 'element-ui';
import {getRequest} from "../utils/api";
import '../lib/stomp'
import '../lib/sockjs'

Vue.use(Vuex)

const now = new Date();
const store = new Vuex.Store({
  state: {
    routes: [],
    sessions: {},
    hrs: [],
    currentSession: null,
    // 当前发消息用户
    // currentHr:null,
    currentHr:JSON.parse(window.sessionStorage.getItem("user")),
    filterKey: '',
    stomp: null,
    //消息提示红点
    isDot:{}
  },
  mutations: {
    INIT_CURRENTHR(state,hr){
      state.currentHr = hr;
    },
    initRoutes(state, data) {
      state.routes = data;
    },
    changeCurrentSession(state, currentSession) {
      Vue.set(state.isDot,state.currentHr.username+'#'+currentSession.username,false);
      state.currentSession = currentSession;
    },
    // webSocket消息的添加/发送
    addMessage(state, msg) {
      let mss = state.sessions[state.currentHr.username+'#'+msg.to];
      if(!mss){
        // state.sessions[state.currentHr.username+'#'+msg.to] = [];
        // 聊天界面消息实时自动刷新显示
        Vue.set(state.sessions,state.currentHr.username + '#' + msg.to,[]);
      }
      state.sessions[state.currentHr.username+'#'+msg.to].push({
        content: msg.content,
        date: new Date(),
        self: !msg.notSelf
      })
    },
    INIT_DATA(state) {
      //浏览器本地的历史聊天记录可以在这里完成
      let data = localStorage.getItem('vue-chat-session');
      // // console.log(data)
      if (data) {
        state.sessions = JSON.parse(data);
      }
    },
    INIT_HR(state,data){
      state.hrs = data;
    }
  },
  actions: {
    connect(context){
      // webSocket消息的接收
      context.state.stomp=Stomp.over(new SockJS('/ws/ep'));
      context.state.stomp.connect({},success=>{
        // user前缀是默认必须的
        context.state.stomp.subscribe('/user/queue/chat',msg=>{
          // console.log('javaboy>>>>>' + msg.body);
          let receiverMsg = JSON.parse(msg.body);
          // console.log('>>>'+msg);
          if (!context.state.currentSession || receiverMsg.from != context.state.currentSession.username){
            // console.log('---'+context.state.currentSession.username);
            //消息提示效果
            Notification.info({
              title:'['+receiverMsg.fromNickname+']发来一条信息',
              message: receiverMsg.content.length>10?receiverMsg.content.substr(0,10):receiverMsg.content,
              position: 'bottom-right'
            });
            Vue.set(context.state.isDot,context.state.currentHr.username+'#'+receiverMsg.from,true);
          }
          receiverMsg.notSelf = true;
          receiverMsg.to = receiverMsg.from;
          context.commit('addMessage',receiverMsg);
        })
      },error=>{

      })
    },
    initData(context) {
      context.commit('INIT_DATA')
      getRequest("/chat/hrs").then(resp=>{
        if (resp){
          context.commit('INIT_HR',resp)
        }
      })
    }
  }
})

store.watch(function (state) {
  return state.sessions
}, function (val) {
  console.log('CHANGE: ', val);
  localStorage.setItem('vue-chat-session', JSON.stringify(val));
}, {
  deep: true/*这个貌似是开启watch监测的判断,官方说明也比较模糊*/
})
export default store;
