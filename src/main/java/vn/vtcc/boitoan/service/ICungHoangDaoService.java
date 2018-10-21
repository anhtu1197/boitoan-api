package vn.vtcc.boitoan.service;

import vn.vtcc.boitoan.model.CungHoangDao;

public interface ICungHoangDaoService {
    CungHoangDao boiCungHoangDao(String ngaySinh, String gioiTinh);
}
