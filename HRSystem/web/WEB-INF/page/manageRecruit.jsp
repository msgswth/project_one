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
                <form action="sendResume" method="post">
                    <input type="hidden" name="rct_id" value="<%=recruit.getRct_id()%>">
                    <input type="hidden" name="t_id" value="${sessionScope.to.t_id}">
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>

        <%
            }
        }else {
        %>
        <tr>
            <td colspan="11">还没有任何招聘信息</td>
        </tr>
        <%
            }
        %>

    </table>
</div>


</body>
</html>
