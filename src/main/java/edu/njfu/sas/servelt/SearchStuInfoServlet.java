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

@WebServlet("/SearchStuInfoServlet")
public class SearchStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String stuno = request.getParameter("stuno");
        System.out.println(stuno);
        System.out.println("It's OK!");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> allstudent= null;
        try {
            allstudent = studentDao.getStudentByNo(stuno);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //把学生数据转换为json
        Gson gson = new Gson();
        String students = gson.toJson(allstudent);
        System.out.println(students);
        response.getWriter().write(students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
