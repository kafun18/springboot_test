<template>
<div id='app2'>
    <div>
      <!-- 声明式渲染 -->
      {{msg}}
    </div>
    <div>      
      <!-- 指令 -->
     <span v-bind:title="message">鼠标悬停几秒查看此处信息</span>
      <!-- 条件指令 -->
     <p v-if="seen">你是不是看到我</p>
    </div>
    <!-- 循环指令 -->
    <table border="1">
      <tr v-for="i in num">
        <td v-for="j in i">{{j}}*{{i}}={{j*i}}</td>
      </tr>
    </table>
    <!-- 处理用户输入 -->
    <button v-on:click="reversemsg">点我</button> 
    <input type="text" v-model="msg"> 
    <!-- 声明组件 -->
    <javaboy></javaboy>  
</div>    
</template>

<script>
// 导入组件
import javaboy from "./javaboy";

export default {
  name: 'Demo',
  components:{javaboy},
  data () {
    return {
      msg: '声明式渲染',
      message: '页面加载于123',
      seen: true,
      num: 9
    }
  },
  methods: {
    reversemsg() {
    alert('hello'),
    // 把msg的字符串值以空切割成单个字符然后反转最后用空合并字符串
    this.msg = this.msg.split('').reverse().join('')
  }
  }
}
</script>