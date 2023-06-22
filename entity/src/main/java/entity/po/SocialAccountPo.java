package entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * (SocialAccount)实体类
 *
 * @author makejava
 * @since 2023-02-18 11:05:07
 */
@Data
public class SocialAccountPo implements Serializable {

    private static final long serialVersionUID = 410944673950807979L;

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 账号
     */
    private Integer account;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 密码
     */
    private String password;
    /**
     * 金额
     */
    private Long money;
    /**
     * 类型
     */
    private String type;
    /**
     * 用户信息
     */
    private User user;
}

