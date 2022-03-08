package com.sckj.springboot.entity;

public class JsonResult<T> {

    private T data;
    private String code;
    private String msg;

    public JsonResult(){
        this.code="0";
        this.msg="操作成功";
    }

    public JsonResult(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    /**
     * 默认信息操作成功
     * @param data
     */
    public JsonResult(T data){
        this.data=data;
        this.code="0";
        this.msg= "操作成功";
    }

    public JsonResult(T data,String msg){
        this.data=data;
        this.code="0";
        this.msg= msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
