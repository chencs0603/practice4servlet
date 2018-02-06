package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chencs
 * @date: 2018/2/6
 * @description:
 */
@WebServlet(name = "responseServlet", urlPatterns = "/responseServlet")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendChinaDataOutputStream(resp);

    }

    private void sendChinaDataOutputStream(HttpServletResponse response) throws IOException {
        // 字节流
        String data = "中国";
        // 设置浏览器解析数据的解码方式
        response.setContentType("text/html;charset=utf-8");
        // 设置字符串转字节流的编码方式
        response.getOutputStream().write(data.getBytes("utf-8"));
    }

    private void sendChinaDataWriter(HttpServletResponse response) throws IOException {
        // 字符流
        String data = "中国";
        // 设置浏览器解析数据的解码方式
        response.setContentType("text/html;charset=utf-8");
        // 设置字符流的编码方式（字符流的底层实现是字节流）
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data);
    }


    private void sendData(HttpServletResponse response) throws IOException {
//        response.getOutputStream().write("data from the OutputStream of ResponseServlet".getBytes());
        response.getWriter().write("data from the Writer of ResponseServlet");
    }

}
