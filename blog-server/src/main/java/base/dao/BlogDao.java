package base.dao;

import base.dao.mapper.BlogMapper;
import base.entity.Blog;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDao implements BlogMapper {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogs() {

        return blogMapper.getBlogs();
    }
}
