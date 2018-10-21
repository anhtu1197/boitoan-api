package vn.vtcc.boitoan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vtcc.boitoan.model.Que;
import vn.vtcc.boitoan.repository.QueRepository;
import vn.vtcc.boitoan.service.IGieoQueService;

/**
 * Created by TuanAnh on 22/02/2018.
 */

@Service
public class GieoQueService implements IGieoQueService{

    @Autowired
    private QueRepository queRepository;
    @Override
    public Que getQue() {
        int queId = RandomService.getRandomInt(64);
        return queRepository.getQueById(queId);
    }

}
