package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface ImageDao {

    /**
     * 查询商品图片
     * @param rid
     * @return
     */
    public List<RouteImg> findRouteImg(int rid);
}
