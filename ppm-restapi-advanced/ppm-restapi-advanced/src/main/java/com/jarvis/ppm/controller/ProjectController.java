package com.jarvis.ppm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.ppm.domain.Project;
import com.jarvis.ppm.service.ErrorService;
import com.jarvis.ppm.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ErrorService errorService;

	// create project request
	@PostMapping("")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<?> error = errorService.errorValidation(result);
		if (error != null) {
			return error;
		}
		projectService.createOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}

	// get project by identifier
	@GetMapping("/{identifier}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String identifier) {
		Project project = projectService.getProjectByIdentifier(identifier);
		return new ResponseEntity<Project>(project, HttpStatus.FOUND);
	}

	// Get all projects
	@GetMapping("/all")
	public List<Project> getAllProjects() {
		return projectService.findAllProjects();
	}
}
