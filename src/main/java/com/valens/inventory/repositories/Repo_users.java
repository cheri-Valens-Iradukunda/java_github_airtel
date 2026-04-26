package com.valens.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valens.inventory.models.Mdl_users;

@Repository
public interface Repo_users extends JpaRepository<Mdl_users, Long> {

	@Query(value = "select distinct * from users where username = ?1 and password = ?2", nativeQuery=true)
	Mdl_users getUserByUsernameAndPassword(String username,String password);
	
}
