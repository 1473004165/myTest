package dao;

import domain.UserBean;

import java.util.List;
import java.util.Map;

public interface UserDao {
    UserBean loginCheck(UserBean user);

    List<UserBean> findAllUsers();

    int add(UserBean user);

    void deleteUser(int id);

    UserBean findUserById(int id);

    void update(UserBean user);

    int findTotalCount(Map<String, String[]> condition);

    List<UserBean> findByPage(int start, int rows,Map<String, String[]> condition);
}
