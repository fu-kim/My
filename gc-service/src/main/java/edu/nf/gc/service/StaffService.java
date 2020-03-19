package edu.nf.gc.service;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
public interface StaffService {
    PageInfo<Staff> sList(Integer pageNum, Integer pageSize);
    PageInfo<Staff>  getsListById(Integer pageNum,Integer pageSize, Integer sId);
    void insertStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(Integer sid);
    void updateStaffType(Integer sid,Integer staffType);
    Boolean getPwd(Integer sid,String adminPwd);
}
