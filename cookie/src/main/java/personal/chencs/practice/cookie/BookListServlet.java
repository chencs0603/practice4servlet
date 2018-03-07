package personal.chencs.practice.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author: chencs
 * @date: 2018/3/5
 * @description:
 */
@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        // 显示所有商品
        out.print("<h2>本网站有如下商品：</h2>");
        List<Book> bookList = BookRespository.queryAll();
        for (Book book : bookList) {
            out.print("<a href='/book/detail?id=" + book.getId() + "'>" + book.getName() + "</></br>");
        }

        // 历史浏览记录
        out.print("<h2>历史浏览记录如下：</h2>");
        Cookie[] cookies = req.getCookies();
        if (null == cookies || 0 == cookies.length) {
            return;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("history")) {
                String[] ids = URLDecoder.decode(cookie.getValue(), "UTF-8").split("\\,");
                for (String id : ids) {
                    out.print(BookRespository.queryById(Integer.parseInt(id)).getName() + "</br>");
                }
            }
        }

    }

}
