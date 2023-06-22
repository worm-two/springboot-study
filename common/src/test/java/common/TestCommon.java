package common;

import common.enums.ResultCode;
import common.result.ServiceResult;
import org.junit.jupiter.api.Test;

public class TestCommon {

    @Test
    public void test01() {
        Integer code = ResultCode.SUCCESS.getCode();
        System.out.println("code = " + code);
    }

    @Test
    public void test02() {
        ServiceResult ok = ServiceResult.ok();
        System.out.println("ok = " + ok);
    }
}
