package com.leo.boot.config.controller;

import javax.validation.constraints.NotNull;

import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.boot.config.aspect.UserActLog;
import com.leo.boot.config.common.CommonController;
import com.leo.boot.config.dal.dto.EnvDTO;
import com.leo.boot.config.dal.dto.ProjectDTO;
import com.leo.boot.config.dal.query.EnvQuery;
import com.leo.boot.config.dal.query.ProjectQuery;
import com.leo.boot.config.service.EnvService;
import com.leo.boot.config.service.ProjectService;

/********************************************************/
/*
FileName            :    ProjectController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 上午11:13:53                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: ProjectController        						  
caution: something to be cautioned*/
/********************************************************/

@Controller
@RequestMapping("project")
@Validated
public class ProjectController extends CommonController{
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private EnvService envService;

    @GetMapping("")
    public String index() {
        return "project/list";
    }
    
    @GetMapping("page")
    @ResponseBody
    public PaginationResponse<ProjectDTO> page(ProjectQuery query){
        return projectService.page(query);
    }
    
    @PostMapping("del")
    @ResponseBody
    @UserActLog(apiName = "删除项目", apiUrl = "project/del")
    public BaseResponse del(Long id){
        projectService.deleteById(id);
        return success();
    }
    
    @GetMapping("page/collect")
    @ResponseBody
    public PaginationResponse<ProjectDTO> pageCollect(ProjectQuery query){
        return projectService.pageCollect(query);
    }
    
    @PostMapping("save")
    @ResponseBody
    @UserActLog(apiName = "保存项目", apiUrl = "project/save")
    public BaseResponse save(@Validated(ProjectDTO.Save.class) ProjectDTO dto) {
        projectService.save(dto);
        return success();
    }
    
    @GetMapping("env")
    public String env(Model model, @NotNull(message = "项目id不能为空")Long id) {
        model.addAttribute("projectId", id);
        return "project/env";
    }
    
    @GetMapping("env/list")
    @ResponseBody
    public PaginationResponse<EnvDTO> envList(@Validated EnvQuery query) {
        return envService.page(query);
    }
    
    @PostMapping("env/save")
    @ResponseBody
    @UserActLog(apiName = "保存环境配置", apiUrl = "project/env/save")
    public BaseResponse envSave(EnvDTO envDTO) {
        envService.save(envDTO);
        return success();
    }
    
    @PostMapping("env/del")
    @ResponseBody
    @UserActLog(apiName = "删除环境配置", apiUrl = "project/env/del")
    public BaseResponse envDel(Long envId) {
        envService.deleteById(envId);
        return success();
    }
    
    @PostMapping("env/publish")
    @ResponseBody
    @UserActLog(apiName = "发布环境配置", apiUrl = "project/env/publish")
    public BaseResponse envPublish(Long envId) {
        // FIXME publish
        return success();
    }
    
    @GetMapping("env/get")
    @ResponseBody
    public String envGet(String appName, String envName) {
        return envService.getByProjectNameAndEnvName(appName, envName);
    }
    
}

 
 
