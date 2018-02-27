package personal.chencs.practice.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author: chencs
 * @date: 2018/2/7
 * @description:
 */
@WebServlet(name = "parameterServlet", urlPatterns = "/parameter")
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getParameter(req);
        System.out.println(req.getParameter("username"));
        getInputStream(req);

//        getReader(req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // 通过getParameter系列方法获取请求数据，应用范围：
    // 1、URL中携带的参数；
    // 2、表单提交的数据，但仅限于enctype是application/x-www-form-urlencoded
    private void getParameter(HttpServletRequest req) {
        // 根据参数名称获取对应的value值
        System.out.println(req.getParameter("username"));

        // 根据header名称获取对应的多个value值
        String[] usernames = req.getParameterValues("username");
        for (String username : usernames) {
            System.out.println(username);
        }

        // 先获取所有参数名称，然后遍历名称列表，根据名称获取对应的value值
        Enumeration<String > parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = req.getParameter(parameterName);
            System.out.println(parameterName + ":" + parameterValue);
        }

        // 先获取参数的map，其中参数名称为key，参数值为value，考虑了一个key可能对应多个value值，所有value的类型为String[]
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            for (String value : values) {
                System.out.println(key + ":" + value);
            }
        }
    }

    // getParameter与流这两种方式互斥，因为getParameter底层可能也是通过流方式获取数据，而流在读取完成后，将无法再被读取
    // 通过字节流获取请求数据，需要自行解析规定格式的字符串，已获取相关数据
    // 但是相对于getParameter方式应用更为广泛
    private void getInputStream(HttpServletRequest req) throws IOException {
        InputStream inputStream = req.getInputStream();
        int len = req.getContentLength();
        byte[] buffer = new byte[len];
        while (inputStream.read(buffer) == len) {
            System.out.println(new String(buffer));
        }
    }

    // 与字符流方式类似
    private void getReader(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
