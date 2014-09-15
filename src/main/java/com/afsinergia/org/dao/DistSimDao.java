package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.DistSim;

public interface DistSimDao {

	public List<DistSim> getSimByIdContrato(Integer idContrato);
	public List<DistSim> getSimByIdDispositivo(Integer idDispositivo);
	public DistSim getSimById(Integer idSim);
	public void saveOrUpdateSim(DistSim sim);
}
