package DiamondShop.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSliders implements RowMapper<Sliders> {

    @Override
    public Sliders mapRow(ResultSet rs, int i) throws SQLException {
        Sliders sliders = new Sliders();
        sliders.setId(rs.getInt("id"));
        sliders.setImg(rs.getString("img"));
        sliders.setCaption(rs.getString("caption"));
        sliders.setContent(rs.getString("content"));
        return sliders;
    }
}
