package DiamondShop.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCategories implements RowMapper<Categories> {

    @Override
    public Categories mapRow(ResultSet rs, int i) throws SQLException {
        Categories categories = new Categories();
        categories.setId(rs.getInt("id"));
        categories.setName(rs.getString("name"));
        categories.setDescription(rs.getString("description"));
        return categories;
    }
}
