package vn.vtcc.boitoan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.Bai;
import vn.vtcc.boitoan.model.CungHoangDao;
import vn.vtcc.boitoan.model.ThongTin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ThongTinRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    private String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tí", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};
    public ThongTin getThongTin(int namSinh) {
        ThongTin thongTin = new ThongTin();
        thongTin.setNamSinh(namSinh);
        thongTin.setTuoi(getTuoi(namSinh));
        thongTin.setCanChi(getCanChi(namSinh));
        thongTin.setMenhNguHanh(getMenhNguHanh(namSinh));
        return thongTin;
    }
    private int getTuoi(int namSinh){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(timeFormat.format(date.getTime())) - namSinh + 1;
    }
    private String getCanChi(int namSinh){
        return can[namSinh % 10] + " " + chi[namSinh % 12];
    }
    private String getMenhNguHanh(int namSinh){
        return jdbcTemplate.queryForObject("select * from cung_menh where nam_sinh=?", new Object[]{
                        namSinh
                },
                new ThongTinRepository.CungMenhRowMapper());
    }
    class CungMenhRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("cung_menh");
        }
    }
}
