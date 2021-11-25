package phase01.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import phase01.po.User;

/**
 * @author csy
 * @createTime 2021-11-25
 * @Description impl
 */
public class UserDaoImpl implements UserDao{

    private SqlSessionFactory sqlSessionFactory;

    //注入SqlSessionFactory(不应该在Dao这里创建，谁调用dao谁注入一个工厂)
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(Long id) {
        //SqlSessionFactory工厂类去创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession接口，开发人员使用它来对数据库进行CRUD操作(mybatis提供的重要的接口)
        User user = sqlSession.selectOne("test.findUserById", id);//statement映射文件里的唯一标识，入参
        return user;
    }
}
