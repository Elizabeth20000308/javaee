<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/26
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <h1>添加学生</h1>
<form id="form1" name="form1" method="get" action="dealaddstudent.jsp">
    请输入学号<input type="text" id="stunum" name="stunum"><br>
    请输入姓名<input type="text" id="stuname" name="stuname"><br>
    请选中班级<select type="text" id="classes" name="classes"><br>
                <option value="1808011">1808011</option>
                <option value="1808012">1808012</option>
                <option value="1808041">1808041</option>
                <option value="1808042">1808042</option>
            </select><br>
    请选择性别<select type="text" id="gender" name="gender"><br>
                <option value="男">男</option>
                <option value="女">女</option>
            </select><br>
    请选择系部<select type="text" id="department" name="department">
                <option value="软件工程">软件工程</option>
                <option value="计算机科学与技术">计算机科学与技术</option>
            </select><br>
    请输入电话<input type="tel" id="tel" name="tel"><br>
    请选择宿舍<select type="text" id="document" name="document">
                <option value="3309">3309</option>
                <option value="3310">3310</option>
            </select><br>
    <input type="submit" id="submit" name="submit" value="提交"><br>

</form>


</body>
</html>
