package dao.impl;

import dao.UserDao;
import domain.UserBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private final DataSource dataSource = JDBCUtils.getDataSource();
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Override
    public UserBean loginCheck(UserBean user) {
        //定义sql
        String sql = "select * from userBox where username = ? and password = ?";
        //执行并封装
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(UserBean.class),
                    user.getUsername(),
                    user.getPassword()
            );
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<UserBean> findAllUsers() {
        //定义sql
        String sql = "select * from userBox";
        //执行sql并封装
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserBean.class));
    }

    @Override
    public int add(UserBean user) {
        //1.定义sql
        String sql = "insert into userBox (name,gender,age,address,qq,email,username,password) values (?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,
                    user.getName(),
                    user.getGender(),
                    user.getAge(),
                    user.getAddress(),
                    user.getQq(),
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword()
            );
        return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public void deleteUser(int id) {
        //1.定义sql
        String sql = "delete from userBox where id = ?";
        //2.执行sql
        jdbcTemplate.update(sql,id);
    }

    @Override
    public UserBean findUserById(int id) {
        //1.定义sql
        String sql = "select * from userBox where id = ?";
        //2.查询并封装javaBean
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserBean.class), id);

    }

    @Override
    public void update(UserBean user) {
        //1.定义sql
        String sql = "update userBox set gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        //2.更新数据
        jdbcTemplate.update(sql,
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail(),
                user.getId()
        );
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义sql
        String sql = "select count(*) from userBox where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> list;
        list = new ArrayList<>();
        Set<String> keySet = condition.keySet();
        iter(condition, stringBuilder, list, keySet);
        return jdbcTemplate.queryForObject(stringBuilder.toString(),Integer.class,list.toArray());
    }

    private void iter(Map<String, String[]> condition, StringBuilder stringBuilder, List<Object> list, Set<String> keySet) {
        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value!=null && !value.equals("")){
                stringBuilder.append(" and ").append(key).append(" like ? ");
                list.add("%"+value+"%");
            }
        }
    }

    @Override
    public List<UserBean> findByPage(int start,int rows,Map<String, String[]> condition) {
        //1.定义sql
        String sql = "select * from userBox where 1=1 ";
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder(sql);
        List<Object> list = new ArrayList<>();
        Set<String> keySet;
        keySet = condition.keySet();
        iter(condition, stringBuilder, list, keySet);
        list.add(start);
        list.add(rows);
        stringBuilder.append(" limit ?, ? ");
        //2.查询结果并封装list
        return jdbcTemplate.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(UserBean.class),list.toArray());
    }
}
