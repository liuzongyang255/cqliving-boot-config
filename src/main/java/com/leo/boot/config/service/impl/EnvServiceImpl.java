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
import com.leo.boot.config.dal.dto.EnvDTO;
import com.leo.boot.config.dal.entity.EnvDO;
import com.leo.boot.config.dal.mapper.EnvDAO;
import com.leo.boot.config.dal.query.EnvQuery;
import com.leo.boot.config.service.EnvService;

/**
 * <p> env service实现层</p>
 */
@Service
public class EnvServiceImpl extends CommonService implements EnvService{
    
    @Autowired
    private EnvDAO envDAO;


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
        EnvDO env = copy(envDTO, EnvDO.class);
        if (null == env.getId()) {
            envDAO.insert(env);
        }else {
            envDAO.updateSelective(env);
        }
    }

}