package vn.vtcc.boitoan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.Bai;
import vn.vtcc.boitoan.model.Que;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BaiRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Bai getBaiById(int baiId) {
        return jdbcTemplate.queryForObject("select * from BOI_BAI where id=?", new Object[]{
                        baiId
                },
                new BaiRepository.BaiRowMapper());
    }

    public int insertNewBai(Bai bai){
        return jdbcTemplate.update("insertNewQue into boi_bai (id, image_url, loi_giai) " + "values(?, ?, ?)",
                bai.getId(), bai.getImageURL(), bai.getResult()
                );
    }

    class BaiRowMapper implements RowMapper<Bai> {
        @Override
        public Bai mapRow(ResultSet resultSet, int i) throws SQLException {
            Bai bai = new Bai();
            bai.setId(resultSet.getInt("id"));
            bai.setImageURL(resultSet.getString("image_url"));
            bai.setResult(resultSet.getString("loi_giai"));
            return bai;
        }
    }
}
