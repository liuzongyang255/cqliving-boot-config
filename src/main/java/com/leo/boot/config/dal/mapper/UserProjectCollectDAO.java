/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.UserProjectCollectDO;
/**
 * <p> user_project_collect dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface UserProjectCollectDAO {

    /**
     * <p>插入数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int insert( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>插入不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int insertSelective( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userProjectCollect
     *    @return List<UserProjectCollectDO>
     */
    public List<UserProjectCollectDO> query( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int update( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateSelective( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据主键删除数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int delete( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserProjectCollectDO
     */
    public UserProjectCollectDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserProjectCollectDO>
     */
    public List<UserProjectCollectDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userId
     *    @param projectId
     *    @return UserProjectCollectDO
     */
    public UserProjectCollectDO findByUserIdAndProjectId( @Param("userId")Long userId,  @Param("projectId")Long projectId);

    /**
     * <p>根据主键删除数据</p>
     *    @param userId
     *    @param projectId
     *    @return int
     */
    public int deleteByUserIdAndProjectId( @Param("userId")Long userId,  @Param("projectId")Long projectId);

    /**
     * <p>修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateByUserIdAndProjectId( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

    /**
     * <p>值修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    public int updateSelectiveByUserIdAndProjectId( @Param("userProjectCollect")UserProjectCollectDO userProjectCollect);

}