package DiamondShop.Service.User;

import DiamondShop.Dao.CategoriesDao;
import DiamondShop.Dao.MenuDao;
import DiamondShop.Dao.ProductsDao;
import DiamondShop.Dto.ProductsDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Dao.SliderDao;
import DiamondShop.Entity.Menus;
import DiamondShop.Entity.Sliders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImp implements IHomeService {
    @Autowired
    private SliderDao sliderDao;
    @Autowired
    private CategoriesDao categoriesDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private ProductsDao productsDao;

    @Override
    public List<Sliders> GetDataSlider() {
        return sliderDao.GetDataSlider();
    }

    public List<Categories> GetDataCategories() {
        return categoriesDao.GetDataCategories();
    }

    public List<Menus> GetDataMenus() {
        return menuDao.GetDataMenus();
    }

    public List<ProductsDto> GetDataProducts() {
        List<ProductsDto> listProducts = productsDao.GetDataProducts();
        return listProducts;
    }
}
