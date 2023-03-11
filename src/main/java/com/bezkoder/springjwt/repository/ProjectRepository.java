package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Project;



public interface ProjectRepository  extends JpaRepository<Project, Long>  {

}
