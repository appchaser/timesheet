package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

}
