package com.leo.boot.config.dal.query;

import javax.validation.constraints.NotNull;
import cqliving.framework.cloud.core.pojo.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    EnvQuery.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 下午11:46:22                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: EnvQuery        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper = false)
public class EnvQuery extends BaseQuery{
    
    private static final long serialVersionUID = 2643028185128927952L;

    private String envName;
    
    @NotNull(message = "项目id不能为空")
    private Long projectId;
    
}

 
 
