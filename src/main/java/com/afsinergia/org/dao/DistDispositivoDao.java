package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.DistDispositivo;

public interface DistDispositivoDao {
	
	public void saveOrUpdateDistDispositivo(DistDispositivo dispositivo);

	public void delete(Integer id);

	public DistDispositivo getDistDispositivo(Integer id);
	
	public List<DistDispositivo> getDistDispositivosByIdContrato(Integer idContrato);
	
	public DistDispositivo getDistDispositivoById(Integer idDistDispositivo);
}
