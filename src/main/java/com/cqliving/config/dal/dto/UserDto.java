package com.cqliving.config.dal.dto;

import javax.validation.constraints.NotBlank;
import cqliving.framework.cloud.core.pojo.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/********************************************************/
/*
FileName            :    UserDto.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午3:42:30                  
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
public class UserDto extends BaseDTO{

    private static final long serialVersionUID = -1401445275749989275L;

    /** 用户名 */
    @NotBlank(message = "用户名不能为空！", groups = {Login.class})
    private String userName;
    /** 密码 */
    @NotBlank(message = "密码不能为空！", groups = {Login.class})
    private String userPass;
    
    /** 重复密码 */
    @NotBlank(message = "重复密码不能为空", groups = {Regist.class})
    private String userPass2;
    
    /** 真实姓名 */
    @NotBlank(message = "姓名不能为空", groups = {Regist.class})
    private String realName;

    /** 邮件地址 */
    @NotBlank(message = "邮件不能为空", groups = {Regist.class})
    private String email;
    
    
    public static interface Login{}
    public static interface Regist{}
    
    
}

 
 
