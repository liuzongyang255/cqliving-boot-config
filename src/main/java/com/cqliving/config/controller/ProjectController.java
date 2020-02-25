package com.cqliving.config.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqliving.config.aspect.UserActLog;
import com.cqliving.config.common.CommonController;
import com.cqliving.config.dal.dto.EnvCommonDTO;
import com.cqliving.config.dal.dto.EnvDTO;
import com.cqliving.config.dal.dto.ProjectDTO;
import com.cqliving.config.dal.entity.EnvDO;
import com.cqliving.config.dal.query.EnvQuery;
import com.cqliving.config.dal.query.ProjectQuery;
import com.cqliving.config.error.EnvResultCode;
import com.cqliving.config.service.EnvCommonService;
import com.cqliving.config.service.EnvService;
import com.cqliving.config.service.ProjectService;

import cqliving.framework.cloud.core.error.BizException;

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
    
    @Autowired
    private EnvCommonService envCommonService;

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
    @UserActLog("删除项目")
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
    @UserActLog("保存项目")
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
    @UserActLog("保存环境配置")
    public BaseResponse envSave(EnvDTO envDTO) {
        envService.save(envDTO);
        return success();
    }
    
    @PostMapping("env/del")
    @ResponseBody
    @UserActLog("删除环境配置")
    public BaseResponse envDel(Long envId) {
        envService.deleteById(envId);
        return success();
    }
    
    @PostMapping("env/publish")
    @ResponseBody
    @UserActLog("发布环境配置")
    public BaseResponse envPublish(Long envId) {
        // FIXME publish
        return success();
    }
    
    @GetMapping("env/get")
    @ResponseBody
    public String envGet(String appName, String envName) {
        return envService.getByProjectNameAndEnvName(appName, envName);
    }

    @GetMapping("env/export")
    @ResponseBody
    public ResponseEntity<byte[]> envExport(Long envId) {
        EnvDO env = envService.findById(envId);
        if (null == env) {
            throw new BizException(EnvResultCode.ENV_NOT_EXISTS);
        }
        String content = StringUtils.isBlank(env.getContent())?StringUtils.EMPTY:env.getContent();
        List<EnvCommonDTO> commons = envCommonService.listWithUsed(envId);
        if (CollectionUtils.isNotEmpty(commons)) {
            for (EnvCommonDTO common : commons) {
                if (common.isUsed()) {
                    content = content.concat("\r\n")
                    .concat("# ").concat(common.getEnvName()).concat("\r\n")
                    .concat(common.getContent());
                }
            }
        }
        
        String fileName = "application-".concat(env.getEnvName()).concat(".properties");
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载文件方式打开
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment").filename(fileName).build();
        headers.setContentDisposition(contentDisposition);
        // application/octet_stream设置MIME为任意二进制数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(content.getBytes(), headers, HttpStatus.OK);
    }
    
}

 
 
