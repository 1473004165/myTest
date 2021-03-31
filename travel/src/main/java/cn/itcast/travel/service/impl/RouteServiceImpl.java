package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.ImageDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.ImageDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private final RouteDao routeDao = new RouteDaoImpl();
    private final SellerDao sellerDao = new SellerDaoImpl();
    private final ImageDao imageDao = new ImageDaoImpl();
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> findAll(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<>();
        //1.查询总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //2.计算总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        //3.计算start
        int start = (currentPage - 1) * pageSize;
        //4.查询list数据
        List<Route> list = routeDao.findQuery(cid, start, pageSize,rname);
        pageBean.setList(list);
        //5.返回
        return pageBean;
    }

    @Override
    public Route findDetail(int rid) {
        //1.查询route
        Route route = routeDao.findRoute(rid);
        //2.查询seller
        Seller seller = sellerDao.findSeller(route.getSid());
        route.setSeller(seller);
        //3.查询img
        List<RouteImg> routeImg = imageDao.findRouteImg(rid);
        route.setRouteImgList(routeImg);
        //4.返回
        int count = favoriteDao.findCount(rid);
        route.setCount(count);
        return route;
    }
}
