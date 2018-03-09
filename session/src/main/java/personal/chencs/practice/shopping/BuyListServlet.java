package personal.chencs.practice.shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: chencs
 * @date: 2018/3/9
 * @description:
 */

@WebServlet("/book/buyList")
public class BuyListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (null == session) {
            out.print("没有购买任何商品");
        }
        List<String> buyList = (List<String>) session.getAttribute("buyList");
        if (null == buyList || 0 == buyList.size()) {
            out.print("没有购买任何商品");
        }

        out.print("购买商品如下：" + "</br>");
        for (String id : buyList) {
            out.print(BookRespository.queryById(Integer.parseInt(id)).getName() + "</br>");
        }

    }

}
