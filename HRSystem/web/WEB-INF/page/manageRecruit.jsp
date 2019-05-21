<%@ page import="com.iotek.model.Recruit" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/19
  Time: 21:52
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
</head>
<body>
<div>
    <table>
        <tr>
            <th>公司名</th>
            <th>职位ID</th>
            <th>职位描述</th>
            <th>发布时间</th>
            <th>公司地址</th>
            <th>薪资</th>
            <th>联系人</th>
            <th>是否撤销</th>
            <th>是否发布</th>
            <th>更新招聘信息</th>
            <th>删除招聘信息</th>
            <th>添加招聘信息</th>
        </tr>
        <%
            List<Recruit> recruits= (List<Recruit>) session.getAttribute("myRecruits");
            if(recruits!=null&&recruits.size()!=0){
                for (Recruit recruit : recruits) {
        %>
        <tr>
            <td><%=recruit.getCom_name()%></td>
            <td><%=recruit.getPos_id()%></td>
            <td><%=recruit.getRct_intro()%></td>
            <td><%=recruit.getRct_time()%></td>
            <td><%=recruit.getRct_address()%></td>
            <td><%=recruit.getRct_salary()%></td>
            <td><%=recruit.getEmp_id()%></td>
            <td>
                <%
                if(recruit.getRct_is_draft().equals("草稿")){
                %>
                <input type="button" value="草稿">
                <%
                }else {
                %>
                <form action="updateRecruit" method="post">
                    <input type="hidden" name="rct_id" value="<%=recruit.getRct_id()%>">
                    <input type="hidden" name="com_name" value="<%=recruit.getCom_name()%>">
                    <input type="hidden" name="pos_id" value="<%=recruit.getPos_id()%>">
                    <input type="hidden" name="rct_intro" value="<%=recruit.getRct_intro()%>">
                    <input type="date" hidden name="rct_time" value="<%=recruit.getRct_time()%>">
                    <input type="hidden" name="rct_address" value="<%=recruit.getRct_address()%>">
                    <input type="hidden" name="rct_salary" value="<%=recruit.getRct_salary()%>">
                    <input type="hidden" name="emp_id" value="<%=recruit.getEmp_id()%>">
                    <input type="hidden" name="rct_is_draft" value="非草稿">
                    <input type="hidden" name="rct_is_publish" value="<%=recruit.getRct_is_publish()%>">
                    <input type="submit" value="撤销">
                </form>

                <%
                }
                %>
            </td>
            <td>
                <%
                    if(recruit.getRct_is_publish().equals("已发布")){
                %>
                <input type="button" value="已发布">
                <%
                }else {
                %>
                <form action="updateRecruit" method="post">
                    <input type="hidden" name="rct_id" value="<%=recruit.getRct_id()%>">
                    <input type="hidden" name="com_name" value="<%=recruit.getCom_name()%>">
                    <input type="hidden" name="pos_id" value="<%=recruit.getPos_id()%>">
                    <input type="hidden" name="rct_intro" value="<%=recruit.getRct_intro()%>">
                    <input type="date" hidden name="rct_time" value="<%=recruit.getRct_time()%>">
                    <input type="hidden" name="rct_address" value="<%=recruit.getRct_address()%>">
                    <input type="hidden" name="rct_salary" value="<%=recruit.getRct_salary()%>">
                    <input type="hidden" name="emp_id" value="<%=recruit.getEmp_id()%>">
                    <input type="hidden" name="rct_is_draft" value="<%=recruit.getRct_is_draft()%>">
                    <input type="hidden" name="rct_is_publish" value="已发布">
                    <input type="submit" value="发布">
                </form>

                <%
                    }
                %>
            </td>
            <td>
                <input type="button" value="更新" class="update">
                <script>
                    $(function () {
                        $(".update").click(function () {
                            $("#content").append(
                                "<form action='updateRecruit' method='post'>"+
                                "<input type='hidden' name='rct_id' value='<%=recruit.getRct_id()%>'>"+
                                "<input type='text' name='com_name' value='<%=recruit.getCom_name()%>'>"+
                                "<input type='text' name='pos_id' value='<%=recruit.getPos_id()%>'>"+
                                "<input type='text' name='rct_intro' value='<%=recruit.getRct_intro()%>'>"+
                                "<input type='date' name='rct_time' value='<%=recruit.getRct_time()%>'>"+
                                "<input type='text' name='rct_address' value='<%=recruit.getRct_address()%>'>"+
                                "<input type='text' name='rct_salary' value='<%=recruit.getRct_salary()%>'>"+
                                "<input type='text' name='emp_id' value='<%=recruit.getEmp_id()%>'>"+
                                "<input type='text' name='rct_is_draft' value='<%=recruit.getRct_is_draft()%>'>"+
                                "<input type='text' name='rct_is_publish' value='<%=recruit.getRct_is_publish()%>'>"+
                                "<input type='submit' value='更新'>"+
                                "</form>")
                        })
                    })
                </script>
            </td>
            <td>
                <form action="deleteRecruit" method="post">
                    <input type="hidden" name="rct_id" value="<%=recruit.getRct_id()%>">
                    <input type="hidden" name="rct_is_draft" value="<%=recruit.getRct_is_draft()%>">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td>
                <input type="button" value="添加" class="add">
                <script>
                    $(function () {
                        $(".add").click(function () {
                            $("#content").append(
                                "<form action='addRecruit' method='post'>"+
                                "<input type='text' name='com_name' >"+
                                "<input type='text' name='pos_id' >"+
                                "<input type='text' name='rct_intro' >"+
                                "<input type='date' name='rct_time' >"+
                                "<input type='text' name='rct_address' >"+
                                "<input type='text' name='rct_salary' >"+
                                "<input type='text' name='emp_id' >"+
                                "<input type='text' name='rct_is_draft' >"+
                                "<input type='text' name='rct_is_publish' >"+
                                "<input type='submit' value='添加'>"+
                                "</form>")
                        })
                    })
                </script>
            </td>
        </tr>
            <%
                }
            %>
        <%
        }else {
        %>
        <tr>
            <td colspan="11">还没有任何招聘信息</td>
            <td>
                <input type="button" value="添加" class="insert">
                <script>
                    $(function () {
                        $(".insert").click(function () {
                            $("#content").append(
                                "<form action='addRecruit' method='post'>"+
                                "<input type='text' name='com_name' >"+
                                "<input type='text' name='pos_id' >"+
                                "<input type='text' name='rct_intro' >"+
                                "<input type='date' name='rct_time' >"+
                                "<input type='text' name='rct_address' >"+
                                "<input type='text' name='rct_salary' >"+
                                "<input type='text' name='emp_id' >"+
                                "<input type='text' name='rct_is_draft' >"+
                                "<input type='text' name='rct_is_publish' >"+
                                "<input type='submit' value='添加'>"+
                                "</form>")
                        })
                    })
                </script>
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
