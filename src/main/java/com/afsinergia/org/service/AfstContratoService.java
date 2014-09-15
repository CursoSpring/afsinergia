package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.AfstContrato;

public interface AfstContratoService {
	
	public List<AfstContrato> getContratosByIdCliente(Integer idCliente);
	public AfstContrato getContratoByIdContrato(Integer idContrato);
	public void saveOrUpdateContrato(AfstContrato contrato);
}
