/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.service;

import java.util.List;

import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;

import com.cqliving.config.dal.dto.EnvDTO;
import com.cqliving.config.dal.entity.EnvDO;
import com.cqliving.config.dal.query.EnvQuery;

/**
 * <p> env service层</p>
 */
public interface EnvService{

    /**
     * <p>插入数据</p>
     *    @param env
     *    @return int
     */
    public int insert( EnvDO env);

    /**
     * <p>插入不为空的数据</p>
     *    @param env
     *    @return int
     */
    public int insertSelective( EnvDO env);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable<EnvDO> list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param env
     *    @return List<EnvDO>
     */
    public List<EnvDO> query( EnvDO env);

    /**
     * <p>根据主键修改数据</p>
     *    @param env
     *    @return int
     */
    public int update( EnvDO env);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param env
     *    @return int
     */
    public int updateSelective( EnvDO env);

    /**
     * <p>根据主键删除数据</p>
     *    @param env
     *    @return int
     */
    public int delete( EnvDO env);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvDO
     */
    public EnvDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvDO>
     */
    public List<EnvDO> findByIdIn( Iterable<Long> list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable<Long> list);

    public PaginationResponse<EnvDTO> page(EnvQuery query);

    public void save(EnvDTO envDTO);

    /**
     * <p></p>
     * @author liuzongyang on 2020年2月16日
     * @param appName
     * @param envName
     * @return
     */
    public String getByProjectNameAndEnvName(String appName, String envName);

}