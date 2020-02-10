/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service.impl;

import java.util.List;
import org.cqliving.framework.cloud.mybatis.mvc.AbstractService;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.leo.boot.config.dal.dto.UserActLogDTO;
import com.leo.boot.config.dal.entity.UserActLogDO;
import com.leo.boot.config.dal.mapper.UserActLogDAO;
import com.leo.boot.config.dal.mapper.UserActLogExDAO;
import com.leo.boot.config.dal.query.UserActLogQuery;
import com.leo.boot.config.service.UserActLogService;

/**
 * <p> user_act_log service实现层</p>
 */
@Service
public class UserActLogServiceImpl extends AbstractService implements UserActLogService{
    
    @Autowired
    private UserActLogDAO userActLogDAO;
    @Autowired
    private UserActLogExDAO userActLogExDAO;


    /**
     * <p>插入数据</p>
     *    @param userActLog
     *    @return int
     */
    @Override
    public int insert( UserActLogDO userActLog){
        return userActLogDAO.insert( userActLog );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    @Override
    public int insertSelective( UserActLogDO userActLog){
        return userActLogDAO.insertSelective( userActLog );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable<UserActLogDO> list){
        return userActLogDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userActLog
     *    @return List<UserActLogDO>
     */
    @Override
    public List<UserActLogDO> query( UserActLogDO userActLog){
        return userActLogDAO.query( userActLog);
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param userActLog
     *    @return int
     */
    @Override
    public int update( UserActLogDO userActLog){
        return userActLogDAO.update( userActLog );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userActLog
     *    @return int
     */
    @Override
    public int updateSelective( UserActLogDO userActLog){
        return userActLogDAO.updateSelective( userActLog );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param userActLog
     *    @return int
     */
    @Override
    public int delete( UserActLogDO userActLog){
        return userActLogDAO.delete( userActLog );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserActLogDO
     */
    @Override
    public UserActLogDO findById( Long id){
        return userActLogDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return userActLogDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserActLogDO>
     */
    @Override
    public List<UserActLogDO> findByIdIn( Iterable<Long>  list){
        return userActLogDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long>  list){
        return userActLogDAO.deleteByIdIn( list );
    }
    
    @Override
    public PaginationResponse<UserActLogDTO> page(UserActLogQuery dto) {
        Page<UserActLogDTO> page = getPage(dto);
        List<UserActLogDTO> list = userActLogExDAO.query(dto);
        return new PaginationResponse<>(list, page);
    }

}