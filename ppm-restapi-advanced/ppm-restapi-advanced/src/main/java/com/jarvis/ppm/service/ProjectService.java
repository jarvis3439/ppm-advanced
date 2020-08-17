package com.jarvis.ppm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.ppm.domain.Project;
import com.jarvis.ppm.exceptions.ProjectIdException;
import com.jarvis.ppm.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	// Create or Update Project
	public Project createOrUpdate(Project project) {
		String identifier = project.getProjectIdentifier().toUpperCase();
		try {
			return projectRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectIdException("Project ID '" + identifier + "' already exist.");
		}
	}
}
