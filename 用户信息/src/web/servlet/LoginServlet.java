package web.servlet;

import domain.UserBean;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //0.判断验证码
        String checkCode = request.getParameter("verifyCode");
        //获取生成的验证码，并清除session
        HttpSession session = request.getSession();
        String checkCode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkCode.equalsIgnoreCase(checkCode_server)){
            //验证码不正确
            //设置相应消息
            request.setAttribute("checkCode_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //验证码正确
        //1.获取用户提交的数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装javabean
        UserBean user = new UserBean();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用Service
        UserService userService = new UserServiceImpl();
        UserBean login_user = userService.loginCheck(user);
        if(login_user!=null){
            //登陆成功，跳转findUserByPageServlet查询
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else {
            //登陆失败
            request.setAttribute("data_error","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
