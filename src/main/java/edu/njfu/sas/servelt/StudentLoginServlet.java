package edu.njfu.sas.servelt;

import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class StudentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户提交的数据
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        UserDaoImpl userDao = new UserDaoImpl();
        boolean result = false;
        result = userDao.checkUser(user);
        if (result){
            System.out.println("login_success");
            request.getRequestDispatcher("/liststudents.jsp").forward(request,response);
        }else{
            PrintWriter out=response.getWriter();
            out.write("<script>alert('登陆失败');</script>");

        }
        //创建user
        //验证使用userdao来验证
        //页面跳转
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
