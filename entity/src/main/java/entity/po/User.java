package entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-02-12 16:05:23
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 714135726837965972L;

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 性别
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;
    /**
     * 个人账号
     */
    private List<SocialAccountPo> socialAccounts;
}

