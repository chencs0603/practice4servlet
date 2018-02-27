package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/2/7
 * @description:
 */
@WebServlet(name = "clientServlet", urlPatterns = "/client")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http请求的完整URL
        System.out.println("URL:" + req.getRequestURL());
        // http请求的请求行的资源名（不包括参数部分）
        System.out.println("URI:" + req.getRequestURI());

        // http://ServerName：Port/ContextPath/URI = URL
        System.out.println("http://ServerName：Port/ContextPath/URI:" + "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + req.getRequestURI());

        System.out.println("Scheme:" + req.getScheme());
        System.out.println("ServerName:" + req.getServerName());
        System.out.println("ContextPath:" + req.getContextPath());
        System.out.println("ServletPath:" + req.getServletPath());

        // http请求的请求行的参数部分，格式：key=value
        System.out.println("QueryString:" + req.getQueryString());

        // http请求的客户机的IP、主机名和端口号
        System.out.println("RemoteAddr:" + req.getRemoteAddr());
        System.out.println("RemoteHost:" + req.getRemoteHost());
        System.out.println("RemotePort:" + req.getRemotePort());

        // http请求的服务器的IP、主机名和端口号
        System.out.println("LocalName:" + req.getLocalName());
        System.out.println("LocalAddr:" + req.getLocalAddr());
        System.out.println("LocalPort:" + req.getLocalPort());

        // http请求的请求方式
        System.out.println("Method:" + req.getMethod());
    }

}
