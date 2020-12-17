package com.mahmutkayadelen.isyonetimi.dto;

import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private UserDto assignee;
    private ProjectDto project;

}
