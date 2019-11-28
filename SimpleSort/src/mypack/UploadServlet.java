package mypack;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Describe:文件上传
 *
 * @Author fuderong
 * @Date 2019/11/18
 * @Version 1.0
 */
public class UploadServlet extends HttpServlet {
    /**
     * 存放上传文件的目录
     */
    private String filePath;
    /**
     * 存放临时文件的目录
     */
    private String tempFilePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //读取初始化参数
        filePath = config.getInitParameter("filePath");
        tempFilePath = config.getInitParameter("tempFilePath");
        filePath = getServletContext().getRealPath(filePath);
        tempFilePath = getServletContext().getRealPath(tempFilePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        // 创建一个基于硬盘的FileItem工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置向硬盘写数据时所用的缓冲区的大小，此处为4k
        factory.setSizeThreshold(4*1024);
        // 设置临时目录
        factory.setRepository(new File(tempFilePath));
        // 创建一个文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置允许上传文件的最大尺寸，此处为4M
        upload.setSizeMax(4*1024*1024);
        try {
            // ServletFileUpload类的parseRequest(HttpServletRequest req)方法能够解析HttpServletRequest对象中的复合表单数据
            List items = upload.parseRequest(req);
            Iterator iterator = items.iterator();
            while(iterator.hasNext()){
                FileItem item = (FileItem)iterator.next();
                if(item.isFormField()){
                    //处理普通表单域
                    processFormFiled(item,out);
                }else{
                    //处理上传的文件
                    processUploadFile(item,out);

                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    private void processFormFiled(FileItem item,PrintWriter out){
        // 获取表单域的名字
        String name = item.getFieldName();
        // 获取表单域值
        String value = item.getString();
        out.println(name+":"+value+"\r\n");
    }
    private void processUploadFile(FileItem item,PrintWriter out) throws Exception {
        // 获取包括路径在内的文件名字
        String filename = item.getName();
        int index = filename.lastIndexOf("\\");
        // 获得不包含路径的文件名字
        filename = filename.substring(index+1,filename.length());
        // 获得文件的大小
        long filesize = item.getSize();
        if("".equals(filename) && filesize == 0){
            return;
        }
        File uploadFile = new File(filePath+"/"+filename);
        // 把文件保存到本地硬盘
        item.write(uploadFile);
        out.println(filename+" is saved");
        out.println("The size of "+filename+" is "+filesize);
    }
}
