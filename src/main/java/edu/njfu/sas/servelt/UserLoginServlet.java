package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.dao.UserDao;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        //获取用户输入
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Map map = new HashMap();
        if (username!=null&&password!=null){
            //创建对象
            User user=new User(username,password);
            UserDao userDao = new UserDaoImpl();
            //验证密码
            boolean result = false;
            try {
                result = userDao.checkLogin(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (result){
                map.put("result","ok");
                map.put("msg","success");
            }else{
                map.put("result","false");
                map.put("msg","error");
            }

        }else{
            map.put("result","false");
            map.put("msg","error2");
        }
        writer.write(new Gson().toJson(map));

        //输出

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
