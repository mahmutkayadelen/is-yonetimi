package com.mahmutkayadelen.isyonetimi.service.impl;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.entity.Project;
import com.mahmutkayadelen.isyonetimi.repository.ProjectRepository;
import com.mahmutkayadelen.isyonetimi.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl  implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) throws IllegalAccessException {
        if(project.getProjectCode() == null)
        {
            throw  new IllegalAccessException("Project code cannot be null!" );
        }
        Project p = modelMapper.map(project,Project.class);
                p = projectRepository.save(p);
        project.setId(p.getId());
        return  project;
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p= projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
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
