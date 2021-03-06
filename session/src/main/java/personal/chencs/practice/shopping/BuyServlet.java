package personal.chencs.practice.shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chencs
 * @date: 2018/3/9
 * @description:
 */
@WebServlet("/book/buy")
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");

        HttpSession session = req.getSession();
        List<String> buyList = (List<String >) session.getAttribute("buyList");
        if (null == buyList) {
            buyList = new ArrayList<>();
        }
        if (!buyList.contains(id)) {
            buyList.add(id);
        }

        session.setAttribute("buyList", buyList);

        resp.sendRedirect("/book/buyList");
    }

}
