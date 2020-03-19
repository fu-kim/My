package edu.nf.gc.web;

import edu.nf.gc.entity.GarbageInformation;
import edu.nf.gc.service.GarbageInformationService;
import edu.nf.gc.web.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Fu
 * @date 2019/12/13
 */
@RestController
public class ExcelController {
    
    @Autowired
    private GarbageInformationService service;

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<GarbageInformation> glist = service.gList();

        //excel标题
        String[] title = {"编号", "城市名称", "总量", "有害垃圾总量","可回收垃圾总量","厨余垃圾垃圾总量","其他垃圾总量","录入时间","操作员"};

        //excel文件名
        String fileName = "垃圾分类回收信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "垃圾分类回收信息表";

        String [][] content = new String[glist.size()][9];

        for (int i = 0; i < glist.size(); i++) {
            content[i] = new String[title.length];
            GarbageInformation obj = glist.get(i);
            content[i][0] = obj.getGiId().toString();
            content[i][1] = obj.getGiCity();
            content[i][2] = obj.getGiTotal().toString();
            content[i][3] = obj.getGiHarmful().toString();
            content[i][4] = obj.getGiRecyclable().toString();
            content[i][5] = obj.getGiKitchenWaste().toString();
            content[i][6] = obj.getGiOther().toString();
            content[i][7] = obj.getGiIntoDate().toString();
            content[i][8] = obj.getGiStaff();
        }

        ExcelUtils excelUtils = new ExcelUtils();
        //创建HSSFWorkbook
        HSSFWorkbook wb = excelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
