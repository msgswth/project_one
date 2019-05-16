<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.Resume" %>
<%@ page import="com.iotek.model.Tourist" %>
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
<% Resume resume= (Resume) session.getAttribute("myResume");
    Tourist tourist = (Tourist) session.getAttribute("to");
%>

<div id="content">

</div>
<%
    if(resume==null){
%>
<a id="addres">还没有简历,快去添加一份简历吧!</a>
<input type="hidden" name="t_id" value="<%=tourist.getT_id()%>" >
<%
    } else{
%>
<div>
    <form action="updateResume" method='post'>
    <table border="1px" cellspacing="0px">
        <tr>
            <td colspan='4' align='center'>我的个人简历</td>
        </tr>
        <tr>
            <td>姓名:</td><td><input type='text' maxlength='8' placeholder='长度不超过8个字符' name='rs_name' value="<%=resume.getRs_name()%>" required ></td>
            <td>性别:</td><td><input type='radio' name='rs_gender' value='男' checked>男<input type='radio' name='rs_gender' value='女' >女</td>
        </tr>
        <tr>
            <td>出生日期：</td><td><input  type='date' name='rs_birth' value="<%=resume.getRs_birth()%>" required></td>
        </tr>
        <tr>
            <td>籍贯：</td><td><input  type='text' maxlength='8' placeholder='长度不超过8个字符' name='rs_address' value="<%=resume.getRs_address()%>" required></td>
            <td>毕业院校：</td><td><input  type='text' name='rs_school' value="<%=resume.getRs_school()%>" maxlength='20' placeholder='长度不超过20个字符' required></td>
        </tr>
        <tr>
            <td>专业:</td><td><input  type='text' name='rs_major' value="<%=resume.getRs_major()%>" maxlength='20' placeholder='长度不超过20个字符' required></td>
        </tr>
        <tr>
            <td>学历：</td><td><input  type='text' name='rs_education' value="<%=resume.getRs_education()%>" maxlength='10' placeholder='长度不超过10个字符' required></td>
            <td>入学时间：</td><td><input  type='date' name='rs_enroll_date' value="<%=resume.getRs_enroll_date()%>" required></td>
        </tr>
        <tr>
            <td>毕业时间：</td><td><input  type='date' name='rs_graduation_date' value="<%=resume.getRs_graduation_date()%>" required></td>
        </tr>
        <tr>
            <td>电话号码：</td><td><input  type='text' value='<%=tourist.getT_phone()%>' required></td>
            <td>E-MAIL：</td><td><input  type='text' value=<%=tourist.getT_email()%> required></td>
        </tr>
        <tr>
            <td>期望薪资：</td><td><input  required type='text' maxlength='8' name='rs_salary' value="<%=resume.getRs_salary()%>"></td>
        </tr>
        <tr>
            <td colspan='4' align='center'>经历</td>
        </tr>
        <tr>
            <td colspan='4'><textarea name='rs_exprience' value="<%=resume.getRs_exprience()%>" maxlength='225'><%=resume.getRs_exprience()%></textarea>
                <input type='hidden' id='r_tid' name='t_id' value='<%=tourist.getT_id()%>'>
                <input type='hidden' name='rs_id' value='<%=resume.getRs_id()%>'>
            </td>
        </tr>
        <tr>
            <td colspan='4' align='center' ><input type='submit' value='修改'></td>
        </tr>
    </table>
    </form>

    <form action="deleteResume" method="post">
        <input type="hidden" name="rs_id" value='<%=resume.getRs_id()%>'>
        <input type='hidden' name='t_id' value='<%=tourist.getT_id()%>'>
        <input type="submit" value="删除">
    </form>
</div>
<%
    }
%>
<script>
    $(function () {
        $("#addres").click(function () {
            $("#addres").hide();
            // var r_tid = $(this).next().val();
            $("#content").append(
                "<form action='addResume' method='post'><table border='1'>" +
                "<tr><td colspan='4' align='center'>我的个人简历</td></tr>" +
                "<tr><td>姓名:</td><td><input type='text' maxlength='8' placeholder='长度不超过8个字符' name='rs_name' required style='border: 0px' ></td><td>性别:</td><td>" +
                "<input type='radio' name='rs_gender' value='男' checked>男<input type='radio' name='rs_gender' value='女' >女</td></tr>" +
                "<tr><td>出生日期：</td><td><input style='border: 0px' type='date' name='rs_birth' required></td></tr>" +
                "<tr><td>籍贯：</td><td><input style='border: 0px' type='text' maxlength='8' placeholder='长度不超过8个字符' name='rs_address' required></td>" +
                "<td>毕业院校：</td><td><input style='border: 0px' type='text' name='rs_school' maxlength='20' placeholder='长度不超过20个字符' required></td></tr>" +
                "<tr><td>专业:</td><td><input style='border: 0px' type='text' name='rs_major' maxlength='20' placeholder='长度不超过20个字符' required></td></tr>" +
                "<tr><td>学历：</td><td><input style='border: 0px' type='text' name='rs_education' maxlength='10' placeholder='长度不超过10个字符' required></td>" +
                "<td>入学时间：</td><td><input style='border: 0px' type='date' name='rs_enroll_date' required></td></tr>" +
                "<tr><td>毕业时间：</td><td><input style='border: 0px' type='date' name='rs_graduation_date' required></td></tr>" +
                "<tr><td>电话号码：</td><td><input style='border: 0px' type='text' value='<%=tourist.getT_phone()%>' required></td>" +
                "<td>E-MAIL：</td><td><input style='border: 0px' type='text' value=<%=tourist.getT_email()%> required></td></tr>" +
                "<tr><td>期望薪资：</td><td><input style='border: 0px' required type='text' maxlength='8' name='rs_salary'></td></tr>" +
                "<tr><td colspan='4' align='center'>经历</td></tr>" +
                "<tr><td colspan='4'><textarea name='rs_exprience' maxlength='225'/><input type='hidden' id='r_tid' name='t_id' value='<%=tourist.getT_id()%>'></td></tr>" +
                "<tr><td colspan='4' align='center' ><input type='submit' value='提交'></td></tr>" +
                "</table></form>")
            // $("#r_tid").val(r_tid);
        })
    })
</script>

</body>
</html>
