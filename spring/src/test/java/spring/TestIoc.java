package spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice.test.HelloWorld;

public class TestIoc {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        HelloWorld bean = applicationContext.getBean(HelloWorld.class);
        System.err.println(bean.sayHello("测试成功"));
    }
}
