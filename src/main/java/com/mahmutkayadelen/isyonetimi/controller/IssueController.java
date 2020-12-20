package com.mahmutkayadelen.isyonetimi.controller;


import com.mahmutkayadelen.isyonetimi.dto.IssueDto;
import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.service.impl.IssueServiceImpl;
import com.mahmutkayadelen.isyonetimi.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *Created by mahmutkayadelen on 20.12.2020
 **/
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL , description = "Issue APIs")
public class IssueController {
    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getBydId(@PathVariable("id") Long id) {
        IssueDto issueDto;
        issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @ApiOperation(value = "Insert Issue Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@RequestBody IssueDto issue) {
        IssueDto p = issueServiceImpl.save(issue);
        return ResponseEntity.ok(p);
    }

    @PutMapping
    @ApiOperation(value = "Update Issue Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@RequestBody IssueDto issue) {
        IssueDto p = issueServiceImpl.update(issue);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Issue Operation",response = IssueDto.class)
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}
