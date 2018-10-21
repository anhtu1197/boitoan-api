package vn.vtcc.boitoan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.TinhDuyen;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TinhDuyenRepository {
    String sql = "select can_chi.canchi, can_chi.diem as diem_can_chi,ban_menh.banmenh,ban_menh.diem as diem_ban_menh,\n" +
            "mang1.mang as mang_nam,mang2.mang as mang_nu, ngu_hanh.nguhanh,ngu_hanh.diem as diem_ngu_hanh,\n" +
            "que_dich.quedich, que_dich.diem as diem_que_dich, boikieu, boi_kieu.diem as diem_boi_kieu\n" +
            "from BOI_TINH_YEU as b\n" +
            "join CAN_CHI on ID_CAN_CHI = CAN_CHI.ID\n" +
            "join ban_menh on ID_BAN_MENH = ban_menh.id\n" +
            "join mang as mang1 on mang1.id = mang_1\n" +
            "join mang as mang2 on mang2.id = mang_2\n" +
            "join ngu_hanh on id_ngu_hanh = ngu_hanh.id\n" +
            "join que_dich on que_dich.id = (nam_sinh_1 + nam_sinh_2)%64+1\n" +
            "join boi_kieu on boi_kieu.id = (nam_sinh_1 + nam_sinh_2)%9+1\n" +
            "where nam_sinh_1 = ? and nam_sinh_2 = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    public TinhDuyen getTinhDuyen(String namSinh1, String namSinh2, String ten1, String ten2) {
        TinhDuyen tinhDuyen = jdbcTemplate.queryForObject(sql, new Object[]{namSinh1, namSinh2}, new TinhDuyenRowMapper());
        int tongDiem = tinhDuyen.getDiemNguhanh() + tinhDuyen.getDiemBanMenh() + tinhDuyen.getDiemQueDich() + tinhDuyen.getDiemCanChi() + tinhDuyen.getDiemBoiKieu();
        tinhDuyen.setCungMenh("Họ tên người nam là: " + ten1 + "\nNgũ hành: " + tinhDuyen.getMangNam() + "\nHọ tên người nữ là: " + ten2 + "\nNgũ hành: " + tinhDuyen.getMangNu());
        tinhDuyen.setQueDich(tinhDuyen.getQueDich().replace("{name-male}", ten1).replace("{name-female}", ten2));
        tinhDuyen.setNguHanh("1. Ngũ hành:\n" + tinhDuyen.getNguHanh() + "\nSố điểm: " + tinhDuyen.getDiemNguhanh() + "/2");
        tinhDuyen.setBanMenh("2. Bản mệnh:\n" + tinhDuyen.getBanMenh() + "\nSố điểm: " + tinhDuyen.getDiemBanMenh() + "/2");
        tinhDuyen.setQueDich("3. Quẻ dịch:\n" + tinhDuyen.getQueDich() + "\nSố điểm: " + tinhDuyen.getDiemQueDich() + "/2");
        tinhDuyen.setCanChi("4. Can chi:\n" + tinhDuyen.getCanChi() + "\nSố điểm: " + tinhDuyen.getDiemCanChi() + "/2");
        tinhDuyen.setBoiKieu("5. Họ tên:\n" + tinhDuyen.getBoiKieu() + "\nSố điểm: " + tinhDuyen.getDiemBoiKieu() + "/2");
        tinhDuyen.setKetQua("Tổng điểm: " + tongDiem + "/10");
        return tinhDuyen;
    }

    class TinhDuyenRowMapper implements RowMapper<TinhDuyen> {
        @Override
        public TinhDuyen mapRow(ResultSet resultSet, int i) throws SQLException {
            TinhDuyen tinhDuyen = new TinhDuyen();
            tinhDuyen.setBanMenh(resultSet.getString("banmenh"));
            tinhDuyen.setCanChi(resultSet.getString("canchi"));
            tinhDuyen.setMangNam(resultSet.getString("mang_nam"));
            tinhDuyen.setMangNu(resultSet.getString("mang_nu"));
            tinhDuyen.setNguHanh(resultSet.getString("nguhanh"));
            tinhDuyen.setQueDich(resultSet.getString("quedich"));
            tinhDuyen.setBoiKieu(resultSet.getString("boikieu"));
            tinhDuyen.setDiemBanMenh(resultSet.getInt("diem_ban_menh"));
            tinhDuyen.setDiemCanChi(resultSet.getInt("diem_can_chi"));
            tinhDuyen.setDiemNguhanh(resultSet.getInt("diem_ngu_hanh"));
            tinhDuyen.setDiemQueDich(resultSet.getInt("diem_que_dich"));
            tinhDuyen.setDiemBoiKieu(resultSet.getInt("diem_boi_kieu"));
            return tinhDuyen;
        }
    }
}
