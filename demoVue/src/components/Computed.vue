
<template>
  <div id="computed">
    <div>{{reverseMessage}}</div>
    <div>{{reverseMessage1()}}</div>
    <div>{{copyMsg}}</div>
  </div>
</template>

<script>
export default {
  name: "Computed",
  data() {
    return {
      message: "hello javaboy",
      copyMsg: null
    };
  },
  //   这个方法reverseMessage1每次都要执行一次
  methods: {
    reverseMessage1() {
      return this.message
        .split("")
        .reverse()
        .join("");
    }
  },
  //   计算属性
  //   这个计算reverseMessage计算一次后会有缓存，除非更改变量message的名字
  computed: {
    //   跟下面方法一样
    reverseMessage: {
      get() {
        return this.message
          .split("")
          .reverse()
          .join("");
      },
    //   可以设置值给它
      set(newVal) {
          this.copyMsg = newVal;
      }
    }
    /* reverseMessage() {
      return this.message
        .split("")
        .reverse()
        .join("");
    } */
  }
};
</script>