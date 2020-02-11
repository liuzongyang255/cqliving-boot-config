package com.leo.boot.config.dal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    /** 环境名 */
    @NotBlank(message = "环境名不能为空", groups = Save.class)
    private String envName;

    /** 所有配置 */
    private String content;

    /** 项目id */
    @NotNull(message = "项目id不能为空", groups = Save.class)
    private Long projectId;
    
    public static interface Save{}
}

 
 
