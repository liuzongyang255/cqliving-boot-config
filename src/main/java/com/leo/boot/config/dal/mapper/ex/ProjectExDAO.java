/*
 * http://www.leo-config.com Inc
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.leo.boot.config.dal.mapper.ex;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.leo.boot.config.dal.dto.ProjectDTO;
import com.leo.boot.config.dal.query.ProjectQuery;
/**
 * <p> ProjectExDAO dao扩展</p>
 */
public interface ProjectExDAO {

    /**
     * <p>根据输入条件分页查询数据</p>
     *    @param query
     *    @return List<ProjectDTO>
     */
    public List<ProjectDTO> query( @Param("query") ProjectQuery query);


}