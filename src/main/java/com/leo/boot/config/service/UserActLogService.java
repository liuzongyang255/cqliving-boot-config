/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service;

import java.util.List;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import com.leo.boot.config.dal.dto.UserActLogDTO;
import com.leo.boot.config.dal.entity.UserActLogDO;
import com.leo.boot.config.dal.query.UserActLogQuery;

/**
 * <p> user_act_log service层</p>
 */
public interface UserActLogService{

    /**
     * <p>插入数据</p>
     *    @param userActLog
     *    @return int
     */
    public int insert( UserActLogDO userActLog);

    /**
     * <p>插入不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    public int insertSelective( UserActLogDO userActLog);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userActLog
     *    @return List<UserActLogDO>
     */
    public List<UserActLogDO> query( UserActLogDO userActLog);

    /**
     * <p>根据主键修改数据</p>
     *    @param userActLog
     *    @return int
     */
    public int update( UserActLogDO userActLog);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    public int updateSelective( UserActLogDO userActLog);

    /**
     * <p>根据主键删除数据</p>
     *    @param userActLog
     *    @return int
     */
    public int delete( UserActLogDO userActLog);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserActLogDO
     */
    public UserActLogDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserActLogDO>
     */
    public List<UserActLogDO> findByIdIn( Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable list);

    public PaginationResponse<UserActLogDTO> page(UserActLogQuery dto);

}