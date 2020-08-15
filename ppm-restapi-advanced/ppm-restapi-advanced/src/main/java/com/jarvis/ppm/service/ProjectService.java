package com.jarvis.ppm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.ppm.domain.Project;
import com.jarvis.ppm.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	// Create or Update Project
	public Project createOrUpdate(Project project) {
		return projectRepository.save(project);
	}
}
