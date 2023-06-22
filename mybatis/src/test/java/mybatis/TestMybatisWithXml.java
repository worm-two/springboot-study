package mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import practice.entity.po.SocialAccountPo;
import practice.entity.po.User;
import practice.mapper.UserMapper;
import practice.utils.MybatisUtil;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatisWithXml {

    @Test
    public void test01() throws Exception {
        // 读取MyBatis核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(is);
        // 创建SqlSession对象，构造参数true表示所执行的SQL自动提交，无构造参数需手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用Mapper接口的方法，通过代理对象执行标签内的SQL语句
        User user = mapper.selectUserById(1);
        System.out.println("user = " + user);
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SocialAccountPo socialAccount = mapper.selectAccountByAssociation(3);
        System.out.println("socialAccount = " + socialAccount);
    }

    @Test
    public void test03() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SocialAccountPo socialAccount = mapper.selectAccountByStep(5);
        System.out.println("socialAccount = " + socialAccount);
    }

    @Test
    public void test04() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByCollection(1);
        System.out.println("user = " + user);
    }

    @Test
    public void test05() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByStep(2);
        System.out.println("user = " + user);
    }
    @Test
    public void test06() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Object  o= sqlSession.selectOne("people.mapper.UserMapper.selectUserByStep",2);
        System.out.println("o = " + o);
    }

}
