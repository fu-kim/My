package edu.nf.gc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Fu
 * @date 2019/11/21
 */
public class GarbageInformation {
    private Integer giId;
    private String giCity;
    private BigDecimal giTotal;
    private BigDecimal giHarmful;
    private BigDecimal giRecyclable;
    private BigDecimal giKitchenWaste;
    private BigDecimal giOther;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date giIntoDate;
    private String giStaff;

    public Integer getGiId() {
        return giId;
    }

    public void setGiId(Integer giId) {
        this.giId = giId;
    }

    public String getGiCity() {
        return giCity;
    }

    public void setGiCity(String giCity) {
        this.giCity = giCity;
    }

    public BigDecimal getGiTotal() {
        return giTotal;
    }

    public void setGiTotal(BigDecimal giTotal) {
        this.giTotal = giTotal;
    }

    public BigDecimal getGiHarmful() {
        return giHarmful;
    }

    public void setGiHarmful(BigDecimal giHarmful) {
        this.giHarmful = giHarmful;
    }

    public BigDecimal getGiRecyclable() {
        return giRecyclable;
    }

    public void setGiRecyclable(BigDecimal giRecyclable) {
        this.giRecyclable = giRecyclable;
    }

    public BigDecimal getGiKitchenWaste() {
        return giKitchenWaste;
    }

    public void setGiKitchenWaste(BigDecimal giKitchenWaste) {
        this.giKitchenWaste = giKitchenWaste;
    }

    public BigDecimal getGiOther() {
        return giOther;
    }

    public void setGiOther(BigDecimal giOther) {
        this.giOther = giOther;
    }

    public Date getGiIntoDate() {
        return giIntoDate;
    }

    public void setGiIntoDate(Date giIntoDate) {
        this.giIntoDate = giIntoDate;
    }

    public String getGiStaff() {
        return giStaff;
    }

    public void setGiStaff(String giStaff) {
        this.giStaff = giStaff;
    }
}
