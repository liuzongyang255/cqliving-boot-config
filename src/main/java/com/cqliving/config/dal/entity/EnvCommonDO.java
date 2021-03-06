/*
 * http://www.leo.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>公共配置 env_common do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EnvCommonDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /**  */
    private Long id;

    /** 环境名 */
    private String envName;

    /** 配置文档 */
    private String content;

}
