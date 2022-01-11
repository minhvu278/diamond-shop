package DiamondShop.Dao;

import DiamondShop.Dto.ProductDtoMapper;
import DiamondShop.Dto.ProductsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    private StringBuffer SqlProductsById(int id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE cat_id = "  + id + " ");
        return sql;
    }

    private String SqlProductsPaginates(int id, int start, int totalPage) {
        StringBuffer sql = SqlProductsById(id);
        sql.append("LIMIT  "  + start + ", " + totalPage);
        return sql.toString();
    }

    public List<ProductsDto> GetDataProducts() {
        String sql = SqlProducts(YES, NO);
        List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProducts;
    }

    public List<ProductsDto> GetAllProductsById(int id) {
        String sql = SqlProductsById(id).toString();
        List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProducts;
    }

    public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
        StringBuffer sqlGetDataById = SqlProductsById(id);
        List<ProductsDto> listProductsById = _jdbcTemplate.query(sqlGetDataById.toString(), new ProductDtoMapper());
        List<ProductsDto> listProducts = new ArrayList<>();
        if (listProductsById.size() > 0) {
            String sql = SqlProductsPaginates(id, start, totalPage);
            listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
        }
        return listProducts;
    }

    private String SqlProductById(long id) {
        StringBuffer sql = SqlString();
        sql.append("WHERE p.id = "  + id + " ");
        sql.append("LIMIT 1 ");
        return sql.toString();
    }

    public List<ProductsDto> GetProductById(long id) {
        String sql = SqlProductById(id);
        List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProduct;
    }

    public ProductsDto FindGetProductById(long id) {
        String sql = SqlProductById(id);
        ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
        return product;
    }
}
