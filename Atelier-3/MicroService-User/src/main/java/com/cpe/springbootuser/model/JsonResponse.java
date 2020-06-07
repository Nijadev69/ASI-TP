package com.cpe.springbootuser.model;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {

    private boolean error;
    private String msg;
    private Map<String, Object> data;

    public JsonResponse(){
        this.error = false;
        this.msg = "";
        this.data = new HashMap<>();
    }

    public JsonResponse(boolean error, String msg){
        this.error = error;
        this.msg = msg;
        this.data = new HashMap<>();
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
