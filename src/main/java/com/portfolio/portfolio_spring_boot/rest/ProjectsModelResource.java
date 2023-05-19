package com.portfolio.portfolio_spring_boot.rest;

import com.portfolio.portfolio_spring_boot.model.ProjectsModelDTO;
import com.portfolio.portfolio_spring_boot.service.ProjectsModelService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/projectsModels", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectsModelResource {

    private final ProjectsModelService projectsModelService;

    public ProjectsModelResource(final ProjectsModelService projectsModelService) {
        this.projectsModelService = projectsModelService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectsModelDTO>> getAllProjectsModels() {
        return ResponseEntity.ok(projectsModelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectsModelDTO> getProjectsModel(@PathVariable final Long id) {
        return ResponseEntity.ok(projectsModelService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createProjectsModel(
            @RequestBody @Valid final ProjectsModelDTO projectsModelDTO) {
        final Long createdId = projectsModelService.create(projectsModelDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProjectsModel(@PathVariable final Long id,
            @RequestBody @Valid final ProjectsModelDTO projectsModelDTO) {
        projectsModelService.update(id, projectsModelDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectsModel(@PathVariable final Long id) {
        projectsModelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
