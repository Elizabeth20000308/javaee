package edu.njfu.sas.servelt;

import edu.njfu.sas.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String stuno = request.getParameter("stuno");
        System.out.println("-------------------"+stuno);
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        boolean result = studentDaoImpl.deleteStudentByStuno(stuno);
//        boolean result=true;
        String string=null;
        if (result){
            string="success";
        }else{
            string="error";
        }
        response.getWriter().write(string);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
