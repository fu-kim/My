package edu.nf.gc.web;

import edu.nf.gc.entity.Staff;
import edu.nf.gc.service.LoginService;
import edu.nf.gc.web.vo.BaseController;
import edu.nf.gc.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/20
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private LoginService service;

    @GetMapping("/logins")
    public ResponseVO<Staff> logina(Staff staff, HttpServletRequest request) {
        Staff staffs = service.login(staff);
        Integer sid = staffs.getSid();
        staffs.setStaff_Authority(service.staffAuthor(sid));
        staffs.setStaff_Menu(service.staffMenu(sid));
        request.getSession().setAttribute("staff", staffs);
        return success("登录成功");
    }

    @GetMapping("/getStaff")
    public ResponseVO<Staff> getStaff(HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        return success(staff);
    }

    @GetMapping("/getStaffMenu")
    public ResponseVO<List<String>> getStaffMenu(HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        List<String> menu = staff.getStaff_Menu();
        return success(menu);
    }
}