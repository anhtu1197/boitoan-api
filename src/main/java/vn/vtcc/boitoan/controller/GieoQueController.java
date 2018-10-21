package vn.vtcc.boitoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.vtcc.boitoan.model.*;
import vn.vtcc.boitoan.model.api.Data;
import vn.vtcc.boitoan.model.api.Info;
import vn.vtcc.boitoan.model.api.Param;
import vn.vtcc.boitoan.model.api.Path;
import vn.vtcc.boitoan.service.*;
import vn.vtcc.boitoan.service.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanAnh on 22/02/2018.
 */

@RestController
@RequestMapping(value = "/knowledge")
public class GieoQueController {
    @Autowired
    private ITinhDuyenService tinhDuyenService;
    @Autowired
    private IGieoQueService gieoQueService;
    @Autowired
    private IBocBaiService bocBaiService;
    @Autowired
    private ICungHoangDaoService cungHoangDaoService;
    @Autowired
    private IThongTinService thongTinService;
    @Autowired
    private ITuViService tuViService;

    @RequestMapping(path = "/boique", produces = MediaType.APPLICATION_JSON_VALUE)
    public Que getQue() {
        return gieoQueService.getQue();
    }

    @GetMapping("/bocbai")
    public Bai getBai() {
        return bocBaiService.getBai();
    }

    @GetMapping("/boicunghoangdao")
    public CungHoangDao getCungHoangDao(@RequestParam("ngay") String ngaySinh, @RequestParam("gioitinh") String gioiTinh) {
        return cungHoangDaoService.boiCungHoangDao(ngaySinh, gioiTinh);
    }

    @GetMapping("/thongtin")
    public ThongTin thongtin(@RequestParam("nam") String namSinh) {
        return thongTinService.getThongTin(Integer.parseInt(namSinh));
    }

    @GetMapping("/boitinhduyen")
    public TinhDuyen getTinhDuyen(@RequestParam("nam1") String namSinhNam, @RequestParam("nam2") String namSinhNu,
                                  @RequestParam("ten1") String ten1, @RequestParam("ten2") String ten2) {
        return tinhDuyenService.getTinhDuyen(namSinhNam, namSinhNu, ten1, ten2);
    }

    @GetMapping("boituvi")
    public TuVi getTuVi(@RequestParam("nam") String namSinh, @RequestParam("gioi") String gioiTinh, @RequestParam("loai") String loai) {
        return tuViService.getTuVi(namSinh, gioiTinh);
    }

    @GetMapping("")
    public Info summary() {
        List<Path> paths = new ArrayList<>();
        //khai báo /boique
        paths.add(new Path("/boique", "GET", "bói theo quẻ", new ArrayList<>()));
        //khai báo /bocbai
        paths.add(new Path("/bocbai", "GET", "bói bốc bài 52 lá", new ArrayList<>()));
        //khai báo /boicunghoangdao
        List<Param> params = new ArrayList<>();
        params.add(new Param("ngay", "string"));
        params.add(new Param("gioitinh", "string"));
        paths.add(new Path("/boicunghoangdao", "GET", "bói cung hoàng đạo", params));
        //khai bao /thongtin
        List<Param> thongtin_params = new ArrayList<>();
        thongtin_params.add(new Param("nam", "string"));
        paths.add(new Path("/thongtin", "GET", "xem bản mệnh", thongtin_params));
        //khai báo /boitinhduyen
        List<Param> tinhduyen_params = new ArrayList<>();
        tinhduyen_params.add(new Param("nam1", "string"));
        tinhduyen_params.add(new Param("nam2", "string"));
        tinhduyen_params.add(new Param("ten1", "string"));
        tinhduyen_params.add(new Param("ten2", "string"));
        paths.add(new Path("/boitinhduyen", "GET", "bói tình duyên", tinhduyen_params));
        //khai báo /boituvi
        List<Param> tuvi_params = new ArrayList<>();
        tuvi_params.add(new Param("nam", "string"));
        tuvi_params.add(new Param("gioi", "string"));
        tuvi_params.add(new Param("loai", "string"));
        paths.add(new Path("/boituvi", "GET", "bói tử vi", tuvi_params));
        /*------------------------------------------------------------*/
        Data data = new Data("", "/knowledge", paths);
        Info info = new Info(200, data, "Success");
        return info;
    }
}
