package com.leo.boot.config.dal.query;

import java.util.Date;
import cqliving.framework.cloud.core.pojo.BaseQuery;

/********************************************************/
/*
FileName            :    UserActLogQuery.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午11:29:06                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: TODO        						  
caution: something to be cautioned*/
/********************************************************/

public class UserActLogQuery extends BaseQuery{

    private static final long serialVersionUID = 5438465757332683628L;
    
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

 
 