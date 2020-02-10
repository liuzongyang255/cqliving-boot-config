/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service;

import java.util.List;
import com.leo.boot.config.dal.dto.UserDto;
import com.leo.boot.config.dal.entity.UserDO;

/**
 * <p> user service层</p>
 */
public interface UserService{

    /**
     * <p>插入数据</p>
     *    @param user
     *    @return int
     */
    public int insert( UserDO user);

    /**
     * <p>插入不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int insertSelective( UserDO user);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param user
     *    @param start
     *    @param pageSize
     *    @return List<UserDO>
     */
    public List<UserDO> query( UserDO user,  long start,  int pageSize);

    /**
     * <p>根据输入条件查询数据总数</p>
     *    @param user
     *    @return long
     */
    public long queryCount( UserDO user);

    /**
     * <p>根据主键修改数据</p>
     *    @param user
     *    @return int
     */
    public int update( UserDO user);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int updateSelective( UserDO user);

    /**
     * <p>根据主键删除数据</p>
     *    @param user
     *    @return int
     */
    public int delete( UserDO user);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userName
     *    @return UserDO
     */
    public UserDO findByUserName( String userName);

    /**
     * <p>根据主键删除数据</p>
     *    @param userName
     *    @return int
     */
    public int deleteByUserName( String userName);

    /**
     * <p>修改数据</p>
     *    @param user
     *    @return int
     */
    public int updateByUserName( UserDO user);

    /**
     * <p>值修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int updateSelectiveByUserName( UserDO user);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    public List<UserDO> findByUserNameIn( Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByUserNameIn( Iterable list);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserDO
     */
    public UserDO findById( Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    public List<UserDO> findByIdIn( Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( Iterable list);
    
    public void login(UserDto user);

    public void logout();

}