package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Project;


@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long>  {

}
