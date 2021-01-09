package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.Student;
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
import java.util.List;
import java.util.Map;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
//        System.out.println(userName);
        UserDaoImpl userDao = new UserDaoImpl();

        Map map = new HashMap();
        if (userName!=null){
            boolean result = false;
            result = userDao.getUser_by_username(userName);
            System.out.println(result);
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
        PrintWriter writer = response.getWriter();
        writer.write(new Gson().toJson(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
