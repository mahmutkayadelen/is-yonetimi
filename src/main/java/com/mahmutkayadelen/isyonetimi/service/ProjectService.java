package com.mahmutkayadelen.isyonetimi.service;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.entity.Project;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create by mkayadelen 14.12.2020
 */
public interface ProjectService {
    ProjectDto save(ProjectDto project) throws IllegalAccessException;

    ProjectDto getById(Long id);

    Tpage<ProjectDto> getAllPageable(Pageable pageable);
    Boolean delete(Project project);
    Boolean delete(Long id);

    ProjectDto update(ProjectDto project) throws IllegalAccessException;




}
