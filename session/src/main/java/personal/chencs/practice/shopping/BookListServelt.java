package personal.chencs.practice.shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: chencs
 * @date: 2018/3/9
 * @description:
 */
@WebServlet("/book/list")
public class BookListServelt extends HttpServlet {

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
            out.print(book.getName() + "&nbsp;<a href='/book/buy?id=" + book.getId() + "'>" + "购买" + "</a></br>");
        }
    }

}
