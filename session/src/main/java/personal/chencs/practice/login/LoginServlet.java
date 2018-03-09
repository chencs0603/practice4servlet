package personal.chencs.practice.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chencs
 * @date: 2018/3/9
 * @description:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (null == username || null == password) {
            out.print("请输入用户名和密码");
        }
        if ("chencs".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.sendRedirect("/index.jsp");
        }
        out.print("用户名或密码错误");
    }

}
