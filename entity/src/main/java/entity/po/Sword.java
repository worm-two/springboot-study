package entity.po;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sword {

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 称号
     */
    private String title;

    /**
     * 诗号
     */
    private String description;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 居住地
     */
    private String address;

    /**
     * 武器
     */
    private String weapon;

    /**
     * 退场词
     */
    private String death;

    /**
     * 语录
     */
    private String ana;

}
