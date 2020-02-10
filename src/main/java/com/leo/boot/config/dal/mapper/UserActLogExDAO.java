/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.leo.boot.config.dal.dto.UserActLogDTO;
import com.leo.boot.config.dal.query.UserActLogQuery;
/**
 * <p> user_act_log dao扩展</p>
 */
public interface UserActLogExDAO {

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userActLog
     *    @return List<UserActLogDO>
     */
    public List<UserActLogDTO> query( @Param("userActLog") UserActLogQuery userActLog);


}