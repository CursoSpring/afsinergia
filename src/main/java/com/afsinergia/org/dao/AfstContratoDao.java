package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.AfstContrato;

public interface AfstContratoDao {
	
	public List<AfstContrato> getContratosByIdCliente(Integer idCliente);
	public AfstContrato getContratoByIdContrato(Integer idContrato);
	public void saveOrUpdateContrato(AfstContrato contrato);
}
