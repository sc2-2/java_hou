package com.sckj.springboot.exception;

/**
 * 自定义业务异常
 */
public class BusinessErrorException extends RuntimeException{

    private static  final  long serialVersionUID=-7480022450501760611L;

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum){
        this.code=businessMsgEnum.getCode();
        this.message=businessMsgEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
