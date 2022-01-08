package DiamondShop.Service.User;

import DiamondShop.Dto.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    public List<ProductsDto> GetAllProductsById(int id);

    public List<ProductsDto> GetDataProductsPaginate(int start, int end);
}
