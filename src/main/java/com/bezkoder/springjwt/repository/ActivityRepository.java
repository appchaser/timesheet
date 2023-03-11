package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
