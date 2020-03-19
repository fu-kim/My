package edu.nf.gc.web;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.entity.GarbageHandleInformation;
import edu.nf.gc.entity.GarbageInformation;
import edu.nf.gc.service.GarbageHandleInformationService;
import edu.nf.gc.web.vo.BaseController;
import edu.nf.gc.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
@RestController
public class GarbageHandleInformationController extends BaseController {

    @Autowired
    private GarbageHandleInformationService service;

    @GetMapping("/ghList")
    public ResponseVO<PageInfo<GarbageHandleInformation>> ghList(Integer pageNum, Integer pageSize) {
        PageInfo<GarbageHandleInformation> pageInfo = service.ghList(pageNum,pageSize);
        List<GarbageHandleInformation> list = pageInfo.getList();
        return success(pageInfo);
    }

    @PostMapping("/insertGhInfo")
    public ResponseVO insertGhInfo(GarbageHandleInformation GarbageHandleInformation) {
        service.insertGhInfo(GarbageHandleInformation);
        return success("添加成功");
    }

    @PostMapping("/updateGhInfo")
    public ResponseVO updateGhInfo(GarbageHandleInformation GarbageHandleInformation) {
        service.updateGhInfo(GarbageHandleInformation);
        return success("修改成功");
    }

    @PostMapping("/deleteGhInfo")
    public ResponseVO deleteGhInfo(String ghId) {
        service.deleteGhInfo(ghId);
        return success("删除成功");
    }
}
