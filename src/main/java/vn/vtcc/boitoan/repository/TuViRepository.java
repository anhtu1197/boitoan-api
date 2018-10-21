package vn.vtcc.boitoan.repository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.vtcc.boitoan.model.Que;
import vn.vtcc.boitoan.model.TinhDuyen;
import vn.vtcc.boitoan.model.TuVi;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TuViRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TuVi getTuVi(String namSinh, String gioiTinh) {
        int nam = Integer.parseInt(namSinh);
        switch (gioiTinh){
            case "nam":{
                return getTuVi((nam-1924)%60+1);
            }
            case  "nữ": {
                return getTuVi((nam-1924)%60+61);
            }
        }
            return new TuVi();
        }
        private TuVi getTuVi(int id){
            return jdbcTemplate.queryForObject("select * from boi_tu_vi where id=?", new Object[]{
                            id
                    },
                    new TuViRepository.TuViRowMapper());
        }
    class TuViRowMapper implements RowMapper<TuVi> {

        @Override
        public TuVi mapRow(ResultSet resultSet, int i) throws SQLException {
            TuVi tuVi = new TuVi();
            tuVi.setMoDau(resultSet.getString("mo_dau"));
            tuVi.setDienBien(resultSet.getString("dien_bien"));
            tuVi.setGioXuatHanh(resultSet.getString("gio_xuat_hanh"));
            tuVi.setNamKhoKhan(resultSet.getString("nam_kho_khan"));
            tuVi.setTuoiDaiKy(resultSet.getString("tuoi_dai_ky"));
            tuVi.setChonVoChong(resultSet.getString("chon_vo_chong"));
            tuVi.setHopTuoiLamAn(resultSet.getString("hop_tuoi_lam_an"));
            tuVi.setCongDanh(resultSet.getString("cong_danh"));
            tuVi.setCuocSong(resultSet.getString("cuoc_song"));
            tuVi.setTinhDuyen(resultSet.getString("tinh_duyen"));
            return tuVi;
        }
    }
        private TuVi getDataFromFile (String fileName){
            //"C:/Users/toantm4/Downloads/com.ctv.vn.lichviet_2018-01-21/assets/tuvi/1x.html"
            String s = "";
            File htmlFile = new File(fileName);
            Document doc = null;
            try {
                doc = Jsoup.parse(htmlFile, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements elements = doc.select("center");
            s += elements.first().text() + "\n";
            System.out.print(elements.first().text());
            Element element_body = doc.select("body").first();
            Elements element_ph4 = element_body.getAllElements();
            for (Element e : element_ph4) {
                if (e.tagName().equals("h4") || e.tagName().equals("p")) {
                    String html = e.html();
                    html = html.replace("<br> ", "<br>");
                    html = html.replace("<br>", "\n");
                    if (e.tagName().equals("h4")) html = "@@@" + html + "\n";
                    s += html;
                }
            }
            String[] temp = s.split("@@@");
            TuVi t = new TuVi();
            t.setMoDau(temp[0]);
            t.setCuocSong(temp[1].replace("\n\n", "\n"));
            t.setTinhDuyen(temp[2].replace("\n\n", "\n"));
            t.setCongDanh(temp[3].replace("\n\n", "\n"));
            t.setHopTuoiLamAn(temp[4].replace("\n\n", "\n"));
            t.setChonVoChong(temp[5].replace("\n\n", "\n"));
            t.setTuoiDaiKy(temp[6].replace("\n\n", "\n"));
            t.setNamKhoKhan(temp[7].replace("\n\n", "\n"));
            t.setGioXuatHanh(temp[8].replace("\n\n", "\n"));
            try {
                t.setDienBien(temp[9].replace("\n\n", "\n"));
            }
            catch (Exception e){
                t.setNamKhoKhan(null);
                t.setGioXuatHanh(temp[7].replace("\n\n", "\n"));
                t.setDienBien(temp[8].replace("\n\n", "\n"));
            }
            return t;
        }
    }
