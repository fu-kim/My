package edu.nf.gc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Fu
 * @date 2019/12/3
 */
public class GarbageHandleInformation {
    private Integer ghId;
    private String ghCity;
    private String ghType;
    private BigDecimal ghTotal;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ghTime;
    private String ghStaff;
    private String ghMode;

    public Integer getGhId() {
        return ghId;
    }

    public void setGhId(Integer ghId) {
        this.ghId = ghId;
    }

    public String getGhCity() {
        return ghCity;
    }

    public void setGhCity(String ghCity) {
        this.ghCity = ghCity;
    }

    public String getGhType() {
        return ghType;
    }

    public void setGhType(String ghType) {
        this.ghType = ghType;
    }

    public BigDecimal getGhTotal() {
        return ghTotal;
    }

    public void setGhTotal(BigDecimal ghTotal) {
        this.ghTotal = ghTotal;
    }

    public Date getGhTime() {
        return ghTime;
    }

    public void setGhTime(Date ghTime) {
        this.ghTime = ghTime;
    }

    public String getGhStaff() {
        return ghStaff;
    }

    public void setGhStaff(String ghStaff) {
        this.ghStaff = ghStaff;
    }

    public String getGhMode() {
        return ghMode;
    }

    public void setGhMode(String ghMode) {
        this.ghMode = ghMode;
    }
}
