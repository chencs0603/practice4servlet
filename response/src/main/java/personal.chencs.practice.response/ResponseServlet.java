package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author: chencs
 * @date: 2018/2/6
 * @description:
 */
@WebServlet(name = "responseServlet", urlPatterns = "/responseServlet")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        downloadFile(resp);

    }

    private void downloadFile(HttpServletResponse response) throws IOException {
        String path = this.getServletContext().getRealPath("//images//海.jpg");
        String fileName = path.substring(path.lastIndexOf("\\") + 1);

        // 设置以下载方式打开文件，并设置默认文件名，文件名中出现中文，为防止中文乱码，需要URL编码
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(path);
            outputStream = response.getOutputStream();
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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
