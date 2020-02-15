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
import com.leo.boot.config.dal.dto.EnvCommonDTO;
import com.leo.boot.config.dal.entity.EnvCommonDO;
import com.leo.boot.config.dal.mapper.EnvCommonDAO;
import com.leo.boot.config.dal.mapper.ex.EnvCommonExDAO;
import com.leo.boot.config.dal.query.EnvCommonQuery;
import com.leo.boot.config.error.ProjectResultCode;
import com.leo.boot.config.service.EnvCommonService;

import cqliving.framework.cloud.core.error.BizException;

/**
 * <p> env_common service实现层</p>
 */
@Service
public class EnvCommonServiceImpl extends CommonService implements EnvCommonService{
    
    @Autowired
    private EnvCommonDAO envCommonDAO;
    
    @Autowired
    private EnvCommonExDAO envCommonExDAO;


    /**
     * <p>插入数据</p>
     *    @param envCommon
     *    @return int
     */
    @Override
    public int insert( EnvCommonDO envCommon){
        return envCommonDAO.insert( envCommon );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    @Override
    public int insertSelective( EnvCommonDO envCommon){
        return envCommonDAO.insertSelective( envCommon );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable<EnvCommonDO> list){
        return envCommonDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param envCommon
     *    @return List<EnvCommonDO>
     */
    @Override
    public List<EnvCommonDO> query( EnvCommonDO envCommon){
        return envCommonDAO.query( envCommon );
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param envCommon
     *    @return int
     */
    @Override
    public int update( EnvCommonDO envCommon){
        return envCommonDAO.update( envCommon );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param envCommon
     *    @return int
     */
    @Override
    public int updateSelective( EnvCommonDO envCommon){
        return envCommonDAO.updateSelective( envCommon );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param envCommon
     *    @return int
     */
    @Override
    public int delete( EnvCommonDO envCommon){
        return envCommonDAO.delete( envCommon );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return EnvCommonDO
     */
    @Override
    public EnvCommonDO findById( Long id){
        return envCommonDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return envCommonDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<EnvCommonDO>
     */
    @Override
    public List<EnvCommonDO> findByIdIn( Iterable<Long> list){
        return envCommonDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long> list){
        return envCommonDAO.deleteByIdIn( list );
    }
    
    @Override
    public PaginationResponse<EnvCommonDTO> page(EnvCommonQuery query) {
        return page(getPage(query), envCommonDAO.query(copy(query, EnvCommonDO.class)), EnvCommonDTO.class);
    }
    
    @Override
    public void save(EnvCommonDTO dto) {
        // 查重
        if (null != envCommonDAO.findByEnvName(dto.getEnvName())) {
            throw new BizException(ProjectResultCode.PROJECT_COMMON_ENV_EXISTS);
        }
        
        EnvCommonDO env = copy(dto, EnvCommonDO.class);
        if (null == env.getId()) {
            envCommonDAO.insert(env);
        }else {
            envCommonDAO.updateSelective(env);
        }
    }
    
    @Override
    public List<EnvCommonDTO> listWithUsed(Long envId) {
        return envCommonExDAO.listWithUsed(envId);
    }

}