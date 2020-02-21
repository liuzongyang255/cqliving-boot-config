/**
 * Copyright (c) 2020 CQLIVING, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * CQLIVING, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with CQLIVING.
 */
package com.cqliving.config.dal.query;

import cqliving.framework.cloud.core.pojo.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Title:
 * <p>Description:</p>
 * Copyright (c) CQLIVING 2020
 * @author liuzongyang on 2020年2月21日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends BaseQuery{
    
    private static final long serialVersionUID = 635943472851707220L;
    
    /** 用户名 */
    private String userName;
    
    /** 真实姓名 */
    private String realName;

    /** 邮件地址 */
    private String email;

}
