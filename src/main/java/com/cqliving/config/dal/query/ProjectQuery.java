package com.cqliving.config.dal.query;

import cqliving.framework.cloud.core.pojo.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    ProjectQuery.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 下午1:57:36                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: TODO        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper=false)
public class ProjectQuery extends BaseQuery{
    
    private static final long serialVersionUID = -307723457276064954L;

    private String name;
    
    private Long userId;
    
}

 
 
