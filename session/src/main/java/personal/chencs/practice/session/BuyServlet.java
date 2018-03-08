package personal.chencs.practice.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chencs
 * @date: 2018/3/8
 * @description:
 */
@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("your shopping list:");
        HttpSession session = req.getSession(false);
        if (null == session) {
            return;
        }
        String cart = (String) session.getAttribute("cart");
        if (null != cart) {
            out.write(cart);
        }
    }

}
