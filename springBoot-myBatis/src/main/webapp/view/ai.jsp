<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>菜鸡页面</title>
    </head>
    <script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    <body>
        <form title="girl" id="aaa" >
            cupSize<input id="cupSize" />
            age<input id="age" />
            <button type="button" onclick="tijiao()" >保存</button>
        </form>
        <div id="aaaa" title="girl">

        </div>
    </body>
    <script type="text/javascript"  >
        function tijiao(){
            //var data={cupSize:$("#cupSize").val(),age:$("#age").val()};
            var age=$('#age').val();
            var cupSize=$("#cupSize").val();
            /* var formData = new FormData();
				formData.append('age', age);
				formData.append('cupSize', cupSize); */
				
            $.ajax({
                url:'/hi/add',
                type:'post',
                data:{'age':age,
                	  'cupSize':cupSize
                },
                datatype:'json',
                success:function (data) {
                	//var data1=JSON.stringify(data);
                    //var data1 = data.data;
                    $("#aaaa").show().html(data.msg+"<br/>"+"AGE:"+data.data.age+"<br/>"+"CUPSIZE:"+data.data.cupSize);
                    //"ID:"+data1.id+"<br/>"+
                }

            });
        }
    </script>
</html>