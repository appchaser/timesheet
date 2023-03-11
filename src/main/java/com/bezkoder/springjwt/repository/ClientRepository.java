package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
