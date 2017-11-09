package com.quhaodian.umall.data.vo;

import java.io.Serializable;

public class FileResponse implements Serializable {

    private int code;


    private String msg;


    private String url;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}