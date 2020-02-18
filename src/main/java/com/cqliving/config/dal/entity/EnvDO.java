/*
 * http://www.leo.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>环境配置 env do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EnvDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /**  */
    private Long id;

    /** 环境名 */
    private String envName;

    /** 所有配置 */
    private String content;

    /** 项目id */
    private Long projectId;

}
