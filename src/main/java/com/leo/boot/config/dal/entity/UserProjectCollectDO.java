/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p> user_project_collect do层</p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserProjectCollectDO  extends cqliving.framework.cloud.core.pojo.BaseDO {

    private static final long serialVersionUID = -4282603875229233564L;

    /**  */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 项目id */
    private Long projectId;

}
