package edu.nf.gc.service;

import edu.nf.gc.entity.Staff;

import java.util.List;

/**
 * @author Fu
 * @date 2019/11/20
 */
public interface LoginService {
    Staff login(Staff staff);
    List<String> staffAuthor(Integer sid);
    List<String> staffMenu(Integer sid);
}
