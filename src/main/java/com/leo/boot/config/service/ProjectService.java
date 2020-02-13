/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service;

import java.util.List;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import com.leo.boot.config.dal.dto.ProjectDTO;
import com.leo.boot.config.dal.entity.ProjectDO;
import com.leo.boot.config.dal.query.ProjectQuery;

/**
 * <p> project service层</p>
 */
public interface ProjectService{

    /**
     * <p>插入数据</p>
     *    @param project
     *    @return int
     */
    public int insert( ProjectDO project);

    /**
     * <p>插入不为空的数据</p>
     *    @param project
     *    @return int
     */
    public int insertSelective( ProjectDO project);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable<ProjectDO> list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param project
     *    @return List<ProjectDO>
     */
    public List<ProjectDO> query( ProjectDO project);

    /**
     * <p>根据主键修改数据</p>
     *    @param project
     *    @return int
     */
    public int update( ProjectDO project);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param project
     *    @return int
     */
    public int updateSelective( ProjectDO project);

    /**
     * <p>根据主键删除数据</p>
     *    @param project
     *    @return int
     */
    public int delete( ProjectDO project);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return ProjectDO
     */
    public ProjectDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<ProjectDO>
     */
    public List<ProjectDO> findByIdIn( Iterable<Long> list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable<Long> list);
    
    public PaginationResponse<ProjectDTO> page(ProjectQuery query);

    /**
     * [方法名]新增或修改
     * @author     leo
     * @since      2020年2月11日 下午2:49:00
     * @param projectDTO
     */
    public void save(ProjectDTO projectDTO);

    public PaginationResponse<ProjectDTO> pageCollect(ProjectQuery query);
    
}