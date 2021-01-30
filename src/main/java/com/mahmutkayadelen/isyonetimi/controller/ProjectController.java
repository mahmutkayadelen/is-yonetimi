package com.mahmutkayadelen.isyonetimi.controller;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.service.impl.ProjectServiceImpl;
import com.mahmutkayadelen.isyonetimi.util.ApiPaths;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by mahmutkayadelen on 17 12 2020
 */
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
@CrossOrigin
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getBydId(@PathVariable("id") Long id) {
        log.info("ProjectController -> getBydId  çağrıldı.");
        log.debug("ProjectController -> GetByID -> PARAM" + id);


        ProjectDto projectDto;
        projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<Tpage<ProjectDto>> getAllByPagination(Pageable pageable) {
        log.info("ProjectController -> getAllByPagination  çağrıldı.");
        Tpage<ProjectDto>  data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }
    @PostMapping
    @ApiOperation(value = "Create Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project) {
        ProjectDto p = projectServiceImpl.save(project);
        return ResponseEntity.ok(p);
    }

    @PutMapping
    @ApiOperation(value = "Update Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto project) throws IllegalAccessException {
        ProjectDto p = projectServiceImpl.update(project);
        return ResponseEntity.ok(p);
    }




    /*@RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto project) throws IllegalAccessException {
        ProjectDto p =  projectServiceImpl.update(project);
        return ResponseEntity.ok(p);
    }*/
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Create Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {


        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
