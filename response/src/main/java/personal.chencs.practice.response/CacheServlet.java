package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/2/9
 * @description:
 */
@WebServlet(name = "cacheServlet", urlPatterns = "/cache")
public class CacheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 通过expires设置过期时间，可以控制浏览器进行缓存
         * 下面缓存10秒中，连续两次（10秒钟内）打开/cache页面，后面一次取的是缓存数据
         * 刷新页面取的不是缓存数据
         */
        resp.setDateHeader("expires", System.currentTimeMillis() + 1000*10);
        resp.getWriter().write("the data will cache 10 second");
    }
}
