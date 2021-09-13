package service;

import domain.PageBean;
import domain.UserBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 用户登录认证方法
     * @param user：封装好的user对象
     */
    UserBean loginCheck(UserBean user);

    /**
     * 查询记录
     */
    List<UserBean> findAllUsers();

    /**
     * 添加数据的方法
     * @param user:封装好的user对象
     */
    int add(UserBean user);

    /**
     * 删除数据方法
     * @param id:封装好的user对象id
     */
    void deleteUser(String[] id);

    /**
     * 根据id查询
     * @param id:封装好的user对象id
     */
    UserBean findUserById(String id);

    /**
     * 更新数据方法
     * @param user:封装好的user对象
     */
    void update(UserBean user);

    /**
     * 分页查询
     * @param currentPage：当前页码
     * @param rows：每页显示条数
     */
    PageBean<UserBean> findUserByPage(String currentPage, String rows,Map<String, String[]> condition);
}
