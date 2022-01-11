package DiamondShop.Dao;

import DiamondShop.Dto.CartDto;
import DiamondShop.Dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDao extends BaseDao{

    @Autowired
    ProductsDao productsDao = new ProductsDao();

    public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
        CartDto itemCart = new CartDto();
        ProductsDto product = productsDao.FindGetProductById(id);
        if (product != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQty(itemCart.getQty() + 1);
            itemCart.setTotalPrice(itemCart.getQty() * itemCart.getProduct().getPrice());
        }
        else {
            itemCart.setProduct(product);
            itemCart.setQty(1);
            itemCart.setTotalPrice(product.getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDto> EditCart(long id, int qty, HashMap<Long, CartDto> cart) {
        if (cart == null) {
            return cart;
        }
        CartDto itemCart = new CartDto();
        if (cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQty(qty);
            double totalPrice = qty * itemCart.getProduct().getPrice();
            itemCart.setTotalPrice(totalPrice);
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDto> DeleteCart(long id, int qty, HashMap<Long, CartDto> cart) {
        if (cart == null) {
            return cart;
        }
        if (cart.containsKey(id)){
            cart.remove(id);
        }
        return cart;
    }

    public int TotalQty(HashMap<Long, CartDto> cart) {
        int totalQty = 0;
        for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
            totalQty += itemCart.getValue().getQty();
        }
        return totalQty;
    }

    public double TotalPrice(HashMap<Long, CartDto> cart) {
        double totalPrice = 0;
        for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
            totalPrice += itemCart.getValue().getTotalPrice();
        }
        return totalPrice;
    }
}
