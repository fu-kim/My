package edu.nf.gc.service.impl;

import edu.nf.gc.dao.LoginDao;
import edu.nf.gc.entity.Staff;
import edu.nf.gc.service.LoginService;
import edu.nf.gc.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Fu
 * @date 2019/11/20
 */
@Service("LoginService")
@Transactional(rollbackFor = RuntimeException.class)
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private LoginDao dao;

    @Override
    public Staff login(Staff staff) {
        Staff staffs = dao.login(staff);
        try {
            if(staffs==null || !staffs.getStaffPwd().equals(staff.getStaffPwd())){
                throw new DataAccessException("用户名或密码错误");
            }
            return staffs;
        }catch (DataAccessException e){
            throw e;
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            //异常重抛
            throw new DataAccessException("服务器异常");
        }

    }

    @Override
    public List<String> staffAuthor(Integer sid) {
        List<String> url = null;
        try {
            url = dao.staffAuthor(sid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            //异常重抛
            throw new DataAccessException("服务器异常");
        }
        return url;
    }

    @Override
    public List<String> staffMenu(Integer sid) {
        List<String> menu = null;
        try {
            menu = dao.staffMenu(sid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            //异常重抛
            throw new DataAccessException("服务器异常");
        }
        return menu;
    }
}
