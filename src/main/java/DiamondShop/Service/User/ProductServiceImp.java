package DiamondShop.Service.User;

import DiamondShop.Dao.ProductsDao;
import DiamondShop.Dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService{

    @Autowired
    ProductsDao productsDao = new ProductsDao();

    @Override
    public ProductsDto GetProductById(long id) {
        List<ProductsDto> listProducts = productsDao.GetProductById(id);
        return listProducts.get(0);
    }

    @Override
    public List<ProductsDto> GetProductByIdCategory(int id) {
        return productsDao.GetAllProductsById(id);
    }
}
