package cn.itcast.travel.web.servlet.user;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.web.servlet.RootServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends RootServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ResultInfo resultInfo = new ResultInfo();

    /**
     * 注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取验证码
        String check = request.getParameter("check");
        //2.获取session中的验证码
        HttpSession session = request.getSession();
        String checked_server = (String) session.getAttribute("CHECKED_SERVER");
        //3.校验
        if (check==null || check.equalsIgnoreCase(checked_server)){
            //验证码正确,或者为失去焦点异步请求
            //4.获取请求参数
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            //4.1 判断属于blur异步请求还是表单提交
            if (user.getName()==null){
                //blur异步请求,调用Service
                UserService userService = new UserServiceImpl();
                User u = userService.checkUsername(user.getUsername());
                if (u == null){
                    //该用户名可用
                    resultInfo.setFlag(true);
                }else {
                    //该用户名不可用
                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("用户名已被注册");
                }
            }else {
                //表单提交
                session.removeAttribute("CHECKED_SERVER");//CHECKED_SERVER
                UserService userService = new UserServiceImpl();
                boolean flag = userService.register(user);
                if (flag){
                    resultInfo.setFlag(true);
                }else {
                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("用户名已被注册");
                }
            }
        }else {
            //验证码错误
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
        }
        String json = objectMapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 激活
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String code = request.getParameter("code");
        //2.校验code是否为空
        if (code == null){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("别给老子乱点");
            String json = objectMapper.writeValueAsString(resultInfo);
            response.getWriter().write(json);
        }else {
            //激活码不为空，进行service层判断
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            if (flag) {
                //响应信息，请登录
                response.getWriter().write("您已激活成功，请<a href=\"http://localhost/travel/login.html\">登录</a>");
            }else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("激活失败，请联系管理员");
                String json = objectMapper.writeValueAsString(resultInfo);
                response.getWriter().write(json);
            }
        }
    }

    /**
     * 查询登陆状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findLoginStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session信息
        User user = (User) request.getSession().getAttribute("user");
        if (user ==null){
            user = new User();
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getWriter(),user);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //0.判断验证码
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checked_server = (String) session.getAttribute("CHECKED_SERVER");
        session.removeAttribute("CHECKED_SERVER");
        if (check != null && !check.equalsIgnoreCase(checked_server)){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
        }else {
            //1.设置字符集
            request.setCharacterEncoding("utf-8");
            //2.获取请求参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            //3.封装javaBean
            User user = new User();
            try {
                BeanUtils.populate(user, parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            //4.调用Service
            UserService service = new UserServiceImpl();
            User u = service.login(user);
            if (u == null) {
                //用户名或密码错误
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户名或密码错误");
            } else if (u.getStatus().equals("N")) {
                //账户未激活
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("您的账户尚未激活");
            } else {
                //登陆成功
                resultInfo.setFlag(true);
                session.setAttribute("user", u);
            }
        }
        //5.响应信息
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getWriter(),resultInfo);
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
}
