<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Recruit" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/15
  Time: 15:47
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
    <style>
        div{
            border: 2px solid black;
            padding: 5px;
            border-radius: 5px;
            margin: 10px;
        }
        table{
            border: 1px solid black;
            mso-cellspacing: 0px;
        }
        td{
            border: 1px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
<div>
    <a href="each?method=login" >登录</a>
    <a href="each?method=register">注册</a>
    <a href="each?method=mainForAdmin">我是管理员</a>
    <a href="#" onclick=confirm("请先登录")>投递简历</a>
</div>
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
        </tr>
        <%
            List<Recruit> recruits= (List<Recruit>) session.getAttribute("recruits");
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
                </tr>

        <%
                }
            }else {
        %>
        <tr>
            <td colspan="7">还没有任何招聘信息</td>
        </tr>
        <%
                }
        %>

    </table>
</div>
</body>
</html>
