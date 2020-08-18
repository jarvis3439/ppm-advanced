package com.jarvis.ppm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.ppm.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectIdentifier(String identifier);
}
