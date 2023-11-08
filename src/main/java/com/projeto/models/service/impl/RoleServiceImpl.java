package com.projeto.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.models.model.Role;
import com.projeto.models.repository.RoleRepository;
import com.projeto.models.service.RoleService;
import com.projeto.models.service.pagination.pageRequestConfig;

@Service
@Transactional

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
			
	
	
	@Override
	public Role save(Role entity) {
		
		return roleRepository.save(entity);
	}

	@Override
	public Role update(Long id, Role entity) {
		Role RoleCadasdrato = read(id);
		
		RoleCadasdrato.setNome(entity.getNome());
		
		return roleRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		roleRepository.deleteById(id);

	}

	@Override
	public Role read(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.getById(id);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public List<Role> list(String key) {
		
		return roleRepository.findByUseNname(key);
	}

	

}
