// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';

//这里导入进来api的方法后，页面想调用就直接this.方法就可以了
import {postRequest} from "./utils/api";
import {postKeyValueRequest} from "./utils/api";
import {putRequest} from "./utils/api";
import {getRequest} from "./utils/api";
import {deleteRequest} from "./utils/api";
import {initMenu} from "./utils/menu";
// 导入font-awesome图标样式
import 'font-awesome/css/font-awesome.min.css'

Vue.prototype.postRequest=postRequest;
Vue.prototype.postKeyValueRequest=postKeyValueRequest;
Vue.prototype.putRequest=putRequest;
Vue.prototype.getRequest=getRequest;
Vue.prototype.deleteRequest=deleteRequest;

Vue.config.productionTip = false

// {size:'small'}全局配置样式
Vue.use(ElementUI,{size:'small'});
Vue.use(ViewUI);

/*全局前置导航钩子 beforeEach
1、to:即将要进入的目标路由对象；
2、from:当前导航即将要离开的路由对象；
3、next ：调用该方法后，才能进入下一个钩子函数（afterEach）*/
router.beforeEach((to,from,next)=>{
  if(to.path == '/'){
    next();
  }else {
    if(window.sessionStorage.getItem("user")){
      initMenu(router,store);
      next();
    }else {
      next('/?redirect='+to.path);
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
});
