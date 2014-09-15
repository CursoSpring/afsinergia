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

import com.afsinergia.org.model.AfstFlotilla;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.AfstFlotillaService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class AfstFlotillaController {
	private static final Logger logger = LoggerFactory.getLogger(AfstFlotillaController.class);

	@Autowired
	private AfstFlotillaService service;
	
	//Metodo que retorna las flotillas en funcion del contrato
	@RequestMapping(value = URLS.GET_FLOTILLAS, method = RequestMethod.GET)
	public String getFlotillas(HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getFlotillas clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_FLOTILLAS);
		
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	@RequestMapping(value = URLS.GET_FLOTILLAS_BY_ID_CONTRATO, method = RequestMethod.GET)
	public String getFlotillasByIdContrato(@PathVariable(value = "id") Integer idContrato, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getFlotillasByIdContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por contrato)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//reetamos los valores de la variable de session y seteamos el objeto
		moduloSolicitado.setModulo("");
		//set del idContrato para que al rescatar los grupos del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idContrato);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//consultamos las flotillas
		List<AfstFlotilla> flotillas = service.getAfstFlotillaByIdContrato(idContrato);
		modelo.addAttribute("flotillas", flotillas);
		
		if(flotillas.size() == 0)
			modelo.addAttribute("idContrato_", idContrato);
		
		return "getFlotillas";
	}
	
	//obtiene la flotilla en funcion del id de entrada
	@RequestMapping(value = URLS.GET_FLOTILLA_BY_ID, method = RequestMethod.GET)
	public String getFlotillaByid(@PathVariable(value = "id") Integer idFlotilla, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getFlotillaByid/{"+idFlotilla+"} clase "+this.getClass().getName());
		
		AfstFlotilla flotilla = service.getAfstFlotillaById(idFlotilla);
		modelo.addAttribute("flotilla", flotilla);
		return "frmFlotilla";
	}
	
	//salva o actualiza una flotilla en la bd
	@RequestMapping(value = URLS.SET_FLOTILLA, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setFlotilla(HttpServletRequest request, @RequestBody AfstFlotilla flotilla)
	{
		logger.info("\t\t****************** VHM: metodo setFlotilla clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setFlotilla flotilla idFlotilla: "+flotilla.getIdFlotilla()+", nombre: "+flotilla.getNombre());

		//hacemos el set del modulo para que al hacer el load despues de guardar/actualizar se actualice la tabla
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//////////////////////
		service.saveOrUpdateAfstFlotilla(flotilla);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar una flotilla
	@RequestMapping(value = URLS.FLOTILLA)
	public String openModalFlotilla(@PathVariable(value = "id") Integer idContrato, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalFlotilla/"+idContrato+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idContrato", idContrato);
		return "frmFlotilla";
	}	
}
