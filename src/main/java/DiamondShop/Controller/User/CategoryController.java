package DiamondShop.Controller.User;

import DiamondShop.Dto.PaginatesDto;
import DiamondShop.Service.User.CategoryServiceImp;
import DiamondShop.Service.User.PaginatesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController{

    @Autowired
    private CategoryServiceImp categoryService;

    @Autowired
    private PaginatesServiceImp paginateService;


    @RequestMapping(value = "/san-pham/{id}")
    public ModelAndView Product(@PathVariable String id) {
        _mvShare.setViewName("user/products/category");

        int totalData = categoryService.GetAllProductsById(Integer.parseInt(id)).size();
        PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, 9, 1);
        _mvShare.addObject("paginateInfo", paginateInfo);
        _mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(paginateInfo.getStart(), paginateInfo.getEnd()));
        return _mvShare;
    }
}