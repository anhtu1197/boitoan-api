package vn.vtcc.boitoan.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.Que;

/**
 * Created by TuanAnh on 22/02/2018.
 */
@Repository
public class QueRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Que getQueById(int queId) {
        return jdbcTemplate.queryForObject("select * from QUE_BOI where id=?", new Object[]{
                queId
            },
            new QueRowMapper());
    }

    public int insertNewQue(Que que){
        return jdbcTemplate.update("insertNewQue into QUE_BOI (id, image_url, loi_giai, ten_que) " + "values(?, ?, ?, ?)",
                    que.getId(), que.getImageURL(), que.getLoiGiai(), que.getTenQue()
                );
    }

    class QueRowMapper implements RowMapper<Que> {
        @Override
        public Que mapRow(ResultSet resultSet, int i) throws SQLException {
            Que que = new Que();
            que.setId(resultSet.getInt("id"));
            que.setImageURL(resultSet.getString("image_url"));
            que.setLoiGiai(resultSet.getString("loi_giai"));
            que.setTenQue(resultSet.getString("ten_que"));
            return que;
        }
    }
}
