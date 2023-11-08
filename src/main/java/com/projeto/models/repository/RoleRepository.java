package com.projeto.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.models.model.Role;

public interface RoleRepository extends JpaRepository<Role , Long> {
	
	@Query("SELECT r FROM Role r WHERE r.nome =:key")
	List<Role> findByUseNname(@Param("key") String key);

	
	@Query(value = "SELECT r FROM Role r",
			countQuery = "SELECT count(r) FROM Role r")
	Page<Role> findAllPagination(Pageable pagina);
}

