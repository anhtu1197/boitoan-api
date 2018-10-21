package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.Bai;
import vn.vtcc.boitoan.model.CungHoangDao;
import vn.vtcc.boitoan.repository.BaiRepository;
import vn.vtcc.boitoan.repository.CungHoangDaoRepository;
import vn.vtcc.boitoan.service.ICungHoangDaoService;

@Service
public class CungHoangDaoService implements ICungHoangDaoService {
    @Autowired
    private CungHoangDaoRepository cungHoangDaoRepository;

    @Override
    public CungHoangDao boiCungHoangDao(String ngaySinh, String gioiTinh) {
        return cungHoangDaoRepository.getCungHoangDaoByGioiTinhNgaySinh(ngaySinh, gioiTinh);
    }
}
