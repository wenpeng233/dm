package base.dao;

import base.dao.mapper.BlogMapper;
import base.entity.Blog;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class BlogDao implements BlogMapper {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Blog> getBlogs() {
        try{
            BlogMapper blogMapper = sqlSessionFactory.openSession().getMapper(BlogMapper.class);
            return blogMapper.getBlogs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
