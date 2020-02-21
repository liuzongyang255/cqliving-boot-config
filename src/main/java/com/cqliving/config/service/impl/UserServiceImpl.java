/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.cqliving.config.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqliving.config.common.CommonService;
import com.cqliving.config.dal.dto.UserDto;
import com.cqliving.config.dal.entity.UserDO;
import com.cqliving.config.dal.mapper.UserDAO;
import com.cqliving.config.dal.query.UserQuery;
import com.cqliving.config.error.LoginReultCode;
import com.cqliving.config.service.UserService;
import com.cqliving.config.util.IDUtils;

import cqliving.framework.cloud.core.error.BizException;
import cqliving.framework.cloud.core.utils.Copier;

/**
 * <p> user service实现层</p>
 */
@Service
public class UserServiceImpl extends CommonService implements UserService{
    
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
    public int batchInsert( Iterable<UserDO> list){
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
    public List<UserDO> query( UserDO user){
        return userDAO.query( user);
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
    public List<UserDO> findByUserNameIn( Iterable<String> list){
        return userDAO.findByUserNameIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByUserNameIn( Iterable<String> list){
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
    public List<UserDO> findByIdIn( Iterable<Long> list){
        return userDAO.findByIdIn( list );
    }

    /**
     * <p>根据主键列表删除多条数据</p>
     *    @param list
     *    @return int
     */
    @Override
    public int deleteByIdIn( Iterable<Long> list){
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
        try {
            request.getSession().invalidate();
        } catch (Exception e) {
            logger.warn("登出出错:{}", e);
        }
    }
    
    @Override
    public PaginationResponse<UserDto> page(UserQuery query) {
        return page(getPage(query), copyList(userDAO.query(query.toDo(UserDO.class)), UserDto.class));
    }
    
    @Override
    public void add(UserDto user) {
        
        if(!user.getUserPass().equals(user.getUserPass2())) {
            throw new BizException(LoginReultCode.USER_PASS2_ERROR);
        }
        
        UserDO param = findByUserName(user.getUserName());
        if (null != param) {
            throw new BizException(LoginReultCode.USER_NAME_EXISTS);
        }
        
        UserDO userDO = Copier.copy(user, UserDO.class);
        userDO.setUserSalt(IDUtils.uuid());
        userDO.setUserPass(DigestUtils.md5Hex(user.getUserPass().concat(userDO.getUserSalt())));
        userDO.setCreateTime(new Date());
        userDO.setCreator(getUser().getRealName());
        insert(userDO);
    }
    
    /** 默认密码 */
    private static final String DEFAULT_PASS = "xhl123456";
    
    @Override
    public void reset(Long userId) {
        UserDO user = findById(userId);
        if (null == user) {
            throw new BizException(LoginReultCode.USER_NOT_EXISTS);
        }
        user.setUserSalt(IDUtils.uuid());
        user.setUserPass(DigestUtils.md5Hex(DEFAULT_PASS.concat(user.getUserSalt())));
        user.setCreateTime(new Date());
        user.setCreator(getUser().getRealName());
        updateSelective(user);
    }

}