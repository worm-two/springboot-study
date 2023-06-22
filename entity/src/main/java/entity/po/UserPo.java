package entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserPo {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
