package mypack;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
    //当jsp解析器遇到hello标签的结束标志时，调用此方法
    public int doEndTag() throws JspTagException {
        try {
            pageContext.getOut().print("Hello");
        } catch (Exception e) {
            e.printStackTrace();
            throw  new JspTagException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
