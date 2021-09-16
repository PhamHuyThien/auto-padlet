package com.thiendz.tool.autopadlet.util;

import java.net.MalformedURLException;
import java.net.URL;


public class RequestUtils {
    public static boolean isUrl(String url){
        try {
            URL u = new URL(url);
            return true;
        } catch (MalformedURLException e) {
        }
        return false;
    }
}
