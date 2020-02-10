package com.leo.boot.config;

import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/********************************************************/
/*
FileName            :    ConfigApplication.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午2:48:49                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: 配置中心启动类        						  
caution: something to be cautioned*/
/********************************************************/
@SpringBootApplication
@MapperScan({"com.leo.boot.config.dal.mapper"})
@Controller
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
    
    @GetMapping("")
    @ResponseBody
    public BaseResponse console() {   
        return BaseResponse.success();
    }
    
    @GetMapping("index")
    public String index() {   
        return "index";
    }

}

 
 