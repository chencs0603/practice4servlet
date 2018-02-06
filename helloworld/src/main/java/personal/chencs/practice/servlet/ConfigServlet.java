package personal.chencs.practice.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: chencs
 * @date: 2018/2/2
 * @description:
 */
public class ConfigServlet extends HttpServlet {

//    private ServletConfig config;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String data = this.getServletConfig().getInitParameter("data");

        String data = getInitParameter("data");

        OutputStream output = resp.getOutputStream();
        output.write(data.getBytes());
    }

}
