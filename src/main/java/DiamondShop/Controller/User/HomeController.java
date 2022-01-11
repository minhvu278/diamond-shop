package DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView Index() {
        _mvShare.addObject("sliders", _homeService.GetDataSlider());
        _mvShare.addObject("categories", _homeService.GetDataCategories());
        _mvShare.addObject("products", _homeService.GetDataProducts());
        _mvShare.setViewName("user/index");
        return _mvShare;
    }

    @RequestMapping(value = { "/product"})
    public ModelAndView Product() {
        ModelAndView mv = new ModelAndView("user/product");
        return mv;
    }
}
