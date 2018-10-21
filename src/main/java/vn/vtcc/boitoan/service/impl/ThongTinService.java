package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.ThongTin;
import vn.vtcc.boitoan.repository.ThongTinRepository;
import vn.vtcc.boitoan.service.IThongTinService;

@Service
public class ThongTinService implements IThongTinService {
    @Autowired
    ThongTinRepository thongTinRepository;

    @Override
    public ThongTin getThongTin(int namSinh) {
        return thongTinRepository.getThongTin(namSinh);
    }
}
