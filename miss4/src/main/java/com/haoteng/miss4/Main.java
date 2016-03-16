package com.haoteng.miss4;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * strat tomcat
 * Created by Administrator on 2016/3/15.
 */
public class Main {
    public static void startTomcat() throws ServletException, LifecycleException, UnsupportedEncodingException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        String path = new File("").getAbsolutePath();
        tomcat.addWebapp("/", URLDecoder.decode(path,"UTF-8")+"\\miss4\\target\\miss4");
        tomcat.start();
        tomcat.getServer().await();
    }
    public static  void  main(String[] arg) throws ServletException, LifecycleException, UnsupportedEncodingException {
        startTomcat();
    }
}
