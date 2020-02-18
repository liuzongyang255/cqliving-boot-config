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
 * Title:EnvResultCode
 * <p>Description:</p>
 * Copyright (c) CQLIVING 2020
 * @author liuzongyang on 2020年2月16日
 */
public enum EnvResultCode implements ResponseMsgAble{
    
    /** 301, "环境名不存在" */
    ENV_NOT_EXISTS(301, "环境名不存在"),
    ;
    
    private int code;
    
    private String message;

    /**
     * @param code
     * @param message
     */
    private EnvResultCode(int code, String message) {
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
