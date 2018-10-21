package vn.vtcc.boitoan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.Bai;
import vn.vtcc.boitoan.model.CungHoangDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository

public class CungHoangDaoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CungHoangDao getCungHoangDaoByGioiTinhNgaySinh(String ngaySinh, String gioiTinh) {
        //lấy ngày hôm nay dạng MM/yyyy
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat = new SimpleDateFormat("MM/yyyy");
        String today = timeFormat.format(date.getTime());
        //lấy mã cung hoàng đạo
        int maCungHoangDao = getCungHoangDao(ngaySinh);
        System.out.println(maCungHoangDao);
        CungHoangDao res = jdbcTemplate.queryForObject("select * from BOI_CUNG_HOANG_DAO where gioi_tinh=? and ma_cung_hoang_dao=? and thang_ap_dung=?", new Object[]{
                        gioiTinh.equals("nam") ? 0 : 1, maCungHoangDao, today
                },
                new CungHoangDaoRepository.CungHoangDaoRowMapper());
        res.setLoiGiai("Dự đoán tháng " + today + " của " + getTenCungHoangDao(maCungHoangDao) + " - " + gioiTinh + ":\n " + res.getLoiGiai());
        return res;
    }

    class CungHoangDaoRowMapper implements RowMapper<CungHoangDao> {
        @Override
        public CungHoangDao mapRow(ResultSet resultSet, int i) throws SQLException {
            CungHoangDao cungHoangDao = new CungHoangDao();
            cungHoangDao.setId(resultSet.getInt("id"));
            cungHoangDao.setGioiTinh(resultSet.getInt("gioi_tinh"));
            cungHoangDao.setLoiGiai(resultSet.getString("loi_giai"));
            cungHoangDao.setMaCungHoangDao(resultSet.getInt("ma_cung_hoang_dao"));
            cungHoangDao.setThangApDung(resultSet.getString("thang_ap_dung"));
            return cungHoangDao;
        }
    }

    //hàm trả về mã cung hoàng đạo
    //vị trí 0 là từ 22/12 - 20/01 sẽ cho vào trường hợp else
    private int getCungHoangDao(String ngaySinh) {
        String[] start = {"21/01", "20/02", "21/03", "21/04", "22/05", "22/06", "23/07", "23/08", "24/09", "24/10", "23/11"};
        String[] end = {"19/02", "20/03", "20/04", "21/05", "21/06", "22/07", "22/08", "23/09", "23/10", "22/11", "21/12"};
        for (int i = 0; i < start.length; i++) {
            if (compare(start[i], ngaySinh) && compare(ngaySinh, end[i]))
                return i + 1;
        }
        return 0;
    }

    private String getTenCungHoangDao(int index) {
        String[] tenCung = {"Ma Kết", "Bảo Bình", "Song Ngư", "Bạch Dương", "Kim Ngưu", "Song Tử", "Cự Giải", "Sư tử", "Xử Nữ", "Thiên Bình", "Bọ Cạp", "Nhân Mã"};
        return tenCung[index];
    }

    //hàm so sánh 2 ngày dạng dd/mm với nhau
    //day1<=day2 => true, ngược lại false
    private boolean compare(String day1, String day2) {
        day1 = day1.substring(day1.indexOf("/") + 1) + day1;
        day2 = day2.substring(day2.indexOf("/") + 1) + day2;
        return day1.compareTo(day2) <= 0;
    }
}
