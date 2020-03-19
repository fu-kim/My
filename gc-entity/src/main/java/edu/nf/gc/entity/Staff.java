package edu.nf.gc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/20
 */
public class Staff {
    private Integer sid;
    private String staffName;
    private String staffPwd;
    private Integer staffAge;
    private String staffType;
    private String  staffPhone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date staffEntryTime;
    private List<String> staff_Authority;
    private List<String> staff_Menu;

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public List<String> getStaff_Menu() {
        return staff_Menu;
    }

    public void setStaff_Menu(List<String> staff_Menu) {
        this.staff_Menu = staff_Menu;
    }

    public List<String> getStaff_Authority() {
        return staff_Authority;
    }

    public void setStaff_Authority(List<String> staff_Authority) {
        this.staff_Authority = staff_Authority;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPwd() {
        return staffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Date getStaffEntryTime() {
        return staffEntryTime;
    }

    public void setStaffEntryTime(Date staffEntryTime) {
        this.staffEntryTime = staffEntryTime;
    }
}
