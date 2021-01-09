<%@ page import="edu.njfu.sas.dao.StudentDao" %>
<%@ page import="edu.njfu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.njfu.sas.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/12
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表展示</title>
    <link rel="stylesheet" href="css/style2.css" >
</head>
<body>
<hr>
    <form method="get">
        请输入姓名：<input type="text" id="userName" name="userName">
        <input type="submit" id="submit" name="submit" value="提交">
    </form>

<hr>
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>班级</td>
        <td>性别</td>
        <td>专业</td>
        <td>电话</td>
        <td>宿舍</td>
        <td>照片</td>
        <td>操作</td>

    </tr>
<%
    request.setCharacterEncoding("UTF-8");
    String submit = request.getParameter("submit");

    StudentDao sdao=new StudentDaoImpl() ;
    List<Student>student=null;
    if (submit!=null&&submit.equals("提交")){
        //查询
        //获取字符串，返回查询结果
        String name=request.getParameter("userName");
        System.out.println(name);
        student=sdao.getStudentByName(name);
    }else{
        student=sdao.getAllStudent();
    }

    for (Student s:student){
%>
    <tr>
        <td><%=s.getStuNo()%></td>
        <td><%=s.getStuName()%></td>
        <td><%=s.getClasses()%></td>
        <td><%=s.getGender()%></td>
        <td><%=s.getDepartment()%></td>
        <td><%=s.getTel()%></td>
        <td><%=s.getDormNo()%></td>
        <td><img src="<%=s.getPhotoPath()%>" width="50px"></td>
        <td>
            <a href="updatestudent.jsp?stuno=<%=s.getStuNo()%>">删除</a>
        </td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
