package edu.nf.gc.service;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.entity.GarbageHandleInformation;
import org.apache.ibatis.annotations.Param;

/**
 * @author Fu
 * @date 2019/12/3
 */
public interface GarbageHandleInformationService {
    PageInfo<GarbageHandleInformation> ghList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    PageInfo<GarbageHandleInformation> getGhListByCity(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String cityName);
    void insertGhInfo(GarbageHandleInformation garbageHandleInformation);
    void updateGhInfo(GarbageHandleInformation garbageHandleInformation);
    void deleteGhInfo(String ghId);
}
