package com.example.demo.controller;

import com.example.demo.common.ExportExcelCommon;
import com.example.demo.common.InterfaceBase;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: fileImportandexport
 * @description: 需要导出的数据
 * @author: KJH
 * @create: 2019-04-28 09:13
 */
@RestController
@RequestMapping
public class ExportManageController extends InterfaceBase {

    @RequestMapping(value = "/export")
    public  void  exportManagee(HttpServletResponse response,User user){
        Map< Integer, Object> map=new TreeMap<Integer, Object>();//添加导出数据第一行的内容
        Map< Integer, Object> maps=new TreeMap<Integer, Object>();//添加导出数据（从第二行开始）
//        map.put(0,"ID");
        map.put(0,"名称");
        map.put(1,"性别");
        map.put(2,"年龄");
        map.put(3,"记录");
        List<User> userList = userService.selectAll();
        try {
        //3遍历数据内容
           if (!userList.isEmpty() && userList.size()>0){
               for (int i = 0; i< userList.size(); ) {
//                       maps.put(i,userList.get(i).getId());
                       maps.put(i+0,userList.get(i).getName());
                       maps.put(i+1,userList.get(i).getSex());
                       maps.put(i+2,userList.get(i).getAge());
                       maps.put(i+3,userList.get(i).getMemo());
                       i+=map.size();
               }
           }
            ExportExcelCommon exportExcelCommon=new ExportExcelCommon();
            exportExcelCommon.exportExcel(response,map,maps);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
