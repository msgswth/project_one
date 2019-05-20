<%@ page import="com.iotek.model.Tourist" %>
<%@ page import="com.iotek.model.Record" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/19
  Time: 15:39
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
        Tourist tourist= (Tourist) session.getAttribute("to");
        List<Record> records= (List<Record>) session.getAttribute("checkRecord");
    %>
    <form action="each" method="post">
        <input type="hidden" name="method" value="main">
        <input type="submit" value="返回首页">
    </form>

    <div id="show">
        <table border="1px" cellspacing="0px">
            <tr>
                <th>应聘人</th>
                <th>公司名字</th>
                <th>职位描述</th>
                <th>面试时间</th>
                <th>面试地点</th>
                <th>联系人</th>
                <th>是否同意</th>
            </tr>

            <%
                if(records!=null&&records.size()!=0){
                    for (Record record : records) {
            %>
            <tr>
                <td><%=tourist.getT_name()%></td>
                <td><%=record.getRecruit().getCom_name()%></td>
                <td><%=record.getRecruit().getRct_intro()%></td>
                <td><%=record.getInterview().getV_date()%></td>
                <td><%=record.getRecruit().getRct_address()%></td>
                <td><%=record.getRecruit().getEmp_id()%></td>
                <td>
                    <%
                    if(record.getInterview().getV_is_agree().equals("同意")){
                    %>
                    <input type="button" value="已同意">
                    <%
                    }else {
                    %>
                    <form action="updateInter" method="post">
                        <input type="date" hidden name="v_date" value="<%=record.getInterview().getV_date()%>">
                        <input type="hidden" name="rs_id" value="<%=record.getInterview().getRs_id()%>">
                        <input type="hidden" name="rct_id" value="<%=record.getInterview().getRct_id()%>">
                        <input type="hidden" name="v_is_read" value="<%=record.getInterview().getV_is_read()%>">
                        <input type="hidden" name="v_is_accept" value="<%=record.getInterview().getV_is_accept()%>">
                        <input type="hidden" name="v_is_agree" value="同意">
                        <input type="hidden" name="v_id" value="<%=record.getInterview().getV_id()%>">
                        <input type="submit" value="同意">
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
                <td colspan="7">暂时还没有面试邀请</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</div>

</body>
</html>
