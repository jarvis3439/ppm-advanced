package com.jarvis.ppm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.ppm.domain.Project;
import com.jarvis.ppm.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	// create project request
	@PostMapping("")
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		projectService.createOrUpdate(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
}
