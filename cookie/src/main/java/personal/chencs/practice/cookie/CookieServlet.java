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
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: chencs
 * @date: 2018/3/5
 * @description:
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("上次访问时间：");

        // 获取时间cookie
        String cookieName = "lastAccessTime";
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++){
            if (cookies[i].getName().equals(cookieName)) {
                String cookieValue = cookies[i].getValue();
                out.print(URLDecoder.decode(cookieValue, "UTF-8"));
            }
        }

        // 时间格式化
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = format.format(new Date());
        // 特别注意：cookie值中不能包含特殊字符（等号、空格、分号等），需要进行URL编码
        Cookie cookie = new Cookie(cookieName, URLEncoder.encode(currentTime, "UTF-8"));
        cookie.setMaxAge(7*24*3600);
        cookie.setPath("/");

        resp.addCookie(cookie);
    }

}
