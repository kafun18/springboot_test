 <!-- vue实例 -->
<template>
<div id="instance">
 <h1>hello javaboy</h1>
 <div>{{data.a}}</div>
</div>
</template>

<script>
var data = {a:1,b:null};
// Object.freeze(data);
export default {
  name: 'instance',
  data () {
    return {
       data:data
    }
  },
  created(){
      console.log("create");
  }
};
data.a=89;
console.log(data.a);
data.b=99;
console.log(data.b);
console.log(document.getElementById("instance"));

</script>