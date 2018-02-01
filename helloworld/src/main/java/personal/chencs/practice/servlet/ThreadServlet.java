package personal.chencs.practice.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chencs
 * @date: 2018/2/1
 * @description:
 */
@WebServlet(name = "threadServlet", urlPatterns = "/threadServlet")
public class ThreadServlet extends HttpServlet {

    private PrintWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        /**
         * 在浏览器中同时访问http://localhost:8080/threadServlet?username=chencs和
         * http://localhost:8080/threadServlet?username=chencs，
         * 则一个响应是空白，另一个是username:chencs username:ccs
         *
         * 解决方案：
         * 1、实现SingleThreadModel，以标记为过时接口;
         * 2、同步代码块synchronized，影响性能，不推荐;
         * 3、避免使用Servlet的实例变量，推荐。
         *    即PrintWriter writer从ThreadServlet的成员变量改成doGet方法的临时变量；
         */
        String username = req.getParameter("username");
        writer = resp.getWriter();

        try {
            // 为了突出并发问题，所以设置了延时
            Thread.sleep(5*1000);
            writer.println("username: " + username);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
