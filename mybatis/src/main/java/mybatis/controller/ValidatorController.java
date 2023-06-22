package mybatis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.ServiceResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import practice.entity.param.PersonParam;
import practice.entity.po.UserPo;
import practice.mapper.UserMapper;
import practice.service.UserService;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("validator")
@Validated
public class ValidatorController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    @PostMapping
    public ServiceResult check(@RequestBody @Valid PersonParam param) {

        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", param.getName());
        queryWrapper.ge("age", param.getAge());

        List<UserPo> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

        return ServiceResult.ok(users);
    }

    @GetMapping
    public ServiceResult testGet(@NotNull(message = "参数不能为空") String name) {
        return ServiceResult.ok(name + ",hello world");
    }
}
