package com.mahmutkayadelen.isyonetimi.service.impl;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.entity.Project;
import com.mahmutkayadelen.isyonetimi.repository.ProjectRepository;
import com.mahmutkayadelen.isyonetimi.service.ProjectService;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project)  {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null!");
        }
        Project projeckCheck = projectRepository.getAllByProjectCode(project.getProjectCode());
        if (projeckCheck != null) {
            throw new IllegalArgumentException("project code başka bir projede kullanılmaktadır.");
        }
        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public Tpage<ProjectDto> getAllPageable(Pageable pageable) {
       Page<Project>  data = projectRepository.findAll(pageable);
       Tpage<ProjectDto> response = new Tpage<>();
       response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
       return response;
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return  true;
    }

    @Override
    public ProjectDto update(ProjectDto project) throws IllegalAccessException {
        Project projectDb = projectRepository.getOne(project.getId());
        if (projectDb == null) {
            throw new IllegalAccessException("Project bulunamadı.");
        }
        Project projeckCheck = projectRepository.getAllByProjectCode(project.getProjectCode());
        System.out.println(projeckCheck.toString());
        if (projeckCheck != null && projeckCheck.getId() != project.getId()) {
            throw new IllegalAccessException("project code başka bir projecin koduna eşittir.");
        }
        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }
}
