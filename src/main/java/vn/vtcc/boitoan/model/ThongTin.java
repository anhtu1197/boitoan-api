package vn.vtcc.boitoan.model;

public class ThongTin {
    private int namSinh;
    private int tuoi;
    private String menhNguHanh;
    private String canChi;

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getMenhNguHanh() {
        return menhNguHanh;
    }

    public void setMenhNguHanh(String menhNguHanh) {
        this.menhNguHanh = menhNguHanh;
    }

    public String getCanChi() {
        return canChi;
    }

    public void setCanChi(String canChi) {
        this.canChi = canChi;
    }

    public ThongTin() {

    }

    public ThongTin(int namSinh, int tuoi, String menhNguHanh, String canChi) {

        this.namSinh = namSinh;
        this.tuoi = tuoi;
        this.menhNguHanh = menhNguHanh;
        this.canChi = canChi;
    }
}
