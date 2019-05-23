<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/21
  Time: 15:25
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
    <c:if test="${not empty sessionScope.trainEmps}">
        <div>
            <table>
                <tr>
                    <th>主题</th>
                    <th>内容</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>地点</th>
                    <th>员工姓名</th>
                    <th>状态</th>
                    <th>删除</th>
                    <th>更新</th>
                    <th>添加人员</th>
                </tr>

                <c:forEach items="${sessionScope.trainEmps}" var="train1" >
                <tr>
                    <td>${train1.train.tr_title}</td>
                    <td>${train1.train.tr_context}</td>
                    <td>${train1.train.tr_start_time}</td>
                    <td>${train1.train.tr_end_time}</td>
                    <td>${train1.train.tr_address}</td>
                    <c:forEach items="${train1.employees}" var="emp" >
                        <td>${emp.emp_name}</td>
                    </c:forEach>
                    <td>${train1.train.tr_is_publish}</td>

                    <c:if test="${train1.train.tr_is_publish=='未发布'}">

                        <td>
                            <form action="deleteTrain" method="post">
                                <input type="hidden" name="tr_id" value="${train1.train.tr_id}">
                                <input type="submit" value="删除">
                            </form>
                        </td>
                        <td>
                            <form action="updateTrain" method="post">
                                <input type="hidden" name="tr_id" value="${train1.train.tr_id}">
                                <input type="hidden" name="tr_title" value="${train1.train.tr_title}">
                                <input type="hidden" name="tr_context" value="${train1.train.tr_context}">
                                <input type="hidden" name="tr_start_time" value="${train1.train.tr_start_time}">
                                <input type="hidden" name="tr_end_time" value="${train1.train.tr_end_time}">
                                <input type="hidden" name="tr_address" value="${train1.train.tr_address}">
                                <input type="hidden" name="tr_is_publish" value="未发布">
                                <input type="submit" value="撤销">
                            </form>
                        </td>
                    </c:if>
                    <td>
                        <input type="button" value="更新" class="update">
                        <script>
                            $(function () {
                                $(".update").click(function () {
                                    $("#content").append(
                                        "<form action='updateTrain' method='post'>"+
                                        "<input type='hidden' name='tr_id' value='${train1.train.tr_id}'>"+
                                        "主题：<input type='text' name='tr_title' value='${train1.train.tr_title}'>"+
                                        "内容：<input type='text' name='tr_context' value='${train1.train.tr_context}'>"+
                                        "开始时间：<input type='datetime-local' name='tr_start_time' value='${train1.train.tr_start_time}'>"+
                                        "结束时间：<input type='datetime-local' name='tr_end_time' value='${train1.train.tr_end_time}'>"+
                                        "地点：<input type='text' name='tr_address' value='${train1.train.tr_address}'>"+
                                        "<input type='hidden' name='tr_is_publish' value='${train1.train.tr_is_publish}'>"+
                                        "<input type='submit' value='更新'>"+
                                        "</form>")
                                })
                            })
                        </script>
                    </td>
                    <td>
                        <input type="hidden" name="tr_id" value="${train1.train.tr_id}">
                        <input type="button" name="emps" value=" 添加人员" class="addEmp">
                    </td>
                </tr>
                </c:forEach>

                <tr>
                    <td colspan="10">
                        <form action="addTrain" method="post">
                            　　主题：<input type="text" name="tr_title">
                            　　内容：<input type="text" name="tr_context">
                            开始时间：<input type="date" name="tr_start_time">
                                    <input type="time" name="time1">
                            结束时间：<input type="date" name="tr_end_time">
                                    <input type="time" name="time2">
                            　　地点：<input type="text" name="tr_address">
                            　　　　　<input type="hidden" name="tr_is_publish" value="未发布">
                            <input type="submit" value="添加培训">
                        </form>
                    </td>

                </tr>
            </table>
        </div>
        </c:if>
<c:if test="${empty sessionScope.trainEmps}">
    <h3>暂时没有记录</h3>
    <table>
        <tr>
            <td colspan="10">
                <form action="addTrain" method="post">
                    　　主题：<input type="text" name="tr_title">
                    　　内容：<input type="text" name="tr_context">
                    开始时间：<input type="date" name="tr_start_time">
                              <input type="time" name="time1">
                    结束时间：<input type="date" name="tr_end_time">
                              <input type="time" name="time2">
                    　　地点：<input type="text" name="tr_address">
                    　　　　　<input type="hidden" name="tr_is_publish" value="未发布">
                    <input type="submit" value="添加培训">
                </form>
            </td>
        </tr>
    </table>
</c:if>
<div id="content">

</div>

<div hidden id="nav">
  <select id="dep_id">

  </select>
  <select id="pos_id">

  </select>

  <form action="addTrainRecord" method="post" id="emp_id">
    <input type="hidden" name="tr_id" value="" id="tr">
    <input type="submit" value="添加">
  </form>
</div>

    <script>
        $(function () {
            $(".addEmp").click(function () {
                $("#nav").show();
                var i=$(this).prev().val();
                $("#tr").val(i);
            })
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
                            employee.append("<input type='checkbox' name='emp_id' value='"+data[i]['emp_id']+"'/>"+data[i]['emp_name']);
                        }
                    }
                });
            });
        })
    </script>
</body>
</html>
