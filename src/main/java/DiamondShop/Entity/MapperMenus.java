package DiamondShop.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMenus implements RowMapper<Menus> {

    @Override
    public Menus mapRow(ResultSet rs, int i) throws SQLException {
        Menus menus = new Menus();
        menus.setId(rs.getInt("id"));
        menus.setName(rs.getString("name"));
        menus.setUrl(rs.getString("url"));
        return menus;
    }
}
