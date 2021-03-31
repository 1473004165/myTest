package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询商家信息
     * @param rid
     * @return
     */
    @Override
    public Seller findSeller(int rid) {
        //1.定义sql
        String sql = "select * from tab_seller where sid = ?";
        //2.查询
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Seller.class),rid);
    }
}
