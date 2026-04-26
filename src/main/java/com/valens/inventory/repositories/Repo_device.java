package com.valens.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.valens.inventory.models.Mdl_device;

@Repository
public interface Repo_device extends JpaRepository<Mdl_device, Long> {

	@Query(value = "select * from devices where status = ?", nativeQuery=true)
	List<Mdl_device> deviceByStatus(String status);
	
	
	@Query(value = "select count(*) from devices where status = ?", nativeQuery=true)
	int countDeviceByStatus(String status);
	
}
