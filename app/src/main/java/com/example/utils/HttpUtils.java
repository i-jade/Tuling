package com.example.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;

public class HttpUtils {
    private static final String URL ="http://openapi.tuling123.com/openapi/api/v2";
    private static final String API_KEY = "70a0658164fc41c1881d8e2d78726682";
    public static String doGet(String msg){
        String result = "";
        HttpURLConnection conn = null ;
        InputStream is = null ;
        ByteArrayOutputStream baos = null ;

        String url = setParams(msg);
        java.net.URL urlNet = null;
        try {
            urlNet = new java.net.URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            conn = (HttpURLConnection) urlNet.openConnection();
            conn.setReadTimeout(5*1000);
            conn.setConnectTimeout(5*1000);
            conn.setRequestMethod("GET");

            is = conn.getInputStream();
            int len = -1 ;
            byte[] buf = new byte[128];
            baos = new ByteArrayOutputStream() ;

            while((len=is.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            baos.flush();
            result = new String(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos!=null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result ;
    }

    private static String setParams( String msg) {
        String url = null;
        try {
            url = URL+ "?key="+API_KEY+"&info="+ URLEncoder.encode(msg,"UTF_8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url ;
    }
}
