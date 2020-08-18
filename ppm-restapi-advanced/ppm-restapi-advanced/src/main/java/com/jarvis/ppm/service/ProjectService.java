package com.jarvis.ppm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.ppm.domain.Project;
import com.jarvis.ppm.exceptions.ProjectIdException;
import com.jarvis.ppm.exceptions.ProjectNotFoundException;
import com.jarvis.ppm.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	// Create or Update Project
	public Project createOrUpdateProject(Project project) {
		String identifier = project.getProjectIdentifier().toUpperCase();
		project.setProjectIdentifier(identifier);
		try {
			return projectRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectIdException("Project ID '" + identifier + "' already exist.");
		}
	}

	// Find Project by ProjectIdentifier
	public Project getProjectByIdentifier(String identifier) {
		Project project = projectRepository.findByProjectIdentifier(identifier.toUpperCase());
		if (project == null) {
			throw new ProjectNotFoundException("Project ID '" + identifier.toUpperCase() + "' doesn't exist.");
		}
		return project;
	}

	// Find All project
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}
}
