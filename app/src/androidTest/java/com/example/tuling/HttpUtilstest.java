package com.example.tuling;

import android.util.Log;

import com.example.utils.HttpUtils;

import org.junit.Test;

public class HttpUtilstest<test> {
    private String TAG = "this is a test";
    @Test
    public void testSendInfo()
    {
        String res = HttpUtils.doGet("给我讲个笑话");
        Log.i("TAG",res);
        res =HttpUtils.doGet("给我讲个鬼故事");
        Log.i("TAG",res);
        res = HttpUtils.doGet("hello");
        Log.i("TAG",res);
        res = HttpUtils.doGet("你真美");
        Log.i("TAG",res);


    }
}
