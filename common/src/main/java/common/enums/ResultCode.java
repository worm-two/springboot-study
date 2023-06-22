package common.enums;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(true, 200, "请求成功"),
    REMOTE(false, 505, "远程请求失败"),
    EMPTY(true, 200, "查询数据为空"),
    FAIL(false, 500, "请求失败");

    /**
     * 是否成功
     */
    private final Boolean success;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 提示信息
     */
    private final String msg;

    ResultCode(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
