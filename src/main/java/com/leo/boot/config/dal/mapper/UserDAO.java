/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.leo.boot.config.dal.entity.UserDO;
/**
 * <p> user dao层</p>
 */
 @SuppressWarnings("rawtypes")
public interface UserDAO {

    /**
     * <p>插入数据</p>
     *    @param user
     *    @return int
     */
    public int insert( @Param("user")UserDO user);

    /**
     * <p>插入不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int insertSelective( @Param("user")UserDO user);

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    public int batchInsert( @Param("list")Iterable list);

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param user
     *    @param start
     *    @param pageSize
     *    @return List<UserDO>
     */
    public List<UserDO> query( @Param("user")UserDO user,  @Param("start")long start,  @Param("pageSize")int pageSize);

    /**
     * <p>根据输入条件查询数据总数</p>
     *    @param user
     *    @return long
     */
    public long queryCount( @Param("user")UserDO user);

    /**
     * <p>根据主键修改数据</p>
     *    @param user
     *    @return int
     */
    public int update( @Param("user")UserDO user);

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int updateSelective( @Param("user")UserDO user);

    /**
     * <p>根据主键删除数据</p>
     *    @param user
     *    @return int
     */
    public int delete( @Param("user")UserDO user);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userName
     *    @return UserDO
     */
    public UserDO findByUserName( @Param("userName")String userName);

    /**
     * <p>根据主键删除数据</p>
     *    @param userName
     *    @return int
     */
    public int deleteByUserName( @Param("userName")String userName);

    /**
     * <p>修改数据</p>
     *    @param user
     *    @return int
     */
    public int updateByUserName( @Param("user")UserDO user);

    /**
     * <p>值修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    public int updateSelectiveByUserName( @Param("user")UserDO user);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    public List<UserDO> findByUserNameIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByUserNameIn( @Param("list")Iterable list);

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserDO
     */
    public UserDO findById( @Param("id")Long id);

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    public int deleteById( @Param("id")Long id);

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    public List<UserDO> findByIdIn( @Param("list")Iterable list);

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    public int deleteByIdIn( @Param("list")Iterable list);

}