package com.leo.boot.config.dal.dto;

import javax.validation.constraints.NotBlank;
import cqliving.framework.cloud.core.pojo.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    ProjectDTO.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 上午11:22:49                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: ProjectDTO        						  
caution: something to be cautioned*/
/********************************************************/

@Data
@EqualsAndHashCode(callSuper=false)
public class ProjectDTO extends BaseDTO{

    private static final long serialVersionUID = -6175162360771315430L;
    
    /** 项目id */
    private Long id;

    /** 项目名 */
    @NotBlank(message = "项目名不能为空", groups = {Save.class})
    private String name;

    /** 用户id */
    private Long userId;
    
    /** 用户姓名 */
    private String realName;
    
    /** 备注 */
    private String remark;
    
    /** 是否已收藏 */
    private boolean collect;
    
    public static interface Save{}

}

 
 
