package edu.nf.gc.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.dao.StaffDao;
import edu.nf.gc.entity.GarbageHandleInformation;
import edu.nf.gc.entity.Staff;
import edu.nf.gc.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
@Service("staffService")
@Transactional(rollbackFor = RuntimeException.class)
public class StaffServiceImpl implements StaffService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private StaffDao dao;

    @Override
    public PageInfo<Staff> sList(Integer pageNum, Integer pageSize) {
        List<Staff> list = dao.sList(pageNum, pageSize);
        PageInfo<Staff> pageInfo = new PageInfo<>(list);
        log.info("查询条数：" + pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public PageInfo<Staff> getsListById(Integer pageNum, Integer pageSize, Integer sId) {
        List<Staff> list = dao.getsListById(pageNum, pageSize,sId);
        PageInfo<Staff> pageInfo = new PageInfo<>(list);
        log.info("查询条数：" + pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public void insertStaff(Staff staff) {
        dao.insertStaff(staff);
        log.info("添加编号：" + staff.getSid());
    }

    @Override
    public void updateStaff(Staff staff) {
        dao.updateStaff(staff);
        log.info("修改编号：" + staff.getSid());
    }

    @Override
    public void deleteStaff(Integer sid) {
        dao.deleteStaff(sid);
        log.info("删除编号：" + sid);
    }

    @Override
    public void updateStaffType(Integer sid,Integer staffType) {
        dao.updateStaffType(sid,staffType);
        log.info("修改职员编号："+sid+",修改权限为:"+staffType);
    }

    @Override
    public Boolean getPwd(Integer sid, String adminPwd) {
        String pwd = dao.getPwd(sid);
        if (adminPwd.equals(pwd)){
            log.info("获取密码："+sid+",密码:"+adminPwd);
            return true;
        }else {
            return false;
        }
    }
}
