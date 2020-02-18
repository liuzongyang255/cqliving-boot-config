package com.cqliving.config.dal.query;

import cqliving.framework.cloud.core.pojo.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    EnvCommonQuery.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月12日 下午11:08:06                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月12日    LiuZongYang     1.0            新建
Brief Description: EnvCommonQuery        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper = false)
public class EnvCommonQuery extends BaseQuery{

    private static final long serialVersionUID = 7910316537427770252L;

    /** 环境名 */
    private String envName;
    
}

 
 
