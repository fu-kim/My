package edu.nf.gc.web;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.entity.GarbageInformation;
import edu.nf.gc.entity.Staff;
import edu.nf.gc.service.GarbageInformationService;
import edu.nf.gc.service.LoginService;
import edu.nf.gc.web.vo.BaseController;
import edu.nf.gc.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/21
 */
@RestController
public class GarbageInformationController extends BaseController {

    @Autowired
    private GarbageInformationService service;

    @GetMapping("/giList")
    public ResponseVO<PageInfo<GarbageInformation>> giList(Integer pageNum, Integer pageSize) {
        PageInfo<GarbageInformation> pageInfo = service.giList(pageNum,pageSize);
        List<GarbageInformation> list = pageInfo.getList();
        return success(pageInfo);
    }

    @GetMapping("/getTotal")
    public ResponseVO getTotal(){
        BigDecimal total = service.getTotal();
        return success(total);
    }

    @GetMapping("/getCityNum")
    public ResponseVO getCityNum(){
        Integer cityNum = service.getCityNum();
        return success(cityNum);
    }

    @GetMapping("/getHarmful")
    public ResponseVO getHarmful(){
        BigDecimal Harmful = service.getHarmful();
        return success(Harmful);
    }
    @GetMapping("/getRecyclable")
    public ResponseVO getRecyclable(){
        BigDecimal Recyclable = service.getRecyclable();
        return success(Recyclable);
    }
    @GetMapping("/getGiOther")
    public ResponseVO getGiOther(){
        BigDecimal GiOther = service.getGiOther();
        return success(GiOther);
    }
    @GetMapping("/getKitchenWaste")
    public ResponseVO getKitchenWaste(){
        BigDecimal KitchenWaste = service.getKitchenWaste();
        return success(KitchenWaste);
    }

    @GetMapping("/getGiListByCity")
    public ResponseVO<PageInfo<GarbageInformation>> getGiListByCity(Integer pageNum, Integer pageSize,String cityName) {
        PageInfo<GarbageInformation> pageInfo = service.getGiListByCity(pageNum,pageSize,cityName);
        List<GarbageInformation> list = pageInfo.getList();
        return success(pageInfo);
    }

    @PostMapping("/insertGiInfo")
    public ResponseVO insertGiInfo(GarbageInformation garbageInformation) {
        service.insertGiInfo(garbageInformation);
        return success("添加成功");
    }


    @PostMapping("/updateGiInfo")
    public ResponseVO updateGiInfo(GarbageInformation garbageInformation) {
        service.updateGiInfo(garbageInformation);
        return success("修改成功");
    }

    @PostMapping("/deleteGiInfo")
    public ResponseVO deleteGiInfo(String giId) {
        service.deleteGiInfo(giId);
        return success("删除成功");
    }
}
