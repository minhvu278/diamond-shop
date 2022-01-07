package DiamondShop.Dao;

import DiamondShop.Entity.MapperSliders;
import DiamondShop.Entity.Sliders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SliderDao extends BaseDao{

    public List<Sliders> GetDataSlider() {
        List<Sliders> list = new ArrayList<Sliders>();
        String sql = "SELECT * FROM sliders";
        list = _jdbcTemplate.query(sql, new MapperSliders());
        return list;
    }
}

