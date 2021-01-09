package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ListStudentServlet2")
public class ListStudentServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> allstudent= null;
        try {
            allstudent = studentDao.getAllStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("hi");
        //把学生数据转换为json
        Gson gson = new Gson();
        String students = gson.toJson(allstudent);
        response.getWriter().write(students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
