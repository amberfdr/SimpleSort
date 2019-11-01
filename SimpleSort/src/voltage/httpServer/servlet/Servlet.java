package voltage.httpServer.servlet;

import java.io.OutputStream;

public interface Servlet {
    public void init() throws Exception;
    public void service(byte[] requestBuffer, OutputStream out) throws  Exception;
}
