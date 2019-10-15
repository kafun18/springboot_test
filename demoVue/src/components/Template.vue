 <!-- vue语法模板 -->
<template>
<div id="Template">
 <div>{{a}}</div>
 <button v-bind:disabled="enableBtn">按钮</button>
 <div v-html="c"></div>
 <button v-bind:disabled="!enableBtn" v-on:click="num++">按钮</button>
 <div>{{num>101?'good':num}}</div>
 <a v-bind:href="myurl" target="_target">进入百度地址</a>
</div>
</template>

<script>
export default {
  name: 'Template',
  data () {
    return {
       a:1,
       enableBtn:true,
       b:null,
       c:'<h1>hello javaboy</h1>',
       num:99,
       myurl:'http://www.baidu.com'
    }
  },
}

</script>