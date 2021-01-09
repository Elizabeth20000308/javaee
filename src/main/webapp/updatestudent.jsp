<%@ page import="edu.njfu.sas.model.Student" %>
<%@ page import="edu.njfu.sas.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.njfu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="edu.njfu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/27
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./bootstrap-4.5.0-dist/css/bootstrap.css">
    <script  src="./js/jquery-3.4.1.min.js"></script>
</head>
<body>
<hr>
<h1 style="text-align: center">修改学生信息</h1>
<hr>
<%
    String stuno=request.getParameter("stuno");
    System.out.println(stuno);
    List<Student> student=null;
    if (stuno!=null){
        student= new StudentDaoImpl().getStudentByNo(stuno);
        System.out.println(student);
    }
    else{
        out.println("<script>alert('未获取到学生信息');" +
                "location:href='liststudents.jsp'</script>");
    }
%>

<%--<form id="form1" name="form1" method="get">--%>

    请输入学号<input type="text" id="stunum" name="stunum" value="<%=student.get(0).getStuNo()%>" disabled><br>
    请输入姓名<input type="text" id="stuname" name="stuname" value="<%=student.get(0).getStuName()%>"><br>
    请选中班级<select type="text" id="classes" name="classes">
                <option value="1808011">1808011</option>
                <option value="1808012">1808012</option>
                <option value="1808041">1808041</option>
                <option value="1808042">1808042</option>
            </select><br>
    请选择性别<select type="text" id="gender" name="gender">
                <option value="男">男</option>
                <option value="女">女</option>

            </select><br>
    请选择系部<select type="text" id="department" name="department">
                <option value="软件工程">软件工程</option>
                <option value="计算机科学与技术">计算机科学与技术</option>
            </select><br>
    请输入电话<input type="tel" id="tel" name="tel" value="<%=student.get(0).getTel()%>"><br>
    请选择宿舍<select type="text" id="document" name="document" >
                <option value="3309">3309</option>
                <option value="3310">3310</option>
                <option value="20617">20617</option>
                <option value="10123">10123</option>
                <option value="3419">3419</option>
                <option value="10408">10408</option>
                <option value="10409">10409</option>
                <option value="10410">10410</option>
                <option value="10411">10411</option>
                <option value="10130">10130</option>
                <option value="3420">3420</option>
            </select><br>
    <button type="submit" id="submit" name="submit" value="提交">提交修改<br>


<script>
    function addselected(elem,value) {
        var Options = elem.options;
        for (option of Options){
            if(option.value==value){
                option.selected=true;
            }
            console.log(option.valueOf());
        }
    }
    var classes=document.getElementById("classes");
    var docum=document.getElementById("document");
    var department=document.getElementById("department");
    var gender=document.getElementById("gender");
    addselected(classes,"<%=student.get(0).getClasses()%>");
    addselected(docum,"<%=student.get(0).getDormNo()%>");
    addselected(gender,"<%=student.get(0).getGender()%>");
    addselected(department,"<%=student.get(0).getDepartment()%>");

    $("#submit").click(function (){
        $.ajax({
            url: "UpdateStudentServlet",
            type: "POST",
            data: {
                "stunum":$("#stunum").val(),
                "stuname":$("#stuname").val(),
                "classes":$("#classes").val(),
                "gender":$("#gender").val(),
                "department":$("#department").val(),
                "tel":$("#tel").val(),
                "document":$("#document").val(),
                "photopath":"<%=student.get(0).getPhotoPath()%>"
            },
            //请求成功后执行回调函数
            success: function (data) {
                // var students = JSON.parse(data);
                console.log(data)
                if (data=="success"){
                    window.history.back(-1);
                }
                else{
                    alert("数据更新失败")
                }
            }
            , error: function () {
                console.log("wrong")
            }
        })
    })

</script>

<%
    //如何判断提交

//    if (submit!=null){
//        //stuno可以直接用
//        Student student1 = new Student(stunum,stuname,classes,gender,department,tel,document,student.get(0).getPhotoPath());
//        request.setAttribute("student",student1);
//        request.getRequestDispatcher("UpdateStudentServlet").forward(request,response);
//        //如果必须提交可以使用js，提交时修改disabled
//        //编写updatestudenet方法更新，
//        //根据update结果给出提示，成功跳转，失败跳转error
//    }
%>
</body>
</html>
