package com.portfolio.portfolio_spring_boot.repos;

import com.portfolio.portfolio_spring_boot.domain.SkillManage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillManageRepository extends JpaRepository<SkillManage, Long> {
}
