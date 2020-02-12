/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.EnvCommonRefDO;
/**
 * <p> env_common_ref dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface EnvCommonRefDAO {

    /**
     * <p>插入数据</p>
     *    @param envCommonRef
     *    @return int
     */
    public int insert( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>插入不为空的数据</p>
     *    @param envCommonRef
     *    @return int
     */
    public int insertSelective( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param envCommonRef
     *    @return List<EnvCommonRefDO>
     */
    public List<EnvCommonRefDO> query( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>根据主键修改数据</p>
     *    @param envCommonRef
     *    @return int
     */
    public int update( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param envCommonRef
     *    @return int
     */
    public int updateSelective( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>根据主键删除数据</p>
     *    @param envCommonRef
     *    @return int
     */
    public int delete( @Param("envCommonRef")EnvCommonRefDO envCommonRef);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvCommonRefDO
     */
    public EnvCommonRefDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvCommonRefDO>
     */
    public List<EnvCommonRefDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}