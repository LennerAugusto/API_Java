package com.projeto.models.service;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;
import com.projeto.models.data.ProdutoRequest;
import com.projeto.models.data.ProdutoResponse;
import com.projeto.models.service.GenericService;

public interface ProdutoService extends GenericService <ProdutoResponse,ProdutoRequest> {

	ProdutoResponse save(ProdutoRequest entity);

}
