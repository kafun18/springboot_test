<!-- 当需要在数据变化时执行异步或开销较大的操作时，侦听属性方式是最有用的 -->
<template>
  <div id="watch">
    <div>{{fullName}}</div>
  </div>
</template>

<script>
export default {
  name: "watch",
  data() {
    return {
      firstName: "zhang",
      lastName: 'san',
      fullName: 'zhang san'
    }
  },
  watch: {
      firstName(val) {
      this.fullName = val + '' + this.lastName;
      },
      lastName(val) {
      this.fullName = this.firstName + '' + val;
      }
  }
}
</script>