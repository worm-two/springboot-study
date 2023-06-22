package util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    public static SqlSession getSqlSession() throws IOException {
        // 读取MyBatis核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(is);
        // 创建SqlSession对象，构造参数true表示所执行的SQL自动提交，无构造参数需手动提交
        return sqlSessionFactory.openSession(true);
    }
}

