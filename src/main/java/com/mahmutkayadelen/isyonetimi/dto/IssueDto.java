package com.mahmutkayadelen.isyonetimi.dto;

import com.mahmutkayadelen.isyonetimi.entity.IssueStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {
    @ApiModelProperty(value = "Id Of Issue")
    private Long id;
    @ApiModelProperty(value = "description Of Issue")
    private String description;
    @ApiModelProperty(value = "details Of Issue")
    private String details;
    @ApiModelProperty(value = "date Of Issue")
    private Date date;
    private UserDto assignee;
    private IssueStatus issueStatus;
    private ProjectDto project;

}
