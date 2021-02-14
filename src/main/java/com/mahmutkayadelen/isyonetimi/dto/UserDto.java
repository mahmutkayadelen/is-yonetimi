package com.mahmutkayadelen.isyonetimi.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDto {
    @ApiModelProperty(required = true,value = "ID")
    private Long id;
    @ApiModelProperty(required = true,value = "Name Surname")
    private String nameSurname;
    @ApiModelProperty(required = true,value = "E-Mail")
    private String email;
}
