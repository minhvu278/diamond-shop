package DiamondShop.Service.User;

import DiamondShop.Dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ICartService {
    public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart);

    public HashMap<Long, CartDto> EditCart(long id, int qty, HashMap<Long, CartDto> cart);

    public HashMap<Long, CartDto> DeleteCart(long id, int qty, HashMap<Long, CartDto> cart);

    public int TotalQty(HashMap<Long, CartDto> cart);

    public double TotalPrice(HashMap<Long, CartDto> cart);
}
