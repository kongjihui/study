package com.example.demo.common;

import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: fileImportandexport
 * @description:
 * @author: KJH
 * @create: 2019-04-28 10:32
 */
public class InterfaceBase {

    @Autowired
    public UserMapper userMapper;
    @Autowired
    public UserService userService;
}
