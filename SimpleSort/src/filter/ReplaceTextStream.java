package filter;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Describe:ServletOutputStream的包装类
 *
 * @Author fuderong
 * @Date 2019/12/9
 * @Version 1.0
 */
public class ReplaceTextStream extends ServletOutputStream {
    /**
     * 由Servlet容器提供的ServletOutputStream对象
     */
    private ServletOutputStream intStream;
    /**
     * 充当NoteServlet生成的响应结果缓存
     */
    private ByteArrayOutputStream baStream;
    private boolean closed = false;
    /**
     * 需要被替换的旧的字符串
     */
    private String oldStr;
    /**
     * 替换后的字符串
     */
    private String newStr;

    public ReplaceTextStream(ServletOutputStream intStream, String oldStr, String newStr) {
        this.intStream = intStream;
        baStream = new ByteArrayOutputStream();
        this.oldStr = oldStr;
        this.newStr = newStr;
    }

    @Override
    public void write(int b) throws IOException {

    }
    @Override
    public void print(String s) throws IOException {
        s = s+"/n";
        byte[] bytes = s.getBytes();
        baStream.write(bytes);
    }

    @Override
    public void flush() throws IOException {
        if(baStream.size() != 0){
            if(!closed){
                processStream();
                baStream = new ByteArrayOutputStream();
            }
        }
    }

    @Override
    public void close() throws IOException {
        if(!closed){
            processStream();
            intStream.close();
            closed = true;
        }
    }

    public void processStream() throws IOException {
        intStream.write(replaceContent(baStream.toByteArray()));
        intStream.flush();
    }

    public byte[] replaceContent(byte[] intBytes){
        String retVal = "";
        String firstPart = "";
        String tpString = new String(intBytes);
        String srchString = (new String(intBytes)).toLowerCase();
        int endBody = srchString.indexOf(oldStr);
        if(endBody != -1){
            firstPart = srchString.substring(0,endBody);
            retVal = firstPart + newStr + tpString.substring(endBody+oldStr.length());
        }else{
            retVal = tpString;
        }
        return retVal.getBytes();
    }

}
