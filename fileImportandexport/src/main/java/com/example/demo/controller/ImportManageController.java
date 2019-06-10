package com.example.demo.controller;


import com.example.demo.common.DateUtil;
import com.example.demo.common.ImportExcelCommon;
import com.example.demo.common.InterfaceBase;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: fileImportandexport
 * @description: 需要导入的数据
 * @author: KJH
 * @create: 2019-04-28 09:13
 */
@Controller
@RequestMapping
public class ImportManageController extends InterfaceBase {
    @RequestMapping(value = "/index")
    public String index(){
        return "/import/import";
    }

    @RequestMapping(value = "/import")
    public void exportManagee(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return;
            }
            String fileName = file.getOriginalFilename();//获取文件名称
            String prefix = fileName.substring(fileName.lastIndexOf("."));// 获取文件后缀
            File excelFile = File.createTempFile(DateUtil.getSdfTimes(), prefix);//生成文件
            file.transferTo(excelFile);//生成临时文件，结束后要删除
            List<User> userList = new ArrayList<User>();//新增到数据库的list
            ImportExcelCommon importExcelCommon = new ImportExcelCommon();
            List<Object> list = importExcelCommon.importExcel(excelFile);//用于存放获取导入的信息
            if (!list.isEmpty() && list.size() > 2) {
                //2. 对得到的内容进行处理,放到对象中
                int rows = (int) list.get(0) - 1;//得到行,并减去第一行数据(有标题-1,没有就不用-1)
                int count = 2;//list 前两个数据固定成行和列了，所以下表从2开始
                int colums = (int) list.get(1);//得到列
                for (int i = 0; i < rows; i++) {
                    User user = new User();
                    user.setName(list.get(count).toString());
                    user.setSex(Integer.parseInt( list.get(count + 1).toString()));
                    user.setAge( Integer.parseInt(list.get(count + 2).toString()));
                    user.setMemo(list.get(count + 3).toString());
                    userList.add(user);
                    count += colums;//下次添加数据从这列添加数据之后去添加 如第一列4 从list下标2，第二次从list下标 6
                }
            }
        if (userList.size()>0){
            for (User user : userList) {
                userService.insert(user);
            }
        }
         //删除临时文件
        this.deleteFile(excelFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @Title: deleteFile
     * @Description: 删除临时添加的数据
     * @param   files
     * @return void
     * @author KJH
     * @date  2018年9月12日 上午11:09:12
     * @version V1.0
     * @throws
     */
    private void deleteFile(File... files) throws Exception {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
