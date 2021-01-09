<%@ page import="edu.njfu.sas.dao.StudentDao" %>
<%@ page import="edu.njfu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.njfu.sas.model.Student" %>
<%@ page import="edu.njfu.sas.util.Pageutil" %><%--
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
    //获取分页信息
    String page1=request.getParameter("page");
    int pageSize=10;
    long totalCount =0;
    int currentPage=0;
    if (page1==null){
        page1="1";//初始值设置为第一页
    }
    currentPage=Integer.parseInt(page1);
    StudentDao sdao=new StudentDaoImpl() ;
    totalCount =sdao.countToString();
    //获取并优化记录数，保存到request中
    Object totals=request.getAttribute("total");
    if (totals==null){
        totalCount =sdao.countToString();
        request.setAttribute("tatals", totalCount);
    }else{
        totalCount =(Long)totals;
    }
    //创建PageUtil对象
    Pageutil pageutil = new Pageutil(currentPage, totalCount,pageSize);
    System.out.println(pageutil.getMaxPage());


    List<Student>student=sdao.getStudentByPage(currentPage,pageSize);
//    if (submit!=null&&submit.equals("提交")){
//        //查询
//        //获取字符串，返回查询结果
//        String name=request.getParameter("userName");
//        System.out.println(name);
//        student=sdao.getStudentByName(name);
//    }else{
//        student=sdao.getAllStudent();
//    }

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
<hr>
<%@include file="page.jsp"%>
<%--<jsp:include page="page.jsp"></jsp:include>--%>
</body>
</html>
