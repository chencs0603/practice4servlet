package personal.chencs.practice.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: chencs
 * @date: 2018/3/5
 * @description:
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("上次访问时间：");

        HttpSession session = req.getSession();
        String name = "lastAccessTime";

        String lastAccessTime = (String) session.getAttribute(name);
        // 时间格式化
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = format.format(new Date());
        // 更新时间
        session.setAttribute(name, currentTime);
        if (null != lastAccessTime) {
            out.write(lastAccessTime);
        }
    }

}
