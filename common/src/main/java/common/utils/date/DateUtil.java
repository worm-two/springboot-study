package common.utils.date;

import java.time.Instant;

public class DateUtil {

    public static Long getTimeStamp() {
        return Instant.now().toEpochMilli();
    }
}
