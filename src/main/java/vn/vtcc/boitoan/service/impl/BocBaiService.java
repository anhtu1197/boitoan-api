package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.Bai;
import vn.vtcc.boitoan.repository.BaiRepository;
import vn.vtcc.boitoan.service.IBocBaiService;

@Service
public class BocBaiService implements IBocBaiService {
    @Autowired
    BaiRepository baiRepository;
    @Override
    public Bai getBai() {
        int value = RandomService.getRandomInt(52);
        return baiRepository.getBaiById(value);
    }
}
