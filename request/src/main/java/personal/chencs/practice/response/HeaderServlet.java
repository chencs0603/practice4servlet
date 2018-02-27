package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: chencs
 * @date: 2018/2/7
 * @description:
 */
@WebServlet(name = "headerServlet", urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据header名称获取对应的value值
        System.out.println(req.getHeader("Accept-Encoding"));

        // 根据header名称获取对应的多个value值
        Enumeration<String> cookies = req.getHeaders("Cookie");
        while (cookies.hasMoreElements()) {
            System.out.println(cookies.nextElement());
        }

        // 先获取所有header名称，然后遍历header名称列表，根据名称获取对应的value值
        Enumeration<String > headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }
    }

}
