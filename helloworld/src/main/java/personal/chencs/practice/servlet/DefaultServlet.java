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
@WebServlet(name = "defaultServlet", urlPatterns = "/")
public class DefaultServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("DefaultServlet doGet......");

        OutputStream output = resp.getOutputStream();
        output.write("hello DefaultServlet!!!".getBytes());
    }

}
