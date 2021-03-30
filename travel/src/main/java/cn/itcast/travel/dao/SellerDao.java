package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据rid查询商家信息
     * @param rid
     * @return
     */
    public Seller findSeller(int rid);
}
