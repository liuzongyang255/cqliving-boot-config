/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service.impl;

import java.util.List;

import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.boot.config.common.CommonService;
import com.leo.boot.config.dal.dto.ProjectDTO;
import com.leo.boot.config.dal.entity.ProjectDO;
import com.leo.boot.config.dal.mapper.ProjectDAO;
import com.leo.boot.config.dal.mapper.ex.ProjectExDAO;
import com.leo.boot.config.dal.query.ProjectQuery;
import com.leo.boot.config.error.ProjectResultCode;
import com.leo.boot.config.service.ProjectService;

import cqliving.framework.cloud.core.error.BizException;

/**
 * <p> project service实现层</p>
 */
@Service
public class ProjectServiceImpl extends CommonService implements ProjectService{
    
    @Autowired
    private ProjectDAO projectDAO;
    
    @Autowired
    private ProjectExDAO projectExDAO;


    /**
     * <p>插入数据</p>
     *    @param project
     *    @return int
     */
    @Override
    public int insert( ProjectDO project){
        return projectDAO.insert( project );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param project
     *    @return int
     */
    @Override
    public int insertSelective( ProjectDO project){
        return projectDAO.insertSelective( project );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable<ProjectDO> list){
        return projectDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param project
     *    @return List<ProjectDO>
     */
    @Override
    public List<ProjectDO> query( ProjectDO project){
        return projectDAO.query( project );
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param project
     *    @return int
     */
    @Override
    public int update( ProjectDO project){
        return projectDAO.update( project );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param project
     *    @return int
     */
    @Override
    public int updateSelective( ProjectDO project){
        return projectDAO.updateSelective( project );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param project
     *    @return int
     */
    @Override
    public int delete( ProjectDO project){
        return projectDAO.delete( project );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return ProjectDO
     */
    @Override
    public ProjectDO findById( Long id){
        return projectDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return projectDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<ProjectDO>
     */
    @Override
    public List<ProjectDO> findByIdIn( Iterable<Long> list){
        return projectDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long> list){
        return projectDAO.deleteByIdIn( list );
    }
    
    @Override
    public PaginationResponse<ProjectDTO> page(ProjectQuery query) {
        query.setUserId(getUser().getId());
        return page(getPage(query), projectExDAO.query(query));
    }
    
    @Override
    public PaginationResponse<ProjectDTO> pageCollect(ProjectQuery query) {
        query.setUserId(getUser().getId());
        return page(getPage(query), projectExDAO.queryCollect(query));
    }
    
    @Override
    public void save(ProjectDTO projectDTO) {
        ProjectDO projectDO = copy(projectDTO, ProjectDO.class);
        projectDO.setUserId(getUser().getId());
        if (null != projectDAO.findByName(projectDO.getName())) {
            throw new BizException(ProjectResultCode.PROJECT_EXISTS);
        }
        
        if (null == projectDO.getId()) {
            projectDAO.insert(projectDO);
        }else {
            projectDAO.updateSelective(projectDO);
        }
        
    }

}