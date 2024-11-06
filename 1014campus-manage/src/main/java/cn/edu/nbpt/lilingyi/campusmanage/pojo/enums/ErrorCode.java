package cn.edu.nbpt.lilingyi.campusmanage.pojo.enums;

public enum ErrorCode {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    LIST_EMPTY(501, "列表长度为0"),
    FORBIDDEN(503, "未成年人禁止访问"),
    PARAMS_ERROR(504,"参数不合法"),
    NULL(502, "内容为空"),
    UPDATE_ERROR(506, "更新失败"),
    FILE_STORAGE_ERROR(507,"文件操作失败"),
    FILE_NOT_FOUND(508,"文件未找到");

    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
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
