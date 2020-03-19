package edu.nf.gc.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.gc.dao.GarbageInformationDao;
import edu.nf.gc.entity.GarbageInformation;
import edu.nf.gc.service.GarbageInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fu
 * @date 2019/11/21
 */
@Service("GiService")
@Transactional(rollbackFor = RuntimeException.class)
public class GarbageInformationServiceImpl implements GarbageInformationService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private GarbageInformationDao dao;
    @Override
    public PageInfo<GarbageInformation> giList(Integer pageNum, Integer pageSize) {
        List<GarbageInformation> list = dao.giList(pageNum, pageSize);
        PageInfo<GarbageInformation> pageInfo = new PageInfo<>(list);
        log.info("查询条数：" + pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public List<GarbageInformation> gList() {
        List<GarbageInformation> list = dao.gList();
        log.info("查询条数：" + list.size());
        return list;
    }

    @Override
    public BigDecimal getTotal() {
        BigDecimal total = dao.getTotal();
        log.info("查询总量："+total);
        return total;
    }

    @Override
    public Integer getCityNum() {
        Integer cityNum = dao.getCityNum();
        log.info("监控城市："+cityNum);
        return cityNum;
    }

    @Override
    public BigDecimal getHarmful() {
        BigDecimal harmful = dao.getHarmful();
        log.info("查询有害垃圾总量："+harmful);
        return harmful;
    }

    @Override
    public BigDecimal getRecyclable() {
        BigDecimal recyclable = dao.getRecyclable();
        log.info("查询可回收垃圾总量："+recyclable);
        return recyclable;
    }

    @Override
    public BigDecimal getKitchenWaste() {
        BigDecimal kitchenWaste = dao.getKitchenWaste();
        log.info("查询厨余垃圾总量："+kitchenWaste);
        return kitchenWaste;
    }

    @Override
    public BigDecimal getGiOther() {
        BigDecimal GiOther = dao.getGiOther();
        log.info("查询其他垃圾总量："+GiOther);
        return GiOther;
    }

    @Override
    public PageInfo<GarbageInformation> getGiListByCity(Integer pageNum, Integer pageSize, String cityName) {
        List<GarbageInformation> list = dao.getGiListByCity(pageNum, pageSize,cityName);
        PageInfo<GarbageInformation> pageInfo = new PageInfo<>(list);
        log.info("查询条数：" + pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public void insertGiInfo(GarbageInformation garbageInformation) {
        dao.insertGiInfo(garbageInformation);
        log.info("插入编号：" + garbageInformation.getGiId());
    }

    @Override
    public void updateGiInfo(GarbageInformation garbageInformation) {
        dao.updateGiInfo(garbageInformation);
        log.info("修改编号：" + garbageInformation.getGiId());
    }

    @Override
    public void deleteGiInfo(String giId) {
        dao.deleteGiInfo(giId);
        log.info("修改编号：" + giId);
    }
}
