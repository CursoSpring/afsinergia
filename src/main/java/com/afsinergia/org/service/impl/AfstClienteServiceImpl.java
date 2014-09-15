package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.AfstClienteDao;
import com.afsinergia.org.model.AfstCliente;
import com.afsinergia.org.service.AfstClienteService;

@Component
public class AfstClienteServiceImpl implements AfstClienteService{
	
	@Resource(name = "AfstClienteDao")
	private AfstClienteDao dao;

	@Override
	@Transactional
	public List<AfstCliente> getClientesByIdGpoEmp(Integer idGrupoEmp) {
		return dao.getClientesByIdGpoEmp(idGrupoEmp);
	}

	@Override
	@Transactional
	public AfstCliente getClienteById(Integer idCliente) {
		return dao.getClienteById(idCliente);
	}

	@Override
	@Transactional
	public void saveOrUpdateCliente(AfstCliente cliente) {
		dao.saveOrUpdateCliente(cliente);
	}
	

}
