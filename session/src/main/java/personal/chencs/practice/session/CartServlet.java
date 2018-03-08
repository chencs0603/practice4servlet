package personal.chencs.practice.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/3/8
 * @description:
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        // 设置sessionid的有效期
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setMaxAge(10);
        cookie.setPath("/");
        resp.addCookie(cookie);

        session.setAttribute("cart", "book");

    }

}
