package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.TuVi;
import vn.vtcc.boitoan.repository.TuViRepository;
import vn.vtcc.boitoan.service.ITuViService;

@Service
public class TuViService implements ITuViService {
    @Autowired
    private TuViRepository tuViRepository;

    @Override
    public TuVi getTuVi(String namSinh, String gioiTinh) {
        return tuViRepository.getTuVi(namSinh, gioiTinh);
    }
}
