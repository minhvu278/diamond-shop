package DiamondShop.Dao;

import DiamondShop.Dto.ProductDtoMapper;
import DiamondShop.Dto.ProductsDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDao extends BaseDao{

    private final boolean YES = true;
    private final boolean NO = false;

    private StringBuffer SqlString() {
        StringBuffer  sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("p.id as id_product ");
        sql.append(", p.cat_id ");
        sql.append(", p.sizes ");
        sql.append(", p.name ");
        sql.append(", p.price ");
        sql.append(", p.sale ");
        sql.append(", p.title ");
        sql.append(", p.highlight ");
        sql.append(", p.new_product ");
        sql.append(", p.details ");
        sql.append(", c.id as id_color ");
        sql.append(", c.name as name_color ");
        sql.append(", c.code as code_color ");
        sql.append(", c.img ");
        sql.append(", p.created_at ");
        sql.append(", p.updated_at ");
        sql.append("FROM ");
        sql.append("products AS p ");
        sql.append("INNER JOIN ");
        sql.append("colors AS c ");
        sql.append("ON p.id = c.product_id ");
        return sql;
    }

    private String SqlProducts(boolean newProduct, boolean highLight) {
        StringBuffer sql = SqlString();
        sql.append("WHERE 1 = 1 ");
        if (highLight) {
            sql.append("AND p.highlight = true ");
        }
        if (newProduct) {
            sql.append("AND p.new_product = true ");
        }
        sql.append("GROUP BY p.id, c.product_id ");
        sql.append("ORDER BY RAND() ");
        if (highLight) {
            sql.append("LIMIT 9 ");
        }
        if (newProduct) {
            sql.append("LIMIT 12 ");
        }
        return sql.toString();
    }

    public List<ProductsDto> GetDataProducts() {
        String sql = SqlProducts(YES, NO);
        List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProducts;
    }
}
