import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/page/Login'
// import Demo from '@/components/Demo'
import Home from '@/page/Home'
import FriendChat from '../page/chat/FriendChat'
// import Test1 from '@/page/Test1'
// import Test2 from '@/page/Test2'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden:true
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      hidden:true,
      children:[{
        path: '/chat',
        name: '在线聊天',
        component: FriendChat,
        hidden:true
      }]
    },
    /*{
      path: '/home',
      name: '导航一',
      component: Home,
      children:[
        {
          path: '/test1',
          name: '选项1',
          component: Test1
        },
        {
          path: '/test2',
          name: '选项2',
          component: Test2
        }
      ]
    },*/
    /*{
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/demo',
      name: 'Demo',
      component: Demo
    }*/
  ]
})
