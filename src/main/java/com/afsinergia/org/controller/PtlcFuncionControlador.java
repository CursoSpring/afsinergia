package com.afsinergia.org.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.afsinergia.org.model.PtlcFuncion;
import com.afsinergia.org.service.PtlcFuncionService;

@Controller
public class PtlcFuncionControlador {
	private static final Logger logger = LoggerFactory.getLogger(PtlcFuncionControlador.class);

	@Autowired
	private PtlcFuncionService service;

	/*//prueba
	@RequestMapping(value = "/rest/getFunciones_", method = RequestMethod.GET)
	public @ResponseBody List<PtlcFuncion> getFunciones() {
		logger.info(":::: VHM_ getFunciones()");
		
		List<PtlcFuncion> functions = service.getFuncionByIdModulo(1);
		
		for(int i=0; i<functions.size(); i++)
			System.out.println("funcioes: "+functions.get(i).getNomFun()+", "+functions.get(i).getTipo()+", "+functions.get(i).getIdFun());
		
		return null;
	}
	

	@RequestMapping(value = "/rest/getFun/{id}", method = RequestMethod.GET)
	public @ResponseBody PtlcFuncion getFun(@PathVariable(value = "id") Integer idFuncion) {
		logger.info("getFun()");
		
		PtlcFuncion u = new PtlcFuncion();
		u = service.getFuncionByIdFuncion(idFuncion);

		System.out.println(":::::::: VHM_ "+u.getNomFun());
		
		return u;
	}*/
}
