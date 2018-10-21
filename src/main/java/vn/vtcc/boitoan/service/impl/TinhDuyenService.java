package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.TinhDuyen;
import vn.vtcc.boitoan.repository.TinhDuyenRepository;
import vn.vtcc.boitoan.service.ITinhDuyenService;

@Service
public class TinhDuyenService implements ITinhDuyenService {
    @Autowired
    TinhDuyenRepository tinhDuyenRepository;

    @Override
    public TinhDuyen getTinhDuyen(String nam1, String nam2, String ten1, String ten2) {
        return tinhDuyenRepository.getTinhDuyen(nam1.substring(6), nam2.substring(6), ten1, ten2);
    }
}
