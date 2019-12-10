package filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Describe:HttpServletResponse的包装类
 *
 * @Author fuderong
 * @Date 2019/12/9
 * @Version 1.0
 */
public class ReplaceTextWrapper extends HttpServletResponseWrapper {
    private ReplaceTextStream tpStream;

    public ReplaceTextWrapper(ServletResponse inResp, String searchText, String replaceText) throws IOException {
        super((HttpServletResponse) inResp);
        this.tpStream = new ReplaceTextStream(inResp.getOutputStream(),searchText,replaceText);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return tpStream;
    }
}
