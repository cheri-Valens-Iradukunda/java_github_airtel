package com.valens.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valens.inventory.models.Mdl_employees;

@Repository
public interface Repo_employees extends JpaRepository<Mdl_employees, Long> {

}
