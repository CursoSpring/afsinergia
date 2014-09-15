package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.PtltPrivilegioDao;
import com.afsinergia.org.model.PtltPrivilegio;
import com.afsinergia.org.service.PtltPrivilegioService;

@Component
public class PtltPrivilegioServiceImpl implements PtltPrivilegioService{

	@Resource(name = "PtltPrivilegio")
	private PtltPrivilegioDao dao;
	
	@Override
	@Transactional
	public List<PtltPrivilegio> getAllPrivilegioByIdGpoUsuario(Integer idGpoUsuario) {
		
		List<PtltPrivilegio> privilegios = dao.getAllPrivilegioByIdGpoUsuario(idGpoUsuario);
		
		/*if(privilegios != null && privilegios.size() > 0)
		{
			for(int i=0; i<privilegios.size(); i++){
				PtlcModulo modulo = privilegios.get(i).getPtlcModulo();
				PtlcFuncion funcion = privilegios.get(i).getPtlcFuncion();
				//session.update(object);
				System.out.println(":::::::VHM_ Service"+", idModulo: "+modulo.getIdModulo()+", idFuncion: "+funcion.getIdFun()+", modulo: "+modulo.getNomMod()+", funcion: "+funcion.getNomFun());
			}
		}*/
		
		return privilegios;
	}

}
