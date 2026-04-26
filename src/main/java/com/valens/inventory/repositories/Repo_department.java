package com.valens.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valens.inventory.models.Mdl_department;

@Repository
public interface Repo_department extends JpaRepository<Mdl_department, Long> {

}
