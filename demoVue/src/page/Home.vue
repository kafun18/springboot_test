<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">管理系统</div>
        <el-dropdown class="userInfo" @command="commandHandler">
          <span class="el-dropdown-link">
            {{user.name}}
            <i><img :src="user.userface"/></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="userInfo">个人中心1</el-dropdown-item>
            <el-dropdown-item command="setting">设置</el-dropdown-item>
            <el-dropdown-item command="logout" divided>注销登陆</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-container>

        <el-aside width="200px">
          <el-menu router unique-opened>
            <el-submenu :index="index+''" v-for="(item,index) in routes" v-if="!item.hidden" :key="index">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>{{item.name}}</span>
              </template>
              <el-menu-item :index="child.path" v-for="(child,indexj) in item.children" :key="indexj">
                {{child.name}}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>

        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right"
                         v-if="this.$router.currentRoute.path!='/home'">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
          </el-breadcrumb>
          <div class="homeWelcome" v-if="this.$router.currentRoute.path=='/home'">
            欢迎来到管理系统！
          </div>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {
        user: JSON.parse(window.sessionStorage.getItem("user"))
      }
    },
    computed:{
      routes(){
        return this.$store.state.routes;
      }
    },
    methods: {
      /*menuClick(index) {
        this.$router.push(index);
        /!*console.log(index);
        console.log(indexPath);*!/
      },*/
      commandHandler(cmd) {
        if (cmd == 'logout') {
          this.$confirm('此操作将注销登陆, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.getRequest('/logout');
            window.sessionStorage.removeItem("user");
            this.$store.commit('initRoutes',[]);
            this.$router.replace("/");
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消操作'
            });
          });
        }
      }
    }
  };
</script>

<style>
  .homeHeader {
    background-color: #409eff;
    display: flex;
    /* 竖直居中 */
    align-items: center;
    justify-content: space-between;
    padding: 0px 15px;
    box-sizing: border-box;
  }

  .homeHeader .title {
    font-size: 30px;
    font-family: cursive;
    color: #ffffff;
    font-weight: 1000;
  }

  .homeHeader .userInfo {
    cursor: pointer;
  }

  .el-dropdown-link img {
    width: 48px;
    height: 48px;
    border-radius: 24px;
    margin-left: 8px;
  }

  .el-dropdown-link {
    display: flex;
    align-items: center;
  }
  .homeWelcome {
    text-align: center;
    font-size: 30px;
    font-family: cursive;
    color: #409eff;
    padding-top: 50px;
  }
</style>
