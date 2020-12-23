package com.mahmutkayadelen.isyonetimi.controller;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.service.impl.ProjectServiceImpl;
import com.mahmutkayadelen.isyonetimi.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author mahmutkayadelen
 * @create 23.12.2020  23:38
 */

@RestController
@RequestMapping("/versioning")
@Api(value = ApiPaths.ProjectCtrl.CTRL , description = "Project APIs")
public class ProjedVersionedApi {
    //Bir yöntem bu diğer yöntem ise api başlığından gitmek.
    @Autowired
    private ProjectServiceImpl projectService;
    @GetMapping(value = "/{id}",params = "version=1")
    @ApiOperation(value = "Get By Id Operation V1",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getBydIdV1(@PathVariable("id") Long id) {
        ProjectDto projectDto;
        projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @GetMapping(value = "/{id}",params = "version=2")
    @ApiOperation(value = "Get By Id Operation V2",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getBydIdV2(@PathVariable("id") Long id) {
        ProjectDto projectDto;
        projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);
    }



}
