package DiamondShop.Service.User;

import DiamondShop.Dto.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public ProductsDto GetProductById(long id);

    public List<ProductsDto> GetProductByIdCategory(int id);
}
