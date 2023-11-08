package com.projeto.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.models.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT u FROM Cliente u WHERE u.username =:key")
	List<Cliente> findByUseNname(@Param("key") String key);
	
	@Query("SELECT u FROM Cliente u WHERE u.email =: email")
	Optional<Cliente> findUsuarioByEmail(@Param("email") String email);

	@Query(value = "SELECT u FROM Cliente u",
			countQuery = "SELECT count(u) FROM Cliente u")
	Page<Cliente> findAllPagination(Pageable pagina);
	
	@Query(value = "SELECT u FRoM Usuario u"
			+ "WHERE u.id LIKE(CONCAT('%', :key, '%'))"
			+ "OR u.username LIKE(CONCAT('%', :key, '%'))"
			+ "OR u.email LIKE(CONCAT('%', :key, '%'))",
			countQuery = "SELECT count(u) FROM Cliente u")
	Page<Cliente> findAllPaginationWithKey(@Param("key") String key, Pageable pagina);

	Object finddClienteByEmail(String email);
	
}
