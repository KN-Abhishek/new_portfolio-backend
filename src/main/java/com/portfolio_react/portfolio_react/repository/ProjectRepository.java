package com.portfolio_react.portfolio_react.repository;

import com.portfolio_react.portfolio_react.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
