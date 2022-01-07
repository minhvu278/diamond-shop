package DiamondShop.Dao;

import DiamondShop.Entity.Categories;
import DiamondShop.Entity.MapperCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriesDao extends BaseDao{

    public List<Categories> GetDataCategories() {
        List<Categories> list = new ArrayList<Categories>();
        String sql = "SELECT * FROM categories";
        list = _jdbcTemplate.query(sql, new MapperCategories());
        return list;
    }
}
