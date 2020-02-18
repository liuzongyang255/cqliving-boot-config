/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p> env_common_ref do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EnvCommonRefDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /**  */
    private Long id;

    /** 公共配置id */
    private Long commonId;

    /** 环境id */
    private Long envId;

}
