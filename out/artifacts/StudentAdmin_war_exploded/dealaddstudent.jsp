<%@ page import="edu.njfu.sas.model.Student" %>
<%@ page import="edu.njfu.sas.dao.StudentDao" %>
<%@ page import="edu.njfu.sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/26
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
    <%
        /*获取学生信息
         */
        request.setCharacterEncoding("UTF-8");
        String stunum=request.getParameter("stunum");
        String stuname=request.getParameter("stuname");
        String classes=request.getParameter("classes");
        String gender=request.getParameter("gender");
        String department=request.getParameter("department");
        String tel=request.getParameter("tel");
        String document=request.getParameter("document");
        String photopath="./images/student/boy.jpg";
        if(gender.equals("女")){
            photopath="./images/student/girl.jpg";
        }
        String submit=request.getParameter("submit");
        System.out.println(submit);
        /*根据学生信息生成student对象
         */
        /*调用studentdao对象保存到数据库
         */
        Student student=new Student(stunum,stuname,classes,gender,department,tel,document,photopath);
        boolean result=false;
//        System.out.println(submit.equals("提交"));
//        System.out.println(submit!=null);


//        if (submit!=null&&submit.equals("提交"))
        {
            StudentDao stu=new StudentDaoImpl();
            result=stu.saveStudent(student);
            System.out.println(result);
            System.out.println(stu.toString());
            if (result){
                request.setAttribute("stunum",stunum);
                request.getRequestDispatcher("liststudents.jsp").forward(request,response);
            }
            else{
                response.sendRedirect("error.jsp");
            }
        }
        /*
        根据结果跳转
        成功跳转list student
        错误跳转错误页面
         */
    %>

