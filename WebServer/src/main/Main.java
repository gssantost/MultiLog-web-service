package main;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("/WebServer");
        tomcat.setPort(4000);
        Context ctx = null;
        try {
            ctx = tomcat.addWebapp("/multilog", System.getProperty("user.dir") + "\\" + "WebServer/web/WebApp");
        } catch (ServletException e) {
            e.printStackTrace();
        }
        Tomcat.addServlet(ctx, "LogsEndpoint", new LogsEndpoint());
        ctx.addServletMappingDecoded("/logs", "LogsEndpoint");
        tomcat.start();
        System.out.println("LoggerComponent Web Server listening...");
        tomcat.getServer().await();
    }

}
