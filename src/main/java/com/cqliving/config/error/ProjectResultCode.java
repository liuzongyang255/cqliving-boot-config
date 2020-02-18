/**
 * Copyright (c) 2020 CQLIVING, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * CQLIVING, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with CQLIVING.
 */
package com.cqliving.config.error;

import cqliving.framework.cloud.core.result.ResponseMsgAble;

/**
 * Title:20开头的为项目错误
 * <p>Description:</p>
 * Copyright (c) CQLIVING 2020
 * @author liuzongyang on 2020年2月15日
 */
public enum ProjectResultCode implements ResponseMsgAble{
    
    /** 201, "项目名已存在" */
    PROJECT_EXISTS(201, "项目名已存在"),
    /** 202, "该项目下环境名已存在" */
    PROJECT_ENV_EXISTS(202, "该项目下环境名已存在"),
    /** 203, "公共环境名已存在" */
    PROJECT_COMMON_ENV_EXISTS(203, "公共环境名已存在"),
    /** 204, "项目不已存在" */
    PROJECT_NOT_EXISTS(204, "项目不已存在"),
    ;
    
    private int code;
    
    private String message;

    /**
     * @param code
     * @param message
     */
    private ProjectResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
