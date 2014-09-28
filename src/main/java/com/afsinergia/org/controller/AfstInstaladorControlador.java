package com.afsinergia.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.afsinergia.org.model.AfstInstalador;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.AfstInstaladorService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class AfstInstaladorControlador {
	private static final Logger logger = LoggerFactory.getLogger(AfstInstaladorControlador.class);

	@Autowired
	private AfstInstaladorService service;
	//Metodo que redirecciona a los instaladores o el clint, segn sea el caso
	@RequestMapping(value = URLS.GET_INSTALADORES, method = RequestMethod.GET)
	public String getInstaladores(HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getInstaladores clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_INSTALADORES);
		
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	@RequestMapping(value = URLS.GET_INSTALADORES_BY_ID_CLIENTE, method = RequestMethod.GET)
	public String getInstaladoresByIdCliente(@PathVariable(value = "id") Integer idCliente, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getInstaladoresByIdCliente clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por cliente)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//reetamos los valores de la variable de session y seteamos el objeto
		moduloSolicitado.setModulo("");
		//set del idContrato para que al rescatar los grupos del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idCliente);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//consultamos las flotillas
		List<AfstInstalador> instaladores = service.getAfstInstaladorByIdCliente(idCliente);
		modelo.addAttribute("instaladores", instaladores);
		
		if(instaladores.size() == 0)
			modelo.addAttribute("idCliente_", idCliente);
		
		return "getInstaladores";
	}
	
	//obtiene el instalador en funcion del id de entrada
	@RequestMapping(value = URLS.GET_INSTALADOR_BY_ID, method = RequestMethod.GET)
	public String getInstaladorById(@PathVariable(value = "id") Integer idInstalador, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getInstaladorById/{"+idInstalador+"} clase "+this.getClass().getName());
		
		AfstInstalador instalador = service.getAfstInstaladorById(idInstalador);
		modelo.addAttribute("instalador", instalador);
		return "frmInstalador";
	}
	
	//salva o actualiza un instalador en la bd
	@RequestMapping(value = URLS.SET_INSTALADOR, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setInstalador(HttpServletRequest request, @RequestBody AfstInstalador instalador)
	{
		logger.info("\t\t****************** VHM: metodo setInstalador clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setInstalador instalador idInstalador: "+instalador.getIdInstalador()+", nombre: "+instalador.getNombre());

		//hacemos el set del modulo para que al hacer el load despues de guardar/actualizar se actualice la tabla
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//////////////////////
		service.saveOrUpdateAfstInstalador(instalador);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar un instalador
	@RequestMapping(value = URLS.INSTALADOR)
	public String openModalInstalador(@PathVariable(value = "id") Integer idCliente, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalInstalador/"+idCliente+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idCliente", idCliente);
		return "frmInstalador";
	}
}
