/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p> user do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /** 主键 */
    private Long id;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String userPass;

    /** 盐值 */
    private String userSalt;

    /** 真实姓名 */
    private String realName;

    /** 邮件地址 */
    private String email;

}
