<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Bond" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/20
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $.ajax({
                type:"get",
                url:"findDep",
                success:function (data) {
                    var department = $("#dep_id");
                    department.empty();
                    department.append("<option value='' hidden selected>请选择部门</option>");
                    for(var i in data){
                        department.append("<option value='"+data[i]['dep_id']+"'>"+data[i]['dep_name']+"</option>");
                    }
                }
            });
            $("#dep_id").on("change",function () {
                $.ajax({
                    type:"get",
                    url:"findPos",
                    data:"dep_id="+$(this).val(),
                    success:function (data) {
                        var position = $("#pos_id");
                        position.empty();
                        position.append("<option value='' hidden selected>请选择职位</option>");
                        for(var i in data){
                            position.append("<option value='"+data[i]['pos_id']+"'>"+data[i]['pos_name']+"</option>");
                        }
                    }
                });
            });

            $("#pos_id").on("change",function () {
                $.ajax({
                    type:"get",
                    url:"findEmp",
                    data:"pos_id="+$(this).val(),
                    success:function (data) {
                        var employee = $("#emp_id");
                        employee.empty();
                        employee.append("<option value='' hidden selected>请选择员工</option>");
                        for(var i in data){
                            employee.append("<option value='"+data[i]['emp_id']+"'>"+data[i]['emp_name']+"</option>");
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<%
    List<Bond> bonds= (List<Bond>) session.getAttribute("bonds");
%>
<div>
    <select id="dep_id">

    </select>
    <select id="pos_id">

    </select>
    <select id="emp_id">

    </select>
</div>
<div>
    <table>
        <tr>
            <th>部门名字</th>
            <th>创建时间</th>
            <th>职位名称</th>
            <th>员工姓名</th>
            <th>更新</th>
            <th>删除</th>
        </tr>
        <%
        if(bonds!=null&&bonds.size()!=0){
            for (Bond bond : bonds) {
        %>
        <tr>
            <td><%=bond.getDepartment().getDep_name()%></td>
            <td><%=bond.getDepartment().getDep_time()%></td>
            <td><%=bond.getPosition().getPos_name()%></td>
            <td><%=bond.getEmployee().getEmp_name()%></td>
            <td>
                <input type="button" value="更新" class="update">
                <script>
                    $(function () {
                        $(".update").click(function () {
                            $("#content").append(
                                "<form action='updateDepAndPos' method='post'>"+
                                "<input type='hidden' name='dep_id' value='<%=bond.getDepartment().getDep_id()%>'>"+
                                "<input type='text' name='dep_name' value='<%=bond.getDepartment().getDep_name()%>'>"+
                                "<input type='hidden' name='pos_id' value='<%=bond.getPosition().getPos_id()%>'>"+
                                "<input type='text' name='pos_name' value='<%=bond.getPosition().getPos_name()%>'>"+
                                "<input type='submit' value='更新'>"+
                                "</form>")
                        })
                    })
                </script>
            </td>
            <td>
                <form action="deleteDepAndPos" method="post">
                    <input type="hidden" name="dep_id" value="<%=bond.getDepartment().getDep_id()%>">
                    <input type="hidden" name="pos_id" value="<%=bond.getPosition().getPos_id()%>">
                    <input type="submit" value="删除">
                </form>
            </td>

        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="6">
                <form action="addDepAndPos" method="post">
                    部门名字：<input type="text" name="dep_name" >
                    职位名字：<input type="text" name="pos_name" >
                    <input type="submit" value="添加">
                </form>
            </td>
        </tr>
        <%
        }else {
        %>
        <tr>
            <td colspan="6">还没有任何部门或职位！</td>
        </tr>
        <tr>
            <td colspan="6">
                <form action="addDepAndPos" method="post">
                    部门名字：<input type="text" name="dep_name" >
                    职位名字：<input type="text" name="pos_name" >
                    <input type="submit" value="添加">
                </form>
            </td>
        </tr>
        <%
        }
        %>
    </table>
</div>

<div id="content">

</div>

</body>
</html>
