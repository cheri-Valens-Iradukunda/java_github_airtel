package com.valens.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valens.inventory.models.Mdl_assignments;

@Repository
public interface Repo_assignemts extends JpaRepository<Mdl_assignments, Long>{
	
	@Query(value = "SELECT * FROM assignments where status = ?", nativeQuery = true)
	List<Mdl_assignments> assignmentByStatus(String status);

}
