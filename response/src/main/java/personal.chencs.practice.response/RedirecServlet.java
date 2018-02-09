package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/2/9
 * @description:
 */
@WebServlet(name = "redirectServlet", urlPatterns = "/redirect")
public class RedirecServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(HttpServletResponse.SC_FOUND);
//        resp.setHeader("location", "/index.jsp");

        resp.sendRedirect("/index.jsp");
    }
}
