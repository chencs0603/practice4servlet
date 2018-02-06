package personal.chencs.practice.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
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

        OutputStream output = resp.getOutputStream();
        output.write("hello servlet!!!".getBytes());
    }

    @Override
    public void destroy() {
        logger.debug("MyServlet destroy......");
        super.destroy();
    }

}
