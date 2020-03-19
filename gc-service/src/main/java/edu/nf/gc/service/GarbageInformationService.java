package edu.nf.gc.service;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.entity.GarbageInformation;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/21
 */
public interface GarbageInformationService {
   PageInfo<GarbageInformation> giList(Integer pageNum, Integer pageSize);
   List<GarbageInformation> gList();
   BigDecimal getTotal();
   Integer getCityNum();
   BigDecimal getHarmful();
   BigDecimal getRecyclable();
   BigDecimal getKitchenWaste();
   BigDecimal getGiOther();
   PageInfo<GarbageInformation> getGiListByCity(Integer pageNum, Integer pageSize,String cityName);
   void insertGiInfo(GarbageInformation garbageInformation);
   void updateGiInfo(GarbageInformation garbageInformation);
   void deleteGiInfo(String giId);
}
