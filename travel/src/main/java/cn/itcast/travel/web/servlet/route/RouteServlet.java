package cn.itcast.travel.web.servlet.route;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.web.servlet.RootServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/route/*")
public class RouteServlet extends RootServlet {
    private final RouteService service = new RouteServiceImpl();
    private final FavoriteService favoriteService = new FavoriteServiceImpl();

    public void findQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        request.setCharacterEncoding("utf-8");
        String cid_str = request.getParameter("cid");
        String currentPage_str = request.getParameter("currentPage");
        String pageSize_str = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        if (rname != null) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }
        //2.转换参数
        int cid = 0;
        int currentPage;
        int pageSize;
        if (cid_str != null && cid_str.length() > 0 && !cid_str.equals("null")){
            cid = Integer.parseInt(cid_str);
        }
        if (currentPage_str != null && currentPage_str.length() > 0){
            currentPage = Integer.parseInt(currentPage_str);
        }else {
            currentPage = 1;
        }
        if (pageSize_str != null && pageSize_str.length() > 0){
            pageSize = Integer.parseInt(pageSize_str);
        }else {
            pageSize = 10;
        }
        //3.查询结果集
        PageBean<Route> pageBean = service.findAll(cid, currentPage, pageSize,rname);
        WriteValue(pageBean,response);
    }

    /**
     * 查询详细内容
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String rid_str = request.getParameter("rid");
        int rid = Integer.parseInt(rid_str);
        //2.调用service
        Route route = service.findDetail(rid);
        //3.回写信息
        WriteValue(route,response);
    }

    /**
     * 查询路线是否被收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findIfColl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //未登录
            return;
        }
        Favorite favorite = favoriteService.findIfColl(rid, user.getUid());
        Boolean flag = (favorite != null);
        WriteValue(flag,response);
    }

    /**
     * 添加收藏方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addColl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        favoriteService.addColl(rid,new Date(),user.getUid());
    }
}
