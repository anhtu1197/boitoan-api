package vn.vtcc.boitoan.model;

public class CungHoangDao {
    private int id;
    private int gioiTinh;
    private int maCungHoangDao;
    private String loiGiai;
    private String thangApDung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMaCungHoangDao() {
        return maCungHoangDao;
    }

    public void setMaCungHoangDao(int maCungHoangDao) {
        this.maCungHoangDao = maCungHoangDao;
    }

    public String getLoiGiai() {
        return loiGiai;
    }

    public void setLoiGiai(String loiGiai) {
        this.loiGiai = loiGiai;
    }

    public String getThangApDung() {
        return thangApDung;
    }

    public void setThangApDung(String thangApDung) {
        this.thangApDung = thangApDung;
    }
}
