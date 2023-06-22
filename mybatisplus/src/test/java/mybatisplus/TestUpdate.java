package mybatisplus;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.PracticeApplication;
import practice.entity.po.UserPo;
import practice.mapper.UserMapper;
import practice.service.UserService;

@SpringBootTest(classes = PracticeApplication.class)
public class TestUpdate {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void test01() {

        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //组装set子句以及修改条件
        UpdateWrapper<UserPo> updateWrapper = new UpdateWrapper<>();
        //lambda表达式内的逻辑优先运算
        updateWrapper
                .set("age", 18)
                .set("email", "user@atguigu.com")
                .like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        //这里必须要创建User对象，否则无法应用自动填充。如果没有自动填充，可以设置为null
        //UPDATE t_user SET username=?, age=?,email=? WHERE (username LIKE ? AND
        //        (age > ? OR email IS NULL))
        //User user = new User();
        //user.setName("张三");

        //int result = userMapper.update(user, updateWrapper);
        //UPDATE t_user SET age=?,email=? WHERE (username LIKE ? AND (age > ? OR
        //        email IS NULL))
        int result = userMapper.update(null, updateWrapper);
        System.out.println(result);
    }

    @Test
    public void test02() {
        //组装set子句
        LambdaUpdateWrapper<UserPo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(UserPo::getAge, 18)
                .set(UserPo::getEmail, "user@atguigu.com")
                .like(UserPo::getName, "a")
                .and(i -> i.lt(UserPo::getAge, 24).or().isNull(UserPo::getEmail)); //lambda表达式内的逻辑优先运算
        UserPo user = new UserPo();
        int result = userMapper.update(user, updateWrapper);
        System.out.println("受影响的行数：" + result);

    }
}
