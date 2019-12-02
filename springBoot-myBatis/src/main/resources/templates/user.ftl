<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker演示</title>
</head>
<body>
<table border="1">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>用户地址</td>
        <td>性别</td>
    </tr>
<#list users as u>
    <#if u.id==4>
        <#break>
    </#if>
    <tr>
        <td>${u.id}</td>
        <td>${u.username}</td>
        <td>${u.address}</td>
        <td>
        <#--<#if u.gender==0>
            男
        <#elseif u.gender==1>
            女
        <#else>
            未知
        </#if>-->
            <#switch u.gender>
                <#case 0>男<#break>
                <#case 1>女<#break>
                <#default>未知
            </#switch>
        </td>
    </tr>
</#list>
</table>
</body>
</html>