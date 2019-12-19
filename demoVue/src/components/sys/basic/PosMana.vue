<template>
  <div>
    <div>
      <!--@keydown.enter.native键盘触发方法-->
      <el-input
        class="addPosInput"
        size="small"
        placeholder="添加职位..."
        suffix-icon="el-icon-plus"
        @keydown.enter.native="addPosition"
        v-model="pos.name">
      </el-input>
      <el-button icon="el-icon-plus" type="primary" size="small" @click="addPosition">添加</el-button>
    </div>
    <div class="posManaMain">
      <el-table
        :data="positions"
        border
        stripe
        size="small"
        style="width: 70%">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="id"
          label="编号"
          width="55">
        </el-table-column>
        <el-table-column
          prop="name"
          label="职位名称"
          width="120">
        </el-table-column>
        <el-table-column
          prop="createDate"
          label="创建时间">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!--scope.$index表示获取哪一行，scope.row表示获取哪一行的Json对象-->
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PostMana",
    data() {
      return {
        pos: {
          name: ''
        },
        positions: []
      }
    },
    mounted(){
      this.initPositions();
    },
    methods:{
      addPosition(){
        if (this.pos.name){
          this.postRequest("/system/basic/pos/",this.pos).then(resp=>{
            if (resp){
              // 添加数据后刷新页面
              this.initPositions();
              // 清空输入框
              this.pos.name=''
            }
          })
        }else {
          this.$message.error('职位名称不能为空');
        }
      },
      handleEdit(index,data){

      },
      handleDelete(index,data){
        this.$confirm('此操作将永久删除【'+data.name+'】职位, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/system/basic/pos/"+data.id).then(resp=>{
            if (resp){
              this.initPositions();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      initPositions(){
        this.getRequest("/system/basic/pos/").then(resp=>{
          if (resp){
            this.positions = resp;
          }
        })
      }
    }
  }
</script>

<style>
  .addPosInput {
    width: 300px;
    margin-right: 8px
  }
  .posManaMain{
    margin-top: 10px;
  }
</style>
