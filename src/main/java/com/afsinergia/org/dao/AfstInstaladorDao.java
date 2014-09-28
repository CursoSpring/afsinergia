package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.AfstInstalador;

public interface AfstInstaladorDao {
	
	public void saveOrUpdateAfstInstalador(AfstInstalador instalador);
	public void delete(Integer idInstalador);
	public List<AfstInstalador> getAfstInstaladorByIdCliente(Integer idCliente);
	public AfstInstalador getAfstInstaladorById(Integer idInstalador);
}
