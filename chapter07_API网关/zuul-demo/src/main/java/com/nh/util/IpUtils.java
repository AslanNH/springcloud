package com.nh.util;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
    public static String getIpAddr(HttpServletRequest request) {

        //http://127.0.0.1:2103/nh
        String path = request.getRequestURL().toString();
        String ip = path.substring(path.indexOf("//")+2,path.lastIndexOf(":"));
        return ip;
    }
}
