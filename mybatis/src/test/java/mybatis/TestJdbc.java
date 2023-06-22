package mybatis;


import org.junit.jupiter.api.Test;
import practice.entity.po.User;

import java.sql.*;

public class TestJdbc {

    @Test
    public void test01() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 通过驱动管理类获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.2.5:3306/dog?useSSL=true&useUnicode=true&characterEncoding=UTF-8", "root", "root");
        // 定义sql语句，？表示占位符
        String sql = "select * from user where id=?";
        // 获取预处理statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        // 向数据库发出sql查询操作，查询出结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历查询的结果集
        User user = new User();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSex(resultSet.getString("sex"));
            user.setAge(resultSet.getInt("age"));
            user.setAddress(resultSet.getString("address"));
        }
        System.out.println("user = " + user);
    }
}
