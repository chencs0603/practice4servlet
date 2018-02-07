package personal.chencs.practice.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author: chencs
 * @date: 2018/2/7
 * @description:
 */
@WebServlet(name = "imageServlet", urlPatterns = "/image")
public class ImageServlet extends HttpServlet {

    private final static int WIDTH = 120;
    private final static int HEIGHT = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();

        // 设置背景色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        // 设置边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(2, 1, WIDTH - 4, HEIGHT - 4);
        // 画干扰线
        for (int i = 0; i < 4; i++) {
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);

            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);

            graphics.drawLine(x1, y1, x2, y2);
        }
        // 写随机字符
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 20));

        String baseNum = "0123456789";
        int position = 5;
        for (int i = 0; i < 4; i++) {
            int degree = new Random().nextInt(30);
            String ch = baseNum.charAt(new Random().nextInt(baseNum.length())) + "";
            // 设置旋转角度
            ((Graphics2D) graphics).rotate(degree*Math.PI/180, position, 20);
            graphics.drawString(ch, position, 20);
            // 重置旋转角度，防止对下一个字符的影响
            ((Graphics2D) graphics).rotate(-degree*Math.PI/180, position, 20);
            position += 30;
        }
        // 写入response
        resp.setHeader("Content-Type", "image/jpeg");
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
    
}
