package cn.linxiuyun.dym.base;

import cn.linxiuyun.dym.conf.ReturnCode;

public class BaseResponse {

    private int code;
    private String msg;
    private String detailMsg;
    private Object responseBody;

    public BaseResponse() {
    }

    public BaseResponse(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.msg = returnCode.getDescription();
    }

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

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", detailMsg='" + detailMsg + '\'' +
                ", responseBody=" + responseBody +
                '}';
    }
}
