package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/15
 * @Version 1.0
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("SimpleSort is initialized.");
        ServletContext context = servletContextEvent.getServletContext();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResourceAsStream("/count/count.txt")));
            int count = Integer.parseInt(reader.readLine());
            reader.close();
            Counter counter = new Counter(count);
            context.setAttribute("counter",counter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("SimpleSort is destoryed");
        ServletContext context = servletContextEvent.getServletContext();
        Counter counter = (Counter)context.getAttribute("counter");
        if(counter != null){
            try {
                String filepath = context.getRealPath("/count");
                filepath = filepath+"/count.txt";
                PrintWriter pw = new PrintWriter(filepath);
                pw.println(counter.getCount());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
