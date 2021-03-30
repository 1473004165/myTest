package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.ImageDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImageDaoImpl implements ImageDao {
    @Override
    public List<RouteImg> findRouteImg(int rid) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //1.定义sql
        String sql = "select * from tab_route_img where rid = ?";
        //2.查询结果
        return template.query(sql,new BeanPropertyRowMapper<>(RouteImg.class),rid);
    }
}
