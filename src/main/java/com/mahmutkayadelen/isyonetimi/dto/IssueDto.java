package com.mahmutkayadelen.isyonetimi.dto;

import com.mahmutkayadelen.isyonetimi.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private UserDto assignee;
    private IssueStatus issueStatus;
    private ProjectDto project;

}
