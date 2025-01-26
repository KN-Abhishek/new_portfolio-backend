package com.portfolio_react.portfolio_react.service;

import com.portfolio_react.portfolio_react.model.Project;
import com.portfolio_react.portfolio_react.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }


    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
