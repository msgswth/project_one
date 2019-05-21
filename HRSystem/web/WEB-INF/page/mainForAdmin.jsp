<%@ page import="com.iotek.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Interview" %>
<%@ page import="com.iotek.model.Record" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/17
  Time: 11:44
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
<%
    Employee employee= (Employee) session.getAttribute("admin");
    List<Record> records= (List<Record>) session.getAttribute("allInterview");
    if(employee==null){
%>
    <div>
        欢迎您!
        <a href="each?method=adminLogin" >登录</a>
        <a href="each?method=adminRegister">注册</a>
    </div>

<%
    }else {
%>
    <div>
        欢迎您!<%=employee.getEmp_name()%>
        <a href="exit">登出</a>
        <a href="showRecruitForAdmin">查看招聘信息</a>
        <a href="showDepAndPos">管理部门职位</a>
        <a href="getTrain">查看培训记录</a>
    </div>
    <div id="show">
        <table border="1px" cellspacing="0px">
            <tr>
                <th>应聘人</th>
                <th>职位描述</th>
                <th>发布时间</th>
                <th>查看简历</th>
                <th>发送邀请</th>
                <th>通过与否</th>
                <th>是否已读</th>
            </tr>

        <%
        if(records!=null&&records.size()!=0){
            for (Record record : records) {
            %>
            <tr>
                <td><%=record.getTourist().getT_name()%></td>
                <td><%=record.getRecruit().getRct_intro()%></td>
                <td><%=record.getRecruit().getRct_time()%></td>
                <td>
                    <form action="getResumeForAdmin" method="post">
                        <input type="hidden" name="rs_id" value="<%=record.getInterview().getRs_id()%>">
                        <input type="hidden" name="t_id" value="<%=record.getTourist().getT_id()%>">
                        <input type="submit" value="查看简历">
                    </form>
                </td>
                <td>
                    <form action="updateInterview" method="post">
                        <input type="date" name="v_date">
                        <input type="hidden" name="rs_id" value="<%=record.getInterview().getRs_id()%>">
                        <input type="hidden" name="rct_id" value="<%=record.getInterview().getRct_id()%>">
                        <input type="hidden" name="v_is_read" value="<%=record.getInterview().getV_is_read()%>">
                        <input type="hidden" name="v_is_accept" value="<%=record.getInterview().getV_is_accept()%>">
                        <input type="hidden" name="v_is_agree" value="<%=record.getInterview().getV_is_agree()%>">
                        <input type="hidden" name="v_id" value="<%=record.getInterview().getV_id()%>">
                        <input type="submit" value="发送">
                    </form>
                </td>
                <td>
                    <%
                        if(record.getInterview().getV_is_accept().equals("接受")){
                    %>
                    <input type="button" value="已录用">
                    <%
                    }else {
                    %>
                    <form action="employ" method="post">
                        <input type="date" hidden name="v_date" value="<%=record.getInterview().getV_date()%>">
                        <input type="hidden" name="rs_id" value="<%=record.getInterview().getRs_id()%>">
                        <input type="hidden" name="rct_id" value="<%=record.getInterview().getRct_id()%>">
                        <input type="hidden" name="v_is_read" value="<%=record.getInterview().getV_is_read()%>">
                        <input type="hidden" name="v_is_agree" value="<%=record.getInterview().getV_is_agree()%>">
                        <input type="hidden" name="v_is_accept" value="接受">
                        <input type="hidden" name="v_id" value="<%=record.getInterview().getV_id()%>">
                        <input type="submit" value="录用">
                    </form>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
            }
        %>

        <%
        }else {
        %>
            <tr>
                <td colspan="7">现在还没有人投递简历</td>
            </tr>
        <%
        }
        %>
        </table>
    </div>
<%
    }
%>

</div>


</body>
</html>
