package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;

import java.util.Date;

public interface FavoriteService {
    Favorite findIfColl(String rid, int uid);

    void addColl(String rid, Date date, int uid);
}
