package com.portfolio.portfolio_spring_boot.repos;

import com.portfolio.portfolio_spring_boot.domain.ProjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectsModelRepository extends JpaRepository<ProjectsModel, Long> {
}
