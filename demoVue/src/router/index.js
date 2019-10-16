import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/page/Login'
import Demo from '@/components/Demo'
import Instance from '@/components/Instance'
import Template from '@/components/Template'
import Computed from '@/components/Computed'
import Watch from '@/components/Watch'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/demo',
      name: 'Demo',
      component: Demo
    },
    {
      path: '/instance',
      name: 'Instance',
      component: Instance
    },  
    {
      path: '/template',
      name: 'Template',
      component: Template
    },
    {
      path: '/computed',
      name: 'Computed',
      component: Computed
    },
    {
      path: '/watch',
      name: 'Watch',
      component: Watch
    }
  ]
})
