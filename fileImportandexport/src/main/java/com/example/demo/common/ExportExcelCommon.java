package com.example.demo.common;

import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.*;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: fileImportandexport
 * @description: 导出文件成excel
 * @author: KJH
 * @create: 2019-04-28 09:09
 */
public class ExportExcelCommon {

    /**
     *@Description: 导出公共类
     *@Param: HttpServletResponse response, Map< Integer, Object> map, Map< Integer, Object> maps
     *@return:
     *@Author: KJH
     *@date:
     **/
    public  void exportExcel(HttpServletResponse response, Map< Integer, Object> map, Map< Integer, Object> maps) {
        //1.生成文件名称
        String fileName= DateUtil.getSdfTimes()+".xls";
        //2.设置编码，格式,头
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/x-excel");
        response.addHeader("Content-Disposition", "attachment;filename=" +fileName);
        //3.创建excel，设置格式
        try {
            //创建一个excel的sheet
            WritableWorkbook workbook= Workbook.createWorkbook(response.getOutputStream());
            //定义单元格格式 可以设置字体，颜色等
            WritableCellFormat wf=new WritableCellFormat();
            wf.setAlignment(Alignment.CENTRE);//中心对齐
//            //设置背景颜色;
//            wf.setBackground(Colour.BLUE_GREY);
//            //设置边框;
//            wf.setBorder(Border.ALL, BorderLineStyle.DASH_DOT);
//            //设置自动换行;
//            wf.setWrap(true);
//            //设置文字居中对齐方式;
//            wf.setAlignment(Alignment.CENTRE);
//            //设置垂直居中;
//            wf.setVerticalAlignment(VerticalAlignment.CENTRE);
            WritableSheet sheet=null;
            SheetSettings settings=null;
            for (int i = 0; i <=1; i++) {
                sheet = workbook.createSheet("用户信息列表",i);
                settings=sheet.getSettings(); //设置原Sheet打印属性到新Sheet页
//              settings.setHorizontalFreeze(2);//冻结前两行
                settings.setVerticalFreeze(1);//垂直冻结第一行
                //添加第一行标题
                int o=0;
                for (Map.Entry<Integer, Object> entrys : map.entrySet()) {
                    sheet.addCell(new Label(o,0,entrys.getValue()+"", wf));
                    o+=1;
                }
                //处理数据
                if(maps.size()>0) {
                    int h=0;//行
                    int l=0;//列
                    int s=0;//代表当一行所有列都添加进去后s++,然后重新复制行和列
                    for (Map.Entry<Integer, Object> entry : maps.entrySet()) {
                        if(0==s) {
                            l=0;//列
                            h+=1;//行
                        } else if (0 == s % map.size()){
                            l=0;//列
                            h++;//行
                        }
                        //第1行 0 0 - - 1 0 -- 2 0 - -
                        //第2行 0 1 - - 1 1 -- 3 1 - -
                        sheet.addCell(new Label(l++,h,entry.getValue()+"",wf));
                        s+=1;
                    }
                }
            }
            workbook.write();//写入excel
            workbook.close();//关闭资源
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
