package edu.nf.gc.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.dao.GarbageHandleInformationDao;
import edu.nf.gc.entity.GarbageHandleInformation;
import edu.nf.gc.service.GarbageHandleInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Fu
 * @date 2019/12/3
 */
@Service("GhService")
@Transactional(rollbackFor = RuntimeException.class)
public class GarbageHandleInformationServiceImpl implements GarbageHandleInformationService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private GarbageHandleInformationDao dao;


    @Override
    public PageInfo<GarbageHandleInformation> ghList(Integer pageNum, Integer pageSize) {
        List<GarbageHandleInformation> list = dao.ghList(pageNum, pageSize);
        PageInfo<GarbageHandleInformation> pageInfo = new PageInfo<>(list);
        log.info("查询条数：" + pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public PageInfo<GarbageHandleInformation> getGhListByCity(Integer pageNum, Integer pageSize, String cityName) {
        return null;
    }

    @Override
    public void insertGhInfo(GarbageHandleInformation garbageHandleInformation) {
        dao.insertGhInfo(garbageHandleInformation);
        log.info("插入编号：" + garbageHandleInformation.getGhId());
    }

    @Override
    public void updateGhInfo(GarbageHandleInformation garbageHandleInformation) {
        dao.updateGhInfo(garbageHandleInformation);
        log.info("修改编号：" + garbageHandleInformation.getGhId());
    }

    @Override
    public void deleteGhInfo(String ghId) {
        dao.deleteGhInfo(ghId);
        log.info("删除编号：" + ghId);
    }

}
