/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.EnvDO;
/**
 * <p> env dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface EnvDAO {

    /**
     * <p>插入数据</p>
     *    @param env
     *    @return int
     */
    public int insert( @Param("env")EnvDO env);

    /**
     * <p>插入不为空的数据</p>
     *    @param env
     *    @return int
     */
    public int insertSelective( @Param("env")EnvDO env);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param env
     *    @return List<EnvDO>
     */
    public List<EnvDO> query( @Param("env")EnvDO env);

    /**
     * <p>根据主键修改数据</p>
     *    @param env
     *    @return int
     */
    public int update( @Param("env")EnvDO env);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param env
     *    @return int
     */
    public int updateSelective( @Param("env")EnvDO env);

    /**
     * <p>根据主键删除数据</p>
     *    @param env
     *    @return int
     */
    public int delete( @Param("env")EnvDO env);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvDO
     */
    public EnvDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvDO>
     */
    public List<EnvDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}