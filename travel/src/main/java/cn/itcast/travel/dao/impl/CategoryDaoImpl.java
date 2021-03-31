package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有索引
     * @return
     */
    @Override
    public List<Category> findAll() {
        //1.定义sql
        String sql = "select * from tab_category";
        //2.查询结果集，返回
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
