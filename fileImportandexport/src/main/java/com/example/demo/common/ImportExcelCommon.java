package com.example.demo.common;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: fileImportandexport
 * @description: 导入文件成excel
 * @author: KJH
 * @create: 2019-04-28 09:09
 */
public class ImportExcelCommon {

    /**
      *@Description: 导入excel
      *@Param: File file
      *@return: List<Object> list list第一个数据是行（共几行） 第二个是列（共几列）
      *@Author: KJH
      *@date:
      **/
    public  List<Object> importExcel(File file){
        List<Object> list=new ArrayList();
        try {
           //1获取文件
            Workbook book=Workbook.getWorkbook(file);
            //2获得第一个工作表对象
            Sheet sheet=book.getSheet(0);
            //3得到所有的列,行
            int rows=sheet.getRows();//行
            int colums=sheet.getColumns();//列
            list.add(rows);
            list.add(colums);
            //4遍历数据
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < colums; j++) {
                    if(Tools.notEmpty(sheet.getCell(j,i).getContents())) {
                        list.add(sheet.getCell(j,i).getContents().trim());//得到数据并添加到list中
                    }
                }
            }
            //5.关闭资源
            book.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    return  list;
    }
}
