package vn.vtcc.boitoan.model;

public class TuVi {
    private String moDau;
    private String cuocSong;
    private String tinhDuyen;
    private String congDanh;
    private String hopTuoiLamAn;
    private String chonVoChong;
    private String tuoiDaiKy;
    private String namKhoKhan;
    private String gioXuatHanh;
    private String dienBien;

    @Override
    public String toString() {
        return "TuVi{" +
                "moDau='" + moDau + '\'' +
                ", cuocSong='" + cuocSong + '\'' +
                ", tinhDuyen='" + tinhDuyen + '\'' +
                ", congDanh='" + congDanh + '\'' +
                ", hopTuoiLamAn='" + hopTuoiLamAn + '\'' +
                ", chonVoChong='" + chonVoChong + '\'' +
                ", tuoiDaiKy='" + tuoiDaiKy + '\'' +
                ", namKhoKhan='" + namKhoKhan + '\'' +
                ", gioXuatHanh='" + gioXuatHanh + '\'' +
                ", dienBien='" + dienBien + '\'' +
                '}';
    }

    public String getMoDau() {
        return moDau;
    }

    public void setMoDau(String moDau) {
        this.moDau = moDau;
    }

    public String getCuocSong() {
        return cuocSong;
    }

    public void setCuocSong(String cuocSong) {
        this.cuocSong = cuocSong;
    }

    public String getTinhDuyen() {
        return tinhDuyen;
    }

    public void setTinhDuyen(String tinhDuyen) {
        this.tinhDuyen = tinhDuyen;
    }

    public String getCongDanh() {
        return congDanh;
    }

    public void setCongDanh(String congDanh) {
        this.congDanh = congDanh;
    }

    public String getHopTuoiLamAn() {
        return hopTuoiLamAn;
    }

    public void setHopTuoiLamAn(String hopTuoiLamAn) {
        this.hopTuoiLamAn = hopTuoiLamAn;
    }

    public String getChonVoChong() {
        return chonVoChong;
    }

    public void setChonVoChong(String chonVoChong) {
        this.chonVoChong = chonVoChong;
    }

    public String getTuoiDaiKy() {
        return tuoiDaiKy;
    }

    public void setTuoiDaiKy(String tuoiDaiKy) {
        this.tuoiDaiKy = tuoiDaiKy;
    }

    public String getNamKhoKhan() {
        return namKhoKhan;
    }

    public void setNamKhoKhan(String namKhoKhan) {
        this.namKhoKhan = namKhoKhan;
    }

    public String getGioXuatHanh() {
        return gioXuatHanh;
    }

    public void setGioXuatHanh(String gioXuatHanh) {
        this.gioXuatHanh = gioXuatHanh;
    }

    public String getDienBien() {
        return dienBien;
    }

    public void setDienBien(String dienBien) {
        this.dienBien = dienBien;
    }
}
