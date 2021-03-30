package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 校验用户名是否可用
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        //1.定义sql
        String sql = "select * from tab_user where username = ?";
        //2.查询结果集，返回对象
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User loginFind(User user) {
        //1.定义sql
        String sql = "select * from tab_user where username = ? and password = ?";
        //2.查询结果集，返回对象
        User u = null;
        try {
            u = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    user.getUsername(),
                    user.getPassword());
        }catch (Exception e){
            return null;
        }
        return u;
    }

    /**
     * 写入用户信息
     * @param user
     */
    @Override
    public void register(User user) {
        //1.定义sql
        String sql = "insert into tab_user (username,password,name,birthday,sex,telephone,email,status,code) values (?,?,?,?,?,?,?,?,?)";
        //2.执行sql更新数据
        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
    }

    /**
     * 通过激活码查询
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        //1.定义sql
        String sql = "select * from tab_user where code = ?";
        //2.查询结果集，返回对象
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    /**
     * 根据激活码激活
     * @param code
     */
    @Override
    public void active(String code) {
        //1.定义sql
        String sql = "update tab_user set status = 'Y' where code = ?";
        //2.执行sql，更新账户
        jdbcTemplate.update(sql,code);
    }
}
