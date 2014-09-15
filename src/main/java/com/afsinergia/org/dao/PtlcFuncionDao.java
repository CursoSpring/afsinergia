package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.PtlcFuncion;

public interface PtlcFuncionDao {

	public List<PtlcFuncion> getFuncionByIdModulo(Integer idModulo);
	public PtlcFuncion getFuncionByIdFuncion(Integer idFuncion);
	
}
