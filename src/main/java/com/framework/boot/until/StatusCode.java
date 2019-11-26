package com.example.demo.until;

public enum StatusCode {

    Success(0,"成功"),
    Fail(-1,"失败"),

    Invalid_Params(1000,"非法的参数"),
    Id_Not_Exist(1001,"id不存在"),
    Entity_Not_Exist(1002,"实体不存在");

    private Integer code;

    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
