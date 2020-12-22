package com.mahmutkayadelen.isyonetimi.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author mahmutkayadelen
 * @create 22.12.2020  23:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date date;
    private String message;
}
