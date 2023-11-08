package com.projeto.models.service;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;

public interface ClienteService extends GenericService <ClienteResponse,ClienteRequest> {

	ClienteResponse save(ClienteRequest entity);

}
