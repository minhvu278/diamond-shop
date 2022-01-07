package DiamondShop.Service.User;

import DiamondShop.Dto.ProductsDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Entity.Menus;
import DiamondShop.Entity.Sliders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    @Autowired
    public List<Sliders> GetDataSlider();

    public List<Categories> GetDataCategories();

    public List<Menus> GetDataMenus();

    public List<ProductsDto> GetDataProducts();
}
