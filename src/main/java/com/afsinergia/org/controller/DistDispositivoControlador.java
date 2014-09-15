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

import com.afsinergia.org.model.DistDispositivo;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.DistDispositivoService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class DistDispositivoControlador {

	private static final Logger logger = LoggerFactory.getLogger(DistDispositivoControlador.class);

	@Autowired
	private DistDispositivoService servicioDipositivo;
	
	//Metodo que retorna los dispositivos en funcion del contrato
	@RequestMapping(value = URLS.GET_DISPOSITIVOS, method = RequestMethod.GET)
	public String getDispositivos(HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getDispositivos clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_DISPOSITIVOS);
		
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	@RequestMapping(value = URLS.GET_DISPOSITIVOS_BY_ID_CONTRATO, method = RequestMethod.GET)
	public String getDispositivosByIdContrato(@PathVariable(value = "id") Integer idContrato, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getDispositivosByIdContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por contrato)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//reetamos los valores de la variable de session y seteamos el objeto
		moduloSolicitado.setModulo("");
		//set del idContrato para que al rescatar los grupos del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idContrato);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//consultamos los gruposUsuarios
		List<DistDispositivo> dispositivos = servicioDipositivo.getDistDispositivosByIdContrato(idContrato);
		modelo.addAttribute("dispositivos", dispositivos);
		
		return "getDispositivos";
	}

	
	//obtiene el dipositivo en funcion del id de entrada
	@RequestMapping(value = URLS.GET_DISPOSITIVO_BY_ID, method = RequestMethod.GET)
	public String getDispositivoById(@PathVariable(value = "id") Integer idDistDispositivo, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getDispositivoById/{"+idDistDispositivo+"} clase "+this.getClass().getName());
		
		DistDispositivo dispositivo = servicioDipositivo.getDistDispositivoById(idDistDispositivo);
		modelo.addAttribute("dispositivo", dispositivo);
		return "frmDispositivo";
	}
	
	//salva o actualiza un dispositivo en la bd
	@RequestMapping(value = URLS.SET_DISPOSITIVO, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setDispositivo(HttpServletRequest request, @RequestBody DistDispositivo dispositivo)
	{
		System.out.println("-------------------------------------------Entroooooooooo-----------------------------------------------");
		logger.info("\t\t****************** VHM: metodo setDispositivo clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setDispositivo dispositivo idDispositivo: "+dispositivo.getIdDispositivo()+", imei: "+dispositivo.getImei());

		//hacemos el set del modulo para que al hacer el load despues de guardar/actualizar se actualice la tabla
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//////////////////////
		servicioDipositivo.saveOrUpdateDistDispositivo(dispositivo);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar un dispositivo
	@RequestMapping(value = URLS.DISPOSITIVO)
	public String openModalDispositivo(@PathVariable(value = "id") Integer idContrato, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalDispositivo/"+idContrato+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idContrato", idContrato);
		return "frmDispositivo";
	}	
	
}
