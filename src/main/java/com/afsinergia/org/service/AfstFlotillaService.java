package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.AfstFlotilla;

public interface AfstFlotillaService {
	
	public void saveOrUpdateAfstFlotilla(AfstFlotilla flotilla);

	public void delete(Integer id);
	
	public List<AfstFlotilla> getAfstFlotillaByIdContrato(Integer idContrato);
	
	public AfstFlotilla getAfstFlotillaById(Integer idFlotilla);
}
