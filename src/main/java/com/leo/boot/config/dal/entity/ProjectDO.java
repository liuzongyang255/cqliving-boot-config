/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p> project do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ProjectDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /**  */
    private Long id;

    /**  */
    private String name;

    /**  */
    private Long userId;

    /** 备注 */
    private String remark;

}
