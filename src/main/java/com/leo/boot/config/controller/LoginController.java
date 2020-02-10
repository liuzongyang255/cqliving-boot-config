package com.leo.boot.config.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.cqliving.framework.cloud.mybatis.mvc.AbstractController;
import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.leo.boot.config.aspect.UserActLog;
import com.leo.boot.config.dal.dto.UserDto;
import com.leo.boot.config.dal.entity.UserDO;
import com.leo.boot.config.service.UserService;
import cn.hutool.core.lang.UUID;
import cqliving.framework.cloud.core.utils.Copier;

/********************************************************/
/*
FileName            :    UserController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午3:30:15                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: TODO        						  
caution: something to be cautioned*/
/********************************************************/

@Controller
@RequestMapping("")
public class LoginController extends AbstractController{
    
    @Autowired
    private UserService userService;
    
    @GetMapping("login")
    public String login() {
        return "login";
    }
    
    @PostMapping("login")
    @ResponseBody
    public BaseResponse login(@Validated UserDto user) {
        userService.login(user);
        return success();
    }
    
    @PostMapping("login/add")
    @ResponseBody
    @UserActLog(apiName = "新增用户", apiUrl = "login/add")
    public BaseResponse add(@Validated UserDto user) {
        UserDO userDO = Copier.copy(user, UserDO.class);
        userDO.setUserSalt(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        userDO.setUserPass(DigestUtils.md5Hex(user.getUserPass().concat(userDO.getUserSalt())));
        userService.insert(userDO);
        userService.login(user);
        return success();
    }
    
    @GetMapping("logout")
    public String logout() {
        userService.logout();
        return "login";
    }
    
    @GetMapping("home")
    public String home() {
        return "home";
    }
    
    
}

 
 
