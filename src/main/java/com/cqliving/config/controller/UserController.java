/**
 * Copyright (c) 2020 CQLIVING, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * CQLIVING, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with CQLIVING.
 */
package com.cqliving.config.controller;

import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqliving.config.aspect.UserActLog;
import com.cqliving.config.common.CommonController;
import com.cqliving.config.dal.dto.UserDto;
import com.cqliving.config.dal.query.UserQuery;
import com.cqliving.config.service.UserService;

/**
 * Title:
 * <p>Description:</p>
 * Copyright (c) CQLIVING 2020
 * @author liuzongyang on 2020年2月21日
 */
@Controller
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends CommonController{
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String index() {
        return "user/list";
    }
    
    @GetMapping("page")
    @ResponseBody
    public PaginationResponse<UserDto> page(UserQuery query){
        return userService.page(query);
    }
    
    @PostMapping("add")
    @ResponseBody
    @UserActLog("新增用户")
    public BaseResponse add(@Validated(UserDto.Regist.class) UserDto user) {
        userService.add(user);
        return success();
    }
    
    @GetMapping("reset")
    @ResponseBody
    @UserActLog("重置密码")
    public BaseResponse reset(Long userId){
        userService.reset(userId);
        return success();
    }
    

}
