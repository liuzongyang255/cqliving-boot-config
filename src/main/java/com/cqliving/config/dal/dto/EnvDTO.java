package com.cqliving.config.dal.dto;

import cqliving.framework.cloud.core.pojo.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    EnvDTO.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 下午11:43:43                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: EnvDTO        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper = false)
public class EnvDTO extends BaseDTO{
    
    private static final long serialVersionUID = -7242450498201770633L;
    
    /**  */
    private Long id;

    private String envName;

    /** 所有配置 */
    private String content;

    private Long projectId;
    
    private String commonIds;
    
    public static interface Save{}
}

 
 
