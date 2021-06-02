package web.servlet;

import domain.PageBean;
import domain.UserBean;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取提交参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if("".equals(currentPage) || currentPage==null){
            currentPage = "1";
            rows = "5";
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用UserService
        UserService userService = new UserServiceImpl();
        PageBean<UserBean> pageBean = userService.findUserByPage(currentPage,rows,parameterMap);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
