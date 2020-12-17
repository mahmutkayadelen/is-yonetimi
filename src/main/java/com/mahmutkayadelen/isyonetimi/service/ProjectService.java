package com.mahmutkayadelen.isyonetimi.service;

import com.mahmutkayadelen.isyonetimi.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create by mkayadelen 14.12.2020
 */
public interface ProjectService {
    Project save(Project project) throws IllegalAccessException;

    Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(Project project);


}
