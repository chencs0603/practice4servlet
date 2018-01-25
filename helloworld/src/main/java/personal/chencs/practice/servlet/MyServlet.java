package personal.chencs.practice.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: chencs
 * @date: 2018/1/23
 * @description:
 */
//@WebServlet(name = "myServlet", urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(MyServlet.class);

    @Override
    public void init() throws ServletException {
        logger.debug("MyServlet init......");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("MyServlet doGet......");

        // Refresh控制浏览器5秒后跳转到http://localhost:8080/
//        resp.setHeader("Refresh", "5;URL=http://localhost:8080/");

        // Content-Disposition控制浏览器以下载方式打开，默认文件名为test.txt
//        resp.setHeader("Content-Disposition", "attachment;filename=test.txt");

        String referer = req.getHeader("Referer");
        logger.debug("referer:{}", referer);

        OutputStream output = resp.getOutputStream();
        output.write("hello servlet!!!".getBytes());
    }

    @Override
    public void destroy() {
        logger.debug("MyServlet destroy......");
        super.destroy();
    }

}
