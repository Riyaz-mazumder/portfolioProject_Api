package com.portfolio.portfolio_spring_boot.controller;

import com.portfolio.portfolio_spring_boot.model.ProjectsModelDTO;
import com.portfolio.portfolio_spring_boot.service.ProjectsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProjectsController {


    @Autowired
    private ProjectsModelService projectsModelService;
    @GetMapping("projects")
    public List<ProjectsModelDTO> getAllProjects(){
        return projectsModelService.findAll();
    }

    @PostMapping("projects")
    public void addProjects(@RequestBody ProjectsModelDTO projectsModelDTO){
         projectsModelService.create(projectsModelDTO);
    }

    @PutMapping("projects/{id}")
    public ResponseEntity<Void> updateProjects(@PathVariable Long id, @RequestBody ProjectsModelDTO projectsModelDTO) {
        projectsModelService.update(id, projectsModelDTO);
        return ResponseEntity.noContent().build();
    }


}
