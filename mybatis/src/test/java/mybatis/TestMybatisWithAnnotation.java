package mybatis;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.PracticeApplication;
import practice.entity.po.User;
import practice.mapper.UserMapper;

import javax.annotation.Resource;

@SpringBootTest(classes = PracticeApplication.class)
public class TestMybatisWithAnnotation {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {
        User user = userMapper.selectUserById(1);
        System.out.println("user = " + user);
    }
}
