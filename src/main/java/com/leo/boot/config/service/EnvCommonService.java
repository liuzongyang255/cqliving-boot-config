/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service;

import java.util.List;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import com.leo.boot.config.dal.dto.EnvCommonDTO;
import com.leo.boot.config.dal.entity.EnvCommonDO;
import com.leo.boot.config.dal.query.EnvCommonQuery;

/**
 * <p> env_common service层</p>
 */
public interface EnvCommonService{

    /**
     * <p>插入数据</p>
     *    @param envCommon
     *    @return int
     */
    public int insert( EnvCommonDO envCommon);

    /**
     * <p>插入不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    public int insertSelective( EnvCommonDO envCommon);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable<EnvCommonDO> list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param envCommon
     *    @return List<EnvCommonDO>
     */
    public List<EnvCommonDO> query( EnvCommonDO envCommon);

    /**
     * <p>根据主键修改数据</p>
     *    @param envCommon
     *    @return int
     */
    public int update( EnvCommonDO envCommon);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    public int updateSelective( EnvCommonDO envCommon);

    /**
     * <p>根据主键删除数据</p>
     *    @param envCommon
     *    @return int
     */
    public int delete( EnvCommonDO envCommon);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvCommonDO
     */
    public EnvCommonDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvCommonDO>
     */
    public List<EnvCommonDO> findByIdIn( Iterable<Long> list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable<Long> list);

    public PaginationResponse<EnvCommonDTO> page(EnvCommonQuery query);

    public void save(EnvCommonDTO dto);

    /**
     * [方法名]查询分页并包含指定envId是否引用
     * @author     leo
     * @since      2020年2月13日 下午6:31:06
     * @param envId
     * @return
     */
    public List<EnvCommonDTO> listWithUsed(Long envId);

}