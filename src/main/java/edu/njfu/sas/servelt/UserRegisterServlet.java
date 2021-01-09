package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.model.User;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/RegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取个人信息
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map map=new HashMap();
        if (username!=null&&password!=null) {
            User user = new User(username, password);
            UserDao userDao = new UserDaoImpl();
            boolean result = userDao.saveUser(user);

            if (result) {
                map.put("result","ok");
                map.put("msg","用户保存成功");
            }else{
                map.put("result","error");
                map.put("msg","用户保存失败");
            }
        }else {
            map.put("result","error");
            map.put("msg","用户保存失败2");
        }
        response.getWriter().write(
                new Gson().toJson(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
