package test.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import test.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper//启动时会扫描该注解的接口，动态生成代理类
@Component
public interface UserMapper {

    User selectById(Integer id);

    int insert(User user);

    //传入username, password，模糊匹配查询: 匹配开头
    //规定username传入的为带%，或不带%
    List<User> selectLike(@Param("username") String username,
                          @Param("password") String password,
                          @Param("orderBy") String orderBy);

    List<User> selectAll();

    int batchInsert(List<User> users);

    //自行实现
//    int update(User user);
//
//    int deleteById(Integer id);
}
