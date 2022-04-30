package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.base.BaseMapper;
import org.example.model.User;
import org.springframework.stereotype.Component;

@Mapper   //告诉框架该接口要生成代理类
@Component//将生成的代理类注册到容器中
/**
 * 该接口会自动生成动态代理类，该代理类实现JDBC的一套流程
 */
public interface UserMapper extends BaseMapper<User> {
    User query(String username);
}