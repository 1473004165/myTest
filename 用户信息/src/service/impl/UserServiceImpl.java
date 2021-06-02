package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.UserBean;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserBean loginCheck(UserBean user) {
        //调用UserDao方法查询
        return userDao.loginCheck(user);
    }

    @Override
    public List<UserBean> findAllUsers() {
        //调用userDao方法查询
        return userDao.findAllUsers();
    }

    @Override
    public int add(UserBean user) {
        //调用UserDao
        return userDao.add(user);
    }

    @Override
    public void deleteUser(String[] id) {
        //调用UserDao
        for (String s : id) {
            userDao.deleteUser(Integer.parseInt(s));
        }
    }

    @Override
    public UserBean findUserById(String id) {
        //调用UserDao
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void update(UserBean user) {
        //调用UserDao
        userDao.update(user);
    }

    @Override
    public PageBean<UserBean> findUserByPage(String currentPage, String rows,Map<String, String[]> condition) {
        //创建空的PageBean对象
        PageBean<UserBean> pageBean = new PageBean<>();
        //1.调用UserDao查询总记录数
        int totalCount = userDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //计算开始
        int start = (Integer.parseInt(currentPage)-1)*Integer.parseInt(rows);
        List<UserBean> list = userDao.findByPage(start,Integer.parseInt(rows),condition);
        //计算总页数
        int totalPage = totalCount%5==0?totalCount/5:totalCount/5+1;
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.setCurrentPage(Integer.parseInt(currentPage));
        pageBean.setRows(Integer.parseInt(rows));
        return pageBean;
    }
}
