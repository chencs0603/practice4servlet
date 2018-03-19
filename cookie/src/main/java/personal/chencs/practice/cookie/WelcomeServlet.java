package personal.chencs.practice.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chencs
 * @date: 2018/3/8
 * @description:
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        req.getSession();

        // 重写URL，当浏览器禁用cookie时，可以通过URL带上jsessionid来实现session
        String sessionURL = resp.encodeURL("/session");

        out.print("<a href='" + sessionURL + "'>session</a>");
    }

}
