package DiamondShop.Service.User;

import DiamondShop.Dao.ProductsDao;
import DiamondShop.Dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements ICategoryService{

    @Autowired
    private ProductsDao productsDao;
    @Override
    public List<ProductsDto> GetAllProductsById(int id) {
        return productsDao.GetAllProductsById(id);
    }

    @Override
    public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
        return productsDao.GetDataProductsPaginate( id, start, totalPage);
    }
}
