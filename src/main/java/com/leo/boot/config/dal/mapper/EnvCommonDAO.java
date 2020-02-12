/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.EnvCommonDO;
/**
 * <p> env_common dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface EnvCommonDAO {

    /**
     * <p>插入数据</p>
     *    @param envCommon
     *    @return int
     */
    public int insert( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>插入不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    public int insertSelective( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param envCommon
     *    @return List<EnvCommonDO>
     */
    public List<EnvCommonDO> query( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>根据主键修改数据</p>
     *    @param envCommon
     *    @return int
     */
    public int update( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    public int updateSelective( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>根据主键删除数据</p>
     *    @param envCommon
     *    @return int
     */
    public int delete( @Param("envCommon")EnvCommonDO envCommon);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvCommonDO
     */
    public EnvCommonDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvCommonDO>
     */
    public List<EnvCommonDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}