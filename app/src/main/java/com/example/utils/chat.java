package com.example.utils;

public class chat {

    public static final int TYPE_RECEIVE = 0 ;
    public static final int TYPR_SENT=1 ;

    private String text ;
    private int type ;

    public  chat(String text , int type){
        this.text = text;
        this.type = type ;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toSting(){
        return "ChatLiatData{" +
                "text='" + text + '\'' +
                ", type=" + type +
                '}';
    }
}
