package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.UnitUnidad;

public interface UnitUnidadDao {

	public List<UnitUnidad> getUnidadesByIdContrato(Integer idContrato);
	public List<UnitUnidad>  getUnidadesByIdFlotilla(Integer idFlotilla);
	public UnitUnidad getUnidadById(Integer idUnidad);
	public void saveOrUpdateUnidad(UnitUnidad unidad);
}
