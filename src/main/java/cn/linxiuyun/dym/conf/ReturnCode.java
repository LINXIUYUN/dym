package cn.linxiuyun.dym.conf;

public enum  ReturnCode {

    OK(0,"成功"),
    PARAM_FAILURE(101,"参数错误"),
    FAIL(102,"操作失败"),
    VERIFY_FAIL(103,"验证失败"),
    PROHIBITION(104,"权限不足"),
    EXCEPTION(105,"系统异常"),
    UPLOAD_FAIL(106,"文件存储失败");


    private int code;
    private String description;

    ReturnCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
