package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.AfstCliente;

public interface AfstClienteService {

	public List<AfstCliente> getClientesByIdGpoEmp(Integer idGrupoEmp);
	public AfstCliente getClienteById(Integer idCliente);
	public void saveOrUpdateCliente(AfstCliente cliente);
}
