/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.leo.boot.config.common.CommonService;
import com.leo.boot.config.dal.dto.EnvCommonDTO;
import com.leo.boot.config.dal.dto.EnvDTO;
import com.leo.boot.config.dal.entity.EnvCommonRefDO;
import com.leo.boot.config.dal.entity.EnvDO;
import com.leo.boot.config.dal.entity.ProjectDO;
import com.leo.boot.config.dal.mapper.EnvCommonRefDAO;
import com.leo.boot.config.dal.mapper.EnvDAO;
import com.leo.boot.config.dal.mapper.ex.EnvCommonExDAO;
import com.leo.boot.config.dal.query.EnvQuery;
import com.leo.boot.config.error.EnvResultCode;
import com.leo.boot.config.error.ProjectResultCode;
import com.leo.boot.config.service.EnvService;
import com.leo.boot.config.service.ProjectService;

import cqliving.framework.cloud.core.error.BizException;

/**
 * <p> env service实现层</p>
 */
@Service
public class EnvServiceImpl extends CommonService implements EnvService{
    
    @Autowired
    private EnvDAO envDAO;
    
    @Autowired
    private EnvCommonRefDAO commonRefDAO;
    
    @Autowired
    private EnvCommonExDAO envCommonExDAO;
    
    @Autowired
    private ProjectService projectService;


    /**
     * <p>插入数据</p>
     *    @param env
     *    @return int
     */
    @Override
    public int insert( EnvDO env){
        return envDAO.insert( env );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param env
     *    @return int
     */
    @Override
    public int insertSelective( EnvDO env){
        return envDAO.insertSelective( env );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable<EnvDO> list){
        return envDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param env
     *    @return List<EnvDO>
     */
    @Override
    public List<EnvDO> query( EnvDO env){
        return envDAO.query( env );
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param env
     *    @return int
     */
    @Override
    public int update( EnvDO env){
        return envDAO.update( env );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param env
     *    @return int
     */
    @Override
    public int updateSelective( EnvDO env){
        return envDAO.updateSelective( env );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param env
     *    @return int
     */
    @Override
    public int delete( EnvDO env){
        return envDAO.delete( env );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvDO
     */
    @Override
    public EnvDO findById( Long id){
        return envDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return envDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvDO>
     */
    @Override
    public List<EnvDO> findByIdIn( Iterable<Long> list){
        return envDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long> list){
        return envDAO.deleteByIdIn( list );
    }
    
    @Override
    public PaginationResponse<EnvDTO> page(EnvQuery query) {
        return page(getPage(query), envDAO.query(copy(query, EnvDO.class)), EnvDTO.class);
    }
    
    @Override
    public void save(EnvDTO envDTO) {
        
        // 查询是否重复
        if (null != envDAO.findByEnvNameAndProjectId(envDTO.getEnvName(), envDTO.getProjectId())) {
            throw new BizException(ProjectResultCode.PROJECT_ENV_EXISTS);
        }
        
        // 保存环境配置
        EnvDO env = copy(envDTO, EnvDO.class);
        if (null == env.getId()) {
            envDAO.insert(env);
        }else {
            envDAO.updateSelective(env);
        }
        
        // 保存公共配置关系
        if(StringUtils.isBlank(envDTO.getCommonIds())) {
            return;
        }
        commonRefDAO.deleteByEnvId(envDTO.getId());
        List<EnvCommonRefDO> dos = Lists.newArrayList();
        for (String commonId : envDTO.getCommonIds().split(",")) {
            EnvCommonRefDO rdo = new EnvCommonRefDO();
            rdo.setCommonId(Long.valueOf(commonId));
            rdo.setEnvId(envDTO.getId());
            dos.add(rdo);
        }
        commonRefDAO.batchInsert(dos);
        
    }
    
    
    @Override
    public String getByProjectNameAndEnvName(String appName, String envName) {
        ProjectDO project = projectService.getByProjectName(appName);
        if (null == project) {
            throw new BizException(ProjectResultCode.PROJECT_NOT_EXISTS);
        }
        EnvDO env = envDAO.findByEnvNameAndProjectId(envName, project.getId());
        if (null == env) {
            throw new BizException(EnvResultCode.ENV_NOT_EXISTS);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(env.getContent()).append("\r\n");
        List<EnvCommonDTO> commons = envCommonExDAO.listByEnvId(env.getId());
        for (EnvCommonDTO common : commons) {
            sb.append(common.getContent()).append("\r\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}