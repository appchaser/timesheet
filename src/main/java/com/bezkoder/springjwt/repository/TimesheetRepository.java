package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.timesheet;

public interface TimesheetRepository extends JpaRepository<timesheet, Long>{

}
