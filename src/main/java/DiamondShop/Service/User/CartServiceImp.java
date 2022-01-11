package DiamondShop.Service.User;

import DiamondShop.Dao.CartDao;
import DiamondShop.Dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartServiceImp implements ICartService{
    @Autowired
    private CartDao cartDao = new CartDao();

    @Override
    public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
        return cartDao.AddCart(id, cart);
    }

    @Override
    public HashMap<Long, CartDto> EditCart(long id, int qty, HashMap<Long, CartDto> cart) {
        return cartDao.EditCart(id, qty, cart);
    }

    @Override
    public HashMap<Long, CartDto> DeleteCart(long id, int qty, HashMap<Long, CartDto> cart) {
        return cartDao.DeleteCart(id, qty, cart);
    }

    @Override
    public int TotalQty(HashMap<Long, CartDto> cart) {
        return cartDao.TotalQty(cart);
    }

    @Override
    public double TotalPrice(HashMap<Long, CartDto> cart) {
        return cartDao.TotalPrice(cart);
    }

}
