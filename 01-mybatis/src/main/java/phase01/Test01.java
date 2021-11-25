package phase01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import phase01.dao.UserDao;
import phase01.dao.UserDaoImpl;
import phase01.po.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author csy
 * @createTime 2021-11-25
 * @Description phase01 test
 */
public class Test01 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        // 加载全局配置文件（同时把映射文件也加载了）
        String resource = "phase01/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById(){
        UserDao dao = new UserDaoImpl(sqlSessionFactory);
        User user = dao.findUserById(2L);
        System.out.println(user);
    }
}
