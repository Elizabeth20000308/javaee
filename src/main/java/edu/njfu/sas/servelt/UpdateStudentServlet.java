package edu.njfu.sas.servelt;

import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        Student student = (Student) request.getAttribute("student");
//            String submit =request.getParameter("submit");
            String stunum = request.getParameter("stunum");
            String stuname = request.getParameter("stuname");
            String gender = request.getParameter("gender");
            String classes = request.getParameter("classes");
            String tel = request.getParameter("tel");
            String department = request.getParameter("department");
            String document = request.getParameter("document");
            String photopath = request.getParameter("photopath");

        Student student = new Student(stunum, stuname, classes, gender, department, document, tel, photopath);
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        boolean result = studentDaoImpl.updateStudent(student);
        System.out.println(student);
        if (result)
            response.getWriter().write("success");
        else
            response.getWriter().write("error");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
