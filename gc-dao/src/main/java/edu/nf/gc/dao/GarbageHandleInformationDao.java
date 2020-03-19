package edu.nf.gc.dao;

import edu.nf.gc.entity.GarbageHandleInformation;
import edu.nf.gc.entity.GarbageInformation;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
public interface GarbageHandleInformationDao {
    List<GarbageHandleInformation> ghList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    List<GarbageHandleInformation> getGhListByCity(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String cityName);
    void insertGhInfo(GarbageHandleInformation garbageHandleInformation);
    void updateGhInfo(GarbageHandleInformation garbageHandleInformation);
    void deleteGhInfo(String giId);
}
