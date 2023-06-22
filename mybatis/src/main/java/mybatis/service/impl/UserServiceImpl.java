package mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import practice.entity.po.UserPo;
import practice.mapper.UserMapper;
import practice.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {
}
