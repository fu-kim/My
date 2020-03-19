package edu.nf.gc.web;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.dao.StaffDao;
import edu.nf.gc.entity.GarbageInformation;
import edu.nf.gc.entity.Staff;
import edu.nf.gc.service.LoginService;
import edu.nf.gc.service.StaffService;
import edu.nf.gc.web.vo.BaseController;
import edu.nf.gc.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
@RestController
public class StaffController extends BaseController {
    @Autowired
    private StaffService service;

    @GetMapping("/sList")
    public ResponseVO<PageInfo<Staff>> giList(Integer pageNum, Integer pageSize) {
        PageInfo<Staff> pageInfo = service.sList(pageNum,pageSize);
        List<Staff> list = pageInfo.getList();
        return success(pageInfo);
    }

    @GetMapping("/getsListById")
    public ResponseVO<PageInfo<Staff>> getsListById(Integer pageNum, Integer pageSize,Integer sId) {
        PageInfo<Staff> pageInfo = service.getsListById(pageNum,pageSize,sId);
        List<Staff> list = pageInfo.getList();
        return success(pageInfo);
    }

    @PostMapping("/insertStaff")
    public ResponseVO insertStaff(Staff staff) {
        service.insertStaff(staff);
        return success("添加成功");
    }


    @PostMapping("/updateStaff")
    public ResponseVO updateStaff(Staff staff) {
        service.updateStaff(staff);
        return success("修改成功");
    }

    @PostMapping("/deleteStaff")
    public ResponseVO deleteStaff(Integer sId) {
        service.deleteStaff(sId);
        return success("删除成功");
    }

    @PostMapping("/updateStaffType")
    public ResponseVO updateStaffType(Integer sid, Integer staffType) {
        service.updateStaffType(sid,staffType);
        return success("修改权限成功");
    }

    @PostMapping("/getPwd")
    public ResponseVO getPwd(String adminPwd,HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        if (service.getPwd(staff.getSid(),adminPwd)){
            return  success("密码正确");
        }else {
            return fail(500,"管理员密码错误");
        }
    }
}
