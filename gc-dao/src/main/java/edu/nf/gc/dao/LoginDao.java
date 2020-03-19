package edu.nf.gc.dao;

import edu.nf.gc.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Fu
 * @date 2019/11/20
 */
public interface LoginDao {
    Staff login(Staff staff);
    List<String> staffAuthor(Integer sid);
    List<String> staffMenu(Integer sid);
}
