package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

import java.util.Date;

public interface FavoriteDao {

    Favorite findIfColl(int rid, int uid);

    void addColl(int parseInt, Date date, int uid);

    int findCount(int rid);
}
