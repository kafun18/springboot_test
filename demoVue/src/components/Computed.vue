<!-- 计算属性 -->
<template>
    <div>
        <div>{{reverseMessage}}</div>
    </div>
</template>

<script>
export default {
    name: 'Computed',
    data() {  
        return {
         message: 'hello javaboy'
        }            
    },
    computed: {
        reverseMessage(){
            return this.message.split('').reverse().join('')
        }
    }
}
</script>