package mypack;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *  * Describe:动态生成图像
 *  *
 *  * @Author fuderong
 * @Date 2019/11/21
 * @Version 1.0
 */
public class ImageServlet extends HttpServlet {
    private Font font = new Font("Courier",Font.BOLD,12);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到待显示的数字
        String count = req.getParameter("count");
        if(count == null){
            count = "1";
        }
        int len = count.length();
        // 设置响应正文的类型
        resp.setContentType("image/jpeg");
        ServletOutputStream out = resp.getOutputStream();
        // 创建一个位于缓冲区的图像 长11*len高16
        BufferedImage image = new BufferedImage(11*len,16,BufferedImage.TYPE_INT_RGB);
        // 获得一个画笔
        Graphics g = image.getGraphics();
        // 画一个黑色的矩形，长11*len,高16
        g.setColor(Color.BLACK);
        g.fillRect(0,0,11*len,16);
        g.setColor(Color.WHITE);
        g.setFont(font);

        char c;
        for(int i = 0;i < len;i++){
            c = count.charAt(i);
            // 写一个白色的数字
            g.drawString(c+" ",i*11+1,12);
            g.drawLine((i+1)*11-1,0,(i+1)*11-1,16);
        }
        // 过时  com.sun.image.codec.jpeg.JPEGImageEncoder已过时，缺少这个包，编译出错
        // 输出JPEG格式的图片
        // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        // 对图像进行jpeg格式编码，并且利用out输出图像
        // encoder.encode(image);
        ImageIO.write(image,"JPEG",out);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
