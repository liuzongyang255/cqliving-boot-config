/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.service;

import java.util.List;
import com.cqliving.config.dal.entity.UserProjectCollectDO;

/**
 * <p> user_project_collect service层</p>
 */
public interface UserProjectCollectService{

    /**
     * <p>插入数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int insert( UserProjectCollectDO userProjectCollect);

    /**
     * <p>插入不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int insertSelective( UserProjectCollectDO userProjectCollect);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable<UserProjectCollectDO> list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userProjectCollect
     *    @return List<UserProjectCollectDO>
     */
    public List<UserProjectCollectDO> query( UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int update( UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateSelective( UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键删除数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int delete( UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserProjectCollectDO
     */
    public UserProjectCollectDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserProjectCollectDO>
     */
    public List<UserProjectCollectDO> findByIdIn( Iterable<Long> list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable<Long> list);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userId
     *    @param projectId
     *    @return UserProjectCollectDO
     */
    public UserProjectCollectDO findByUserIdAndProjectId( Long userId,  Long projectId);

    /**
     * <p>根据主键删除数据</p>
     *    @param userId
     *    @param projectId
     *    @return int
     */
    public int deleteByUserIdAndProjectId( Long userId,  Long projectId);

    /**
     * <p>修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateByUserIdAndProjectId( UserProjectCollectDO userProjectCollect);

    /**
     * <p>值修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateSelectiveByUserIdAndProjectId( UserProjectCollectDO userProjectCollect);

}