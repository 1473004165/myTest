package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

import java.util.Date;

public class FavoriteServiceImpl implements FavoriteService {


    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public Favorite findIfColl(String rid, int uid) {
        return favoriteDao.findIfColl(Integer.parseInt(rid),uid);
    }

    @Override
    public void addColl(String rid, Date date, int uid) {
        favoriteDao.addColl(Integer.parseInt(rid),date,uid);
    }
}
