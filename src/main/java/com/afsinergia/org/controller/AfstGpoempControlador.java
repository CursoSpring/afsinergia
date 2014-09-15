package com.afsinergia.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.afsinergia.org.model.AfstGpoemp;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.AfstGpoempService;

@Controller
public class AfstGpoempControlador {

	private static final Logger logger = LoggerFactory.getLogger(AfstClienteControlador.class);

	@Autowired
	private AfstGpoempService service;
	
	//devuelve todos los clientes en funcion del idGrupoEmpleado
	@RequestMapping(value = "/getGruposEmpresa", method = RequestMethod.GET)
	public String getGruposEmpresa(Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getGruposEmpresa clase "+this.getClass().getName());

		//List<AfstCliente> clientes = service.getClientesByIdGpoEmp(1);
		
		//modelo.addAttribute("clientes", clientes);	
		return "getGruposEmpresa";
	}

	
	//salva o actualiza un cliente en la bd
	@RequestMapping(value = "/setGrupoEmpresa", method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setGrupoEmpresa(@RequestBody AfstGpoemp grupoEmpresa)
	{
		logger.info("\t\t****************** VHM: metodo setGrupoEmpresa clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setGrupoEmpresa grupo empresa: "+grupoEmpresa.getNombre()+", "+grupoEmpresa.getAfstEmpresa().getIdEmpresa()+", "+grupoEmpresa.getIdEmpp());
		service.saveOrUpdateGruposEmp(grupoEmpresa);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idGpoemp(si no existe esta hardcode en 0) para dar de alta o actualizar un cliente
	@RequestMapping(value = "/grupoEmpresa/{id}")
	public String openModalGrupoEmpresa(@PathVariable(value = "id") Integer idEmpresa, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalGrupoEmpresa/"+idEmpresa+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idEmpresa", idEmpresa);
		return "frmGrupoEmpresa";
	}
}
