package com.portfolio.portfolio_spring_boot.service;

import com.portfolio.portfolio_spring_boot.domain.ProjectsModel;
import com.portfolio.portfolio_spring_boot.model.ProjectsModelDTO;
import com.portfolio.portfolio_spring_boot.repos.ProjectsModelRepository;
import com.portfolio.portfolio_spring_boot.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProjectsModelService {

    private final ProjectsModelRepository projectsModelRepository;

    public ProjectsModelService(final ProjectsModelRepository projectsModelRepository) {
        this.projectsModelRepository = projectsModelRepository;
    }

    public List<ProjectsModelDTO> findAll() {
        final List<ProjectsModel> projectsModels = projectsModelRepository.findAll(Sort.by("id"));
        return projectsModels.stream()
                .map((projectsModel) -> mapToDTO(projectsModel, new ProjectsModelDTO()))
                .toList();
    }

    public ProjectsModelDTO get(final Long id) {
        return projectsModelRepository.findById(id)
                .map(projectsModel -> mapToDTO(projectsModel, new ProjectsModelDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ProjectsModelDTO projectsModelDTO) {
        final ProjectsModel projectsModel = new ProjectsModel();
        mapToEntity(projectsModelDTO, projectsModel);
        return projectsModelRepository.save(projectsModel).getId();
    }

    public void update(final Long id, final ProjectsModelDTO projectsModelDTO) {
        final ProjectsModel projectsModel = projectsModelRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(projectsModelDTO, projectsModel);
        projectsModelRepository.save(projectsModel);
    }

    public void delete(final Long id) {
        projectsModelRepository.deleteById(id);
    }

    private ProjectsModelDTO mapToDTO(final ProjectsModel projectsModel,
            final ProjectsModelDTO projectsModelDTO) {
        projectsModelDTO.setId(projectsModel.getId());
        projectsModelDTO.setProjectName(projectsModel.getProjectName());
        projectsModelDTO.setProjectDescription(projectsModel.getProjectDescription());
        projectsModelDTO.setProjectLiveUrl(projectsModel.getProjectLiveUrl());
        projectsModelDTO.setProjectGithubLink(projectsModel.getProjectGithubLink());
        projectsModelDTO.setProjectImage(projectsModel.getProjectImage());
        return projectsModelDTO;
    }

    private ProjectsModel mapToEntity(final ProjectsModelDTO projectsModelDTO,
            final ProjectsModel projectsModel) {
        projectsModel.setProjectName(projectsModelDTO.getProjectName());
        projectsModel.setProjectDescription(projectsModelDTO.getProjectDescription());
        projectsModel.setProjectLiveUrl(projectsModelDTO.getProjectLiveUrl());
        projectsModel.setProjectGithubLink(projectsModelDTO.getProjectGithubLink());
        projectsModel.setProjectImage(projectsModelDTO.getProjectImage());
        return projectsModel;
    }

}
