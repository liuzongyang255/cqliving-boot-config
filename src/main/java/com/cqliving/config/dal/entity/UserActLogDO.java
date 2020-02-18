/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.dal.entity;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p> user_act_log do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserActLogDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

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

    /** 创建时间 */
    private Date createTime;

}
