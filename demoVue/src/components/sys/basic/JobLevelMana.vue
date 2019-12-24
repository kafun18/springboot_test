<template>
  <div>
    <div>
      <el-input class="addJlInput" size="small" v-model="jl.name" style="width: 300px;"
                prefix-icon="el-icon-plus" placeholder="添加职称..."></el-input>
      <el-select v-model="jl.titleLevel" placeholder="职称等级" size="small"
                 style="margin-left: 5px;margin-right: 5px" @keydown.enter.native="addJobLevel">
        <el-option
          v-for="item in titleLevels"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
      <el-button icon="el-icon-plus" type="primary" size="small" @click="addJobLevel">添加</el-button>
    </div>
    <div class="JobLevelMana">
      <el-table
        :data="jls"
        @selection-change="handleSelectionChange"
        border
        stripe
        size="small"
        style="width: 80%">
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
          label="职称名称">
        </el-table-column>
        <el-table-column
          prop="titleLevel"
          label="职称级别">
        </el-table-column>
        <el-table-column
          prop="createDate"
          label="创建时间">
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
              @click="showEditView(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--disabled隐藏功能，当multipleSelection勾上有值的话disabled显现出来-->
      <el-button @click="deleteMany" type="danger" size="small" style="margin-top: 8px"
                 :disabled="multipleSelection.length==0">批量删除</el-button>
    </div>
    <el-dialog
      title="修改职称"
      :visible.sync="dialogVisible"
      width="30%">
      <div>
        <el-tag>职位名称</el-tag>
        <el-input class="updateJlInput" size="small" v-model="updateJl.name"></el-input>
      </div>
      <div>
        <el-tag>职位级别</el-tag>
        <!--<el-input class="updateJlInput" size="small" v-model="updateJl.titleLevel"></el-input>-->
        <el-select class="updateJlInput" v-model="updateJl.titleLevel" placeholder="职称等级" size="small"
                   style="margin-left: 5px;margin-right: 5px">
          <el-option
            v-for="item in titleLevels"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
      </div>
      <div>
        <el-tag>是否启用</el-tag>
        <el-switch style="margin-left: 8px;" v-model="updateJl.enabled"
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
    name: "JobLevelMana",
    data() {
      return {
        jl: {
          name: '',
          titleLevel: ''
        },
        titleLevels: [
          '正高级',
          '副高级',
          '中级',
          '初级',
          '员级'
        ],
        jls: [],
        updateJl:{
          name: '',
          titleLevel: '',
          enabled:''
        },
        dialogVisible:false,
        multipleSelection: []
      }
    },
    //初始化页面后跑查询数据,mounted()是一个方法
    mounted(){
      this.initJls();
    },
    //methods是一个属性
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
          this.deleteRequest("/system/basic/joblevel/"+ids).then(resp=>{
            if (resp){
              this.initJls();
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
      handleDelete(index,data){
        this.$confirm('此操作将永久删除【'+data.name+'】职称, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/system/basic/joblevel/"+data.id).then(resp=>{
            if (resp){
              this.initJls();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      showEditView(index,data){
        //从一个或多个源对象复制到目标对象。它将返回目标对象
        Object.assign(this.updateJl,data);
        // this.updateJl=data;
        this.dialogVisible=true;
      },
      doUpdate(){
        this.putRequest("/system/basic/joblevel/",this.updateJl).then(resp=>{
          if (resp){
            // 添加数据后刷新页面
            this.initJls();
            // 清空输入框
            this.jl = {
              name: '',
              titleLevel: ''
            }
            // 更新完隐藏弹出框
            this.dialogVisible=false;
          }
        })
      },
      initJls(){
        this.getRequest("/system/basic/joblevel/").then(resp=>{
          if (resp){
            this.jls = resp;
          }
        })
      },
      addJobLevel(){
        if (this.jl.name && this.jl.titleLevel){
          this.postRequest("/system/basic/joblevel/",this.jl).then(resp=>{
            if (resp){
              // 添加数据后刷新页面
              this.initJls();
              // 清空输入框
              this.jl = {
                name: '',
                titleLevel: ''
              }
            }
          });
        }else {
          this.$message.error('添加字段不能为空！');
        }
      }
    }
  }
</script>

<style>
  .JobLevelMana {
    margin-top: 10px;
  }
  .updateJlInput{
    width: 200px;
    margin-left: 8px;
    margin-bottom: 8px;
  }
  .addJlInput{
    width: 300px;
    margin-right: 8px
  }
</style>
