package cn.itcast.travel.web.servlet.category;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import cn.itcast.travel.web.servlet.RootServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends RootServlet {
    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询索引
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = service.findAll();
        //序列化json
        WriteValue(categories,response);
    }


}
