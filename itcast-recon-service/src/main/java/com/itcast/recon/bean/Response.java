package com.itcast.recon.bean;


import java.io.Serializable;

/**
 * 名称: Response.java <br>
 * 描述: 响应信息<br>
 * 最近修改时间:2017/12/29 11:27 <br>
 *
 * @author YuanZhou
 * @version [版本号, V1.0]
 * @since 2017/12/29 11:27
 */
public class Response<T> implements Serializable {

    private boolean success = true;

    private String message;

    private String code;

    private T data;

    public Response() {
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
