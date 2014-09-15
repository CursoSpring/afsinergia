package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.AfstCliente;

public interface AfstClienteDao {

	public List<AfstCliente> getClientesByIdGpoEmp(Integer idGrupoEmp);
	public AfstCliente getClienteById(Integer idCliente);
	public void saveOrUpdateCliente(AfstCliente cliente);
}
