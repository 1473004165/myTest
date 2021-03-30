package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询总记录数
     * @param cid
     * @param rname
     * @return
     */
    @Override
    public int findTotalCount(int cid, String rname) {
        //1.定义sql
        //String sql = "select count(*) from tab_route where cid = ?";
        String sql = "select count(*) from tab_route where 1 = 1 ";
        //拼接
        StringBuilder builder = new StringBuilder(sql);
        List<Object> list = new ArrayList<>();
        if (cid != 0){
            builder.append(" and cid = ? ");
            list.add(cid);
        }
        if (rname != null && rname.length() > 0 && !rname.equals("null")){
            builder.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        sql = builder.toString();
        //2.返回结果
        return template.queryForObject(sql,Integer.class,list.toArray());
    }

    /**
     * 分页查询显示数据
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public List<Route> findQuery(int cid, int start, int pageSize, String rname) {
        //1.定义sql
        //String sql = "select * from tab_route where cid = ? limit ? , ?";
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder builder = new StringBuilder(sql);
        //判断
        List<Object> list = new ArrayList<>();
        if (cid != 0){
            builder.append(" and cid = ? ");
            list.add(cid);
        }
        if (rname != null && rname.length() > 0 && !rname.equals("null")){
            builder.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        builder.append(" limit ? , ? ");
        list.add(start);
        list.add(pageSize);
        sql = builder.toString();
        //2.查询，返回结果集
        return template.query(sql,new BeanPropertyRowMapper<>(Route.class),list.toArray());
    }

    @Override
    public Route findRoute(int rid) {
        //1.定义sql
        String sql = "select * from tab_route where rid = ?";
        //2.查询
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Route.class),rid);
    }
}
