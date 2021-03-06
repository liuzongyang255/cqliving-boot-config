/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.cqliving.config.dal.entity.UserActLogDO;
import java.util.List;
/**
 * <p> user_act_log dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface UserActLogDAO {

    /**
     * <p>插入数据</p>
     *    @param userActLog
     *    @return int
     */
    public int insert( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>插入不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    public int insertSelective( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userActLog
     *    @return List<UserActLogDO>
     */
    public List<UserActLogDO> query( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>根据主键修改数据</p>
     *    @param userActLog
     *    @return int
     */
    public int update( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    public int updateSelective( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>根据主键删除数据</p>
     *    @param userActLog
     *    @return int
     */
    public int delete( @Param("userActLog")UserActLogDO userActLog);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserActLogDO
     */
    public UserActLogDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserActLogDO>
     */
    public List<UserActLogDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}