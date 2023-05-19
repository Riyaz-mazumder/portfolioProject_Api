package com.portfolio.portfolio_spring_boot.repos;

import com.portfolio.portfolio_spring_boot.domain.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {
}
