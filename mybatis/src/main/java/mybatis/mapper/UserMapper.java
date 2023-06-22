package mybatis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import practice.entity.po.SocialAccountPo;
import practice.entity.po.User;
import practice.entity.po.UserPo;

@Mapper
public interface UserMapper extends BaseMapper<UserPo> {

    @Select("select * from user where id=#{id}")
    User selectUserById(Integer id);

    SocialAccountPo selectAccountByAssociation(@Param("id") Integer id);

    SocialAccountPo selectAccountByStep(@Param("id") Integer id);

    User selectUserByCollection(@Param("userId") Integer userId);

    @Select("select id, account, user_id, password, money, type from social_account where user_id=#{userId}")
    SocialAccountPo selectSocialAccountByUserId(@Param("userId") Integer userId);

    User selectUserByStep(@Param("userId") Integer userId);
}
