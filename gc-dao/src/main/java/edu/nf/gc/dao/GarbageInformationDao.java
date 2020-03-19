package edu.nf.gc.dao;

import edu.nf.gc.entity.GarbageInformation;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/21
 */
public interface GarbageInformationDao {
    List<GarbageInformation> giList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    List<GarbageInformation> gList();
    BigDecimal getTotal();
    Integer getCityNum();
    BigDecimal getHarmful();
    BigDecimal getRecyclable();
    BigDecimal getKitchenWaste();
    BigDecimal getGiOther();
    List<GarbageInformation> getGiListByCity(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String cityName);
    void insertGiInfo(GarbageInformation garbageInformation);
    void updateGiInfo(GarbageInformation garbageInformation);
    void deleteGiInfo(String giId);
}
