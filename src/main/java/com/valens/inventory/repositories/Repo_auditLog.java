package com.valens.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valens.inventory.models.Mdl_auditLog;

@Repository
public interface Repo_auditLog extends JpaRepository<Mdl_auditLog, Long> {

}
