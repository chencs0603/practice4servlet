package personal.chencs.practice.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: chencs
 * @date: 2018/3/5
 * @description:
 */
@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // 显示指定商品详情
        String id = req.getParameter("id");
        Book book = BookRespository.queryById(Integer.parseInt(id));
        if (null != book) {
            out.print(book.getName() + "</br>");
            out.print(book.getAuthor() + "</br>");
            out.print(book.getPrice() + "</br>");
            out.print(book.getDescription() + "</br>");
        }

        // 构建历史记录回写给浏览器
        String cookieValue = buildCookie(id, req);
        Cookie cookie = new Cookie("history", URLEncoder.encode(cookieValue, "UTF-8"));
        cookie.setMaxAge(1*24*3600);
        cookie.setPath("/book");
        resp.addCookie(cookie);
    }

    private String buildCookie(String id, HttpServletRequest request) throws UnsupportedEncodingException {
        int maxCookieLen = 3;

        // 获取已有的历史记录cookie
        Cookie[] cookies = request.getCookies();
        if (null == cookies || 0 == cookies.length) {
            return id;
        }
        String historyIds = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("history")) {
                historyIds = URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
        }
        // 历史记录为null
        if (null == historyIds) {
            return id;
        }

        LinkedList<String> ids = new LinkedList<>(Arrays.asList(historyIds.split("\\,")));
        // 历史记录中已经有
        if (ids.contains(id)) {
            ids.remove(id);
        } else {
            // 历史记录已经满了
            if (ids.size() >= maxCookieLen) {
                ids.removeLast();
            }
        }
        // 添加id到历史记录中
        ids.addFirst(id);

        StringBuffer result = new StringBuffer();
        for (String idb : ids) {
            result.append(idb + ",");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

}
