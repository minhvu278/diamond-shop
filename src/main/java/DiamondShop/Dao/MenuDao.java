package DiamondShop.Dao;

import DiamondShop.Entity.Categories;
import DiamondShop.Entity.MapperCategories;
import DiamondShop.Entity.MapperMenus;
import DiamondShop.Entity.Menus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDao extends BaseDao{

    public List<Menus> GetDataMenus() {
        List<Menus> list = new ArrayList<Menus>();
        String sql = "SELECT * FROM menus";
        list = _jdbcTemplate.query(sql, new MapperMenus());
        return list;
    }
}