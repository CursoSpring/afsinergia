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
import com.afsinergia.org.model.UnicTipoUnidad;
import com.afsinergia.org.model.UnitUnidad;
import com.afsinergia.org.service.AfstFlotillaService;
import com.afsinergia.org.service.UnicTipoUnidadService;
import com.afsinergia.org.service.UnitUnidadService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class UnitUnidadControlador {
	private static final Logger logger = LoggerFactory.getLogger(UnitUnidadControlador.class);

	@Autowired
	private UnitUnidadService service;

	@Autowired
	private UnicTipoUnidadService servicioTipoUnidad;

	@Autowired
	private AfstFlotillaService servicioFlotilla;

	//Metodo que retorna los grupos de usuario en funcion del contrato
	@RequestMapping(value = URLS.GET_UNIDADES, method = RequestMethod.GET)
	public String getUnidades(HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo Unidades clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_UNIDADES);
		
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	//devuelve todos los Unidades en funcion del idFlotilla
	@RequestMapping(value = URLS.GET_UNIDADES_BY_ID_FLOTILLA, method = RequestMethod.GET)
	public String getUnidadesByIdFlotilla(@PathVariable(value = "id") Integer idFlotilla, HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUnidadesByIdFlotilla/"+idFlotilla+" clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por flotilla)");
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		moduloSolicitado.setModulo("");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		
		List<UnitUnidad> unidades = service.getUnidadesByIdFlotilla(idFlotilla);
		modelo.addAttribute("unidades", unidades);
		
		if(unidades.size() == 0)
			modelo.addAttribute("idFlotilla_", idFlotilla);

		return "getUnidades";
		
	}
	
	@RequestMapping(value = URLS.GET_UNIDADES_BY_ID_CONTRATO, method = RequestMethod.GET)
	public String getUnidadesByIdContrato(@PathVariable(value = "id") Integer idContrato, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getUnidadesByIdContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por contrato)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//reetamos los valores de la variable de session y seteamos el objeto
		moduloSolicitado.setModulo("");
		//set del idContrato para que al rescatar las unidades del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idContrato);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//consultamos las unidades
		List<UnitUnidad> unidades = service.getUnidadesByIdContrato(idContrato);
		modelo.addAttribute("unidades", unidades);
		
		return "getUnidades";
	}
	
	//obtiene el grupo unidad en funcion del id de entrada
	@RequestMapping(value = URLS.GET_UNIDAD_BY_ID, method = RequestMethod.GET)
	public String getUnidadById(HttpServletRequest request, @PathVariable(value = "id") Integer idUnidad, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUnidadById/{"+idUnidad+"} clase "+this.getClass().getName());
		
		UnitUnidad unidad = service.getUnidadById(idUnidad);
		modelo.addAttribute("unidad", unidad);
		
		modelo.addAttribute("generoHombre", URLS.GENERO_HOMBRE);
		modelo.addAttribute("generoMujer", URLS.GENERO_MUJER);
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		System.out.println("ahhhh VHM:::::::::::::::::::::::: idContrato "+moduloSolicitado.getIdEntidadAbuela());

		//Enviamos todas las flotillas en funcion del idContrato
		List<AfstFlotilla> flotillas = servicioFlotilla.getAfstFlotillaByIdContrato(moduloSolicitado.getIdEntidadAbuela());
		modelo.addAttribute("flotillas", flotillas);
		
		return "frmUnidad";
	}
	
	//salva o actualiza un grupo unidad en la bd
	@RequestMapping(value = URLS.SET_UNIDAD, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setUnidad(HttpServletRequest request, @RequestBody UnitUnidad unidad)
	{
		logger.info("\t\t****************** VHM: metodo setUnidad clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setUnidad idUniad: "+unidad.getIdUnidad()+", nombre: "+unidad.getNombre());

		//hacemos el set del modulo para que al hacer el load despues de guardar/actualizar se actualice la tabla
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//////////////////////
		
		service.saveOrUpdateUnidad(unidad);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar una unidad
	@RequestMapping(value = URLS.UNIDAD)
	public String openModalUnidad(HttpServletRequest request, @PathVariable(value = "id") Integer idContrato, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalUnidad/"+idContrato+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idContrato", idContrato);
		
		List<UnicTipoUnidad> tiposDeUnidad = servicioTipoUnidad.getAllUnicTipoUnidades();
		modelo.addAttribute("tiposDeUnidad", tiposDeUnidad);
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		System.out.println("ahhhh VHM:::::::::::::::::::::::: idContrato "+moduloSolicitado.getIdEntidadAbuela());

		//Enviamos todas las flotillas en funcion del idContrato
		List<AfstFlotilla> flotillas = servicioFlotilla.getAfstFlotillaByIdContrato(moduloSolicitado.getIdEntidadAbuela());
		modelo.addAttribute("flotillas", flotillas);
		
		return "frmUnidad";
	}

}
