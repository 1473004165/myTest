package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取id
        String[] ids = request.getParameterValues("id");
        if (ids == null || ids.length == 0){
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
            return;
        }
        //2.调用UserService
        UserService userService = new UserServiceImpl();
        userService.deleteUser(ids);
        //3.删除完成，跳转userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
