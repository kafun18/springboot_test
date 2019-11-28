<template>
  <div>
    <el-form :rules="rules" ref="loginForm" :model="loginForm" class="loginContainer">
      <h3 class="loginTitle">系统登陆</h3>
      <el-form-item prop="username">
        <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="请输入密码"
          @keydown.enter.native="submitClick"
        ></el-input>
      </el-form-item>
      <el-checkbox class="loginRemember" v-model="checked"></el-checkbox>
      <el-button type="primary" style="width:100%;" @click="submitClick">登陆</el-button>
    </el-form>
  </div>
</template>

<script>
  // import {postKeyValueRequest} from "../utils/api";

  export default {
    name: "Login",
    data() {
      return {
        loginForm: {
          username: "admin",
          password: "123"
        },
        checked: true,
        rules: {
          username: [
            {required: true, message: "请输入用户名", trigger: "blur"}
          ],
          password: [{required: true, message: "请输入密码", trigger: "blur"}]
        }
      };
    },
    methods: {
      submitClick() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            // alert("submit!");
            this.postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
              if (resp) {
                // console.log(resp);
                // alert(JSON.stringify(resp));
                window.sessionStorage.setItem("user", JSON.stringify(resp.obj));
                this.$router.replace('/home');
              }
            })
          } else {
            this.$message.error("请输入所有字段");
            return false;
          }
        });
      }
    }
  };
</script>

<style>
  .loginContainer {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .loginTitle {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .loginRemember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
