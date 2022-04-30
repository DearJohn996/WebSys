package test.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import test.example.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {

    //1对1映射，一个文章关联1个用户
    List<Article> selectAll();
}
