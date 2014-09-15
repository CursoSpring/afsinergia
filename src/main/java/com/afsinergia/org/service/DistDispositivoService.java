package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.DistDispositivo;

public interface DistDispositivoService {
	
	public void saveOrUpdateDistDispositivo(DistDispositivo dispositivo);

	public void delete(Integer id);

	public DistDispositivo getDistDispositivo(Integer id);
	
	public List<DistDispositivo> getDistDispositivosByIdContrato(Integer idContrato);
	
	public DistDispositivo getDistDispositivoById(Integer idDistDispositivo);
}
