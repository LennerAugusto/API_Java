package com.projeto.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.models.model.Cliente;
import com.projeto.models.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT u FROM Produto u WHERE u.nomeProduto =:key")
	List<Produto> findBynomeProduto(@Param("key") String key);
	
	@Query("SELECT u FROM Produto u WHERE u.preco =: preco")
	Optional<Produto> findUsuarioByPreco(@Param("preco") Float preco);

	@Query(value = "SELECT u FROM Produto u",
			countQuery = "SELECT count(u) FROM Produto u")

	Object finddClienteByNomeProduto(String nomeProduto);

}
