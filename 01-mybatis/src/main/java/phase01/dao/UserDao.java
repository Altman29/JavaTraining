package phase01.dao;

import phase01.po.User;

/**
 * @author csy
 * @createTime 2021-11-25
 * @Description dao
 */
public interface UserDao {
    User findUserById(Long id);
}
