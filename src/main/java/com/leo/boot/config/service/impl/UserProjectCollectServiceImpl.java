/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leo.boot.config.dal.entity.UserProjectCollectDO;
import com.leo.boot.config.dal.mapper.UserProjectCollectDAO;
import com.leo.boot.config.service.UserProjectCollectService;

/**
 * <p> user_project_collect service实现层</p>
 */
@Service
public class UserProjectCollectServiceImpl implements UserProjectCollectService{
    
    @Autowired
    private UserProjectCollectDAO userProjectCollectDAO;


    /**
     * <p>插入数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int insert( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.insert( userProjectCollect );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int insertSelective( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.insertSelective( userProjectCollect );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable<UserProjectCollectDO> list){
        return userProjectCollectDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param userProjectCollect
     *    @return List<UserProjectCollectDO>
     */
    @Override
    public List<UserProjectCollectDO> query( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.query( userProjectCollect );
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int update( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.update( userProjectCollect );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int updateSelective( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.updateSelective( userProjectCollect );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int delete( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.delete( userProjectCollect );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserProjectCollectDO
     */
    @Override
    public UserProjectCollectDO findById( Long id){
        return userProjectCollectDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return userProjectCollectDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserProjectCollectDO>
     */
    @Override
    public List<UserProjectCollectDO> findByIdIn( Iterable<Long> list){
        return userProjectCollectDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long> list){
        return userProjectCollectDAO.deleteByIdIn( list );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userId
     *    @param projectId
     *    @return UserProjectCollectDO
     */
    @Override
    public UserProjectCollectDO findByUserIdAndProjectId( Long userId,  Long projectId){
        return userProjectCollectDAO.findByUserIdAndProjectId( userId , projectId );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param userId
     *    @param projectId
     *    @return int
     */
    @Override
    public int deleteByUserIdAndProjectId( Long userId,  Long projectId){
        return userProjectCollectDAO.deleteByUserIdAndProjectId( userId , projectId );
    }

    /**
     * <p>修改数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int updateByUserIdAndProjectId( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.updateByUserIdAndProjectId( userProjectCollect );
    }

    /**
     * <p>值修改不为空的数据</p>
     *    @param userProjectCollect
     *    @return int
     */
    @Override
    public int updateSelectiveByUserIdAndProjectId( UserProjectCollectDO userProjectCollect){
        return userProjectCollectDAO.updateSelectiveByUserIdAndProjectId( userProjectCollect );
    }

}