/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.service.impl;

import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.cqliving.framework.cloud.mybatis.mvc.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leo.boot.config.dal.dto.UserDto;
import com.leo.boot.config.dal.entity.UserDO;
import com.leo.boot.config.dal.mapper.UserDAO;
import com.leo.boot.config.error.LoginReultCode;
import com.leo.boot.config.service.UserService;
import cqliving.framework.cloud.core.error.BizException;

/**
 * <p> user service实现层</p>
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService{
    
    @Autowired
    private UserDAO userDAO;


    /**
     * <p>插入数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int insert( UserDO user){
        return userDAO.insert( user );
    }

    /**
     * <p>插入不为空的数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int insertSelective( UserDO user){
        return userDAO.insertSelective( user );
    }

    /**
     * <p>批量插入数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int batchInsert( Iterable list){
        return userDAO.batchInsert( list );
    }

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param user
     *    @param start
     *    @param pageSize
     *    @return List<UserDO>
     */
    @Override
    public List<UserDO> query( UserDO user,  long start,  int pageSize){
        return userDAO.query( user , start , pageSize );
    }

    /**
     * <p>根据输入条件查询数据总数</p>
     *    @param user
     *    @return long
     */
    @Override
    public long queryCount( UserDO user){
        return userDAO.queryCount( user );
    }

    /**
     * <p>根据主键修改数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int update( UserDO user){
        return userDAO.update( user );
    }

    /**
     * <p>根据主键修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int updateSelective( UserDO user){
        return userDAO.updateSelective( user );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int delete( UserDO user){
        return userDAO.delete( user );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param userName
     *    @return UserDO
     */
    @Override
    public UserDO findByUserName( String userName){
        return userDAO.findByUserName( userName );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param userName
     *    @return int
     */
    @Override
    public int deleteByUserName( String userName){
        return userDAO.deleteByUserName( userName );
    }

    /**
     * <p>修改数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int updateByUserName( UserDO user){
        return userDAO.updateByUserName( user );
    }

    /**
     * <p>值修改不为空的数据</p>
     *    @param user
     *    @return int
     */
    @Override
    public int updateSelectiveByUserName( UserDO user){
        return userDAO.updateSelectiveByUserName( user );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    @Override
    public List<UserDO> findByUserNameIn( Iterable list){
        return userDAO.findByUserNameIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByUserNameIn( Iterable list){
        return userDAO.deleteByUserNameIn( list );
    }

    /**
     * <p>根据指定字段的值查询数据</p>
     *    @param id
     *    @return UserDO
     */
    @Override
    public UserDO findById( Long id){
        return userDAO.findById( id );
    }

    /**
     * <p>根据主键删除数据</p>
     *    @param id
     *    @return int
     */
    @Override
    public int deleteById( Long id){
        return userDAO.deleteById( id );
    }

    /**
     * <p>根据指定字段的多个值查询数据</p>
     *    @param list
     *    @return List<UserDO>
     */
    @Override
    public List<UserDO> findByIdIn( Iterable list){
        return userDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable list){
        return userDAO.deleteByIdIn( list );
    }
    
    @Override
    public void login(UserDto user) {
        
        UserDO userDO = userDAO.findByUserName(user.getUserName());
        if(null == userDO) {
            throw new BizException(LoginReultCode.USER_NOT_EXISTS);
        }
        
        String userPass = DigestUtils.md5Hex(user.getUserPass().concat(userDO.getUserSalt()));
        if (!userPass.equals(userDO.getUserPass())) {
            throw new BizException(LoginReultCode.USER_PASS_ERROR);
        }
        request.getSession().setAttribute("user", userDO);
        
    }
    
    @Override
    public void logout() {
        request.getSession().invalidate();
    }

}