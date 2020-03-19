package edu.nf.gc.dao;

import edu.nf.gc.entity.GarbageHandleInformation;
import edu.nf.gc.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
public interface StaffDao {
    List<Staff> sList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    List<Staff> getsListById(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, Integer sId);
    void insertStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(Integer sid);
    void updateStaffType(Integer sid,Integer staffType);
    String getPwd(Integer sid);
}
