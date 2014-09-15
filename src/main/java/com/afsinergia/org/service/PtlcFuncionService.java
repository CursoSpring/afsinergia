package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.PtlcFuncion;

public interface PtlcFuncionService {

	public List<PtlcFuncion> getFuncionByIdModulo(Integer idModulo);
	public PtlcFuncion getFuncionByIdFuncion(Integer idFuncion);
}
