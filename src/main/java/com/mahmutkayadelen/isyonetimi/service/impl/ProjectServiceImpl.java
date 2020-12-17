package com.mahmutkayadelen.isyonetimi.service.impl;

import com.mahmutkayadelen.isyonetimi.entity.Project;
import com.mahmutkayadelen.isyonetimi.repository.ProjectRepository;
import com.mahmutkayadelen.isyonetimi.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl  implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) throws IllegalAccessException {
        if(project.getProjectCode() == null)
        {
            throw  new IllegalAccessException("Project code cannot be null!" );
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return true;
    }
}
