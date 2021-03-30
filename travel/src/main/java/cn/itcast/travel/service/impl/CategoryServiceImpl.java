package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.查询redis
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> categories = jedis.zrangeWithScores("category", 0, -1);
        List<Category> category = null;
        //2.判断redis是否有数据
        if (categories == null || categories.size() == 0){
            //redis中没有缓存,从数据库查询
            category = categoryDao.findAll();
            //将数据存入缓存
            for (Category one : category) {
                jedis.zadd("category",one.getCid(),one.getCname());
            }
        }else {
            //有缓存
            category = new ArrayList<Category>();
            //将缓存的数据存入list
            for (Tuple set : categories) {
                Category c = new Category();
                c.setCname(set.getElement());
                c.setCid((int)set.getScore());
                category.add(c);
            }
        }
        //返回数据
        return category;
    }
}
