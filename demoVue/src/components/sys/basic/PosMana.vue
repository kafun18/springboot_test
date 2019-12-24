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
        @selection-change="handleSelectionChange"
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
          width="180">
        </el-table-column>
        <el-table-column
          prop="createDate"
          label="创建时间"
          width="180">
        </el-table-column>
        <el-table-column
          label="是否启用"
          width="100px;">
          <template slot-scope="scope">
            <el-tag type="success" v-if="scope.row.enabled">已启用</el-tag>
            <el-tag type="danger" v-else>未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!--scope.$index表示获取哪一行，scope.row表示获取哪一行的Json对象-->
            <el-button
              size="mini"
              @click="showEditView(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--disabled隐藏功能，当multipleSelection勾上有值的话disabled显现出来-->
      <el-button @click="deleteMany" type="danger" size="small" style="margin-top: 8px"
                 :disabled="multipleSelection.length==0">批量删除</el-button>
    </div>
    <el-dialog
      title="修改职位"
      :visible.sync="dialogVisible"
      width="30%">
      <div>
        <el-tag>职位名称</el-tag>
        <el-input class="updatePosInput" size="small" v-model="updatePos.name"></el-input>
      </div>
      <div>
        <el-tag>是否启用</el-tag>
        <el-switch style="margin-left: 8px;" v-model="updatePos.enabled"
                   active-text="启用" inactive-text="禁言"></el-switch>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button size="small" @click="dialogVisible = false">取 消</el-button>
    <el-button size="small" type="primary" @click="doUpdate">确 定</el-button>
  </span>
    </el-dialog>
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
        dialogVisible:false,
        updatePos:{
          name:'',
          enabled:''
        },
        positions: [],
        multipleSelection: []
      }
    },
    //初始化页面后跑查询数据
    mounted(){
      this.initPositions();
    },
    methods:{
      deleteMany(){
        this.$confirm('此操作将永久删除【'+this.multipleSelection.length+'】条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let ids='?';
          this.multipleSelection.forEach(item=>{
            ids +='ids=' +item.id+ '&';
          })
          this.deleteRequest("/system/basic/pos/"+ids).then(resp=>{
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
      handleSelectionChange(val){
        this.multipleSelection=val;
        console.log(val);
      },
      doUpdate(){
        this.putRequest("/system/basic/pos/",this.updatePos).then(resp=>{
          if (resp){
            // 添加数据后刷新页面
            this.initPositions();
            // 清空输入框
            this.updatePos = {
              name:'',
              enabled:''
            }
            this.dialogVisible=false;
          }
        })
      },
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
      showEditView(index,data){
        //从一个或多个源对象复制到目标对象。它将返回目标对象
        Object.assign(this.updatePos,data);
        // this.updatePos=data;
        this.dialogVisible=true;
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
  .updatePosInput{
    width: 200px;
    margin-left: 8px;
  }
  .addPosInput {
    width: 300px;
    margin-right: 8px
  }
  .posManaMain{
    margin-top: 10px;
  }
</style>
