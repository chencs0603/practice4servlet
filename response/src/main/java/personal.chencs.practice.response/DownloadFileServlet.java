package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author: chencs
 * @date: 2018/2/6
 * @description:
 */
@WebServlet(name = "downloadFileServlet", urlPatterns = "/downloadFile")
public class DownloadFileServlet extends HttpServlet {

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

}
