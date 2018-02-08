package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/2/8
 * @description:
 */
@WebServlet(name = "refreshServlet", urlPatterns = "/refresh")
public class RefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        freshPage1(resp);

        freshPage2(req, resp);
    }

    private void freshPage1(HttpServletResponse response) throws IOException {
        // refresh用于刷新与页面跳转，即3秒后refresh页面自动跳转到index页面
        response.setHeader("refresh", "3;/message.jsp");
        response.getWriter().write("refresh to the message page in 3 second ......");
    }

    private void freshPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 利用HTML的meta标签的http-equ和content属性可以控制浏览器实现刷新和页面跳转，即3秒后message页面自动跳转到index.jsp
        String message = "<meta http-equiv='refresh' content='3; url=/index.jsp' /> refresh to the index page in 3 second ......";
        this.getServletContext().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

}
