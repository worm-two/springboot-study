package common.result;

import common.enums.ResultCode;
import common.utils.date.DateUtil;
import lombok.Data;

@Data
public class ServiceResult {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 响应数据
     */
    private Object data;

    public static ServiceResult ok() {
        ServiceResult result = new ServiceResult();
        result.setSuccess(ResultCode.SUCCESS.getSuccess());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setTimestamp(DateUtil.getTimeStamp());
        return result;
    }

    public static ServiceResult ok(Object data) {
        ServiceResult result = ok();
        result.setData(data);
        return result;
    }

    public static ServiceResult fail() {
        ServiceResult result = new ServiceResult();
        result.setSuccess(ResultCode.FAIL.getSuccess());
        result.setCode(ResultCode.FAIL.getCode());
        result.setMsg(ResultCode.FAIL.getMsg());
        result.setTimestamp(DateUtil.getTimeStamp());
        return result;
    }

    public ServiceResult setStatus(Integer code) {
        this.code = code;
        return this;
    }

    public ServiceResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ServiceResult setData(Object data) {
        this.data = data;
        return this;
    }
}
