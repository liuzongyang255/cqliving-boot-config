/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.leo.boot.config.dal.dto.EnvCommonDTO;

/**
 * <p> env_common dao层</p>
 */
public interface EnvCommonExDAO {

    List<EnvCommonDTO> listWithUsed(@Param("envId") Long envId);
    
    List<EnvCommonDTO> listByEnvId(@Param("envId") Long envId);
}