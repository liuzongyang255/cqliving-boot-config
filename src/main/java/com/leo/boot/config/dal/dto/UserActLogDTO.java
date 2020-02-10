package com.leo.boot.config.dal.dto;

import java.util.Date;
import cqliving.framework.cloud.core.pojo.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    UserActLogDTO.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午7:29:24                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: TODO        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper=false)
public class UserActLogDTO extends BaseDTO{

    private static final long serialVersionUID = -7537712949686824157L;
    /**  */
    private Long id;

    /** 用户表id */
    private Long userId;

    /** api名 */
    private String apiName;

    /** api路径 */
    private String apiUrl;

    /** 参数 */
    private String params;
    
    private String realName;
    
    private Date createTime;
}

 
 
