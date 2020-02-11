/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.ProjectDO;
/**
 * <p> project dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface ProjectDAO {

    /**
     * <p>插入数据</p>
     *    @param project
     *    @return int
     */
    public int insert( @Param("project")ProjectDO project);

    /**
     * <p>插入不为空的数据</p>
     *    @param project
     *    @return int
     */
    public int insertSelective( @Param("project")ProjectDO project);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param project
     *    @return List<ProjectDO>
     */
    public List<ProjectDO> query( @Param("project")ProjectDO project);

    /**
     * <p>根据主键修改数据</p>
     *    @param project
     *    @return int
     */
    public int update( @Param("project")ProjectDO project);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param project
     *    @return int
     */
    public int updateSelective( @Param("project")ProjectDO project);

    /**
     * <p>根据主键删除数据</p>
     *    @param project
     *    @return int
     */
    public int delete( @Param("project")ProjectDO project);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return ProjectDO
     */
    public ProjectDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<ProjectDO>
     */
    public List<ProjectDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}