/**
 * Copyright (c) 2020 CQLIVING, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * CQLIVING, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with CQLIVING.
 */
package com.cqliving.config.util;

import org.apache.commons.lang3.StringUtils;

import cn.hutool.core.util.IdUtil;

/**
 * Title:IDUtils
 * <p>Description:</p>
 * Copyright (c) CQLIVING 2020
 * @author liuzongyang on 2020年2月21日
 */
public class IDUtils {

    private IDUtils() {}
    
    private static final String COMA = "-";
    
    public static String uuid() {
        return IdUtil.fastUUID().replace(COMA, StringUtils.EMPTY).toLowerCase();
    }
    
}
