package com.projeto.models.service;

import java.util.List;

import com.projeto.models.data.ClienteRequest;

public interface GenericService<T,ID> {

	T save(T entity);
	T update(Long id, ClienteRequest cliente);
	void delete(ID id);
	T read(Long id);
	List<T> list();
	List<T> list(String key);
	
}
