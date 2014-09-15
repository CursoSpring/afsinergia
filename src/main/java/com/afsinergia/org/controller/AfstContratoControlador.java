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

import com.afsinergia.org.model.AfstContrato;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.AfstContratoService;
import com.afsinergia.org.utils.URLS;

@Controller
public class AfstContratoControlador {
	private static final Logger logger = LoggerFactory.getLogger(AfstContratoControlador.class);

	@Autowired
	private AfstContratoService service;
	
	//redireccion a la consulta de clientes
	@RequestMapping(value = URLS.GET_CONTRATOS, method = RequestMethod.GET)
	public String getContratos(HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getContratos clase "+this.getClass().getName());

		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	//devuelve todos los contratos en funcion de un cliente dado por el idCliente
	@RequestMapping(value = URLS.GET_CONTRATOS_BY_ID_CLIENTE, method = RequestMethod.GET)
	public String getContratosByIdCliente(@PathVariable(value = "id") Integer idCliente, HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getContratosByIdCliente/"+idCliente+" clase "+this.getClass().getName());

		List<AfstContrato> contratos = service.getContratosByIdCliente(idCliente);
		modelo.addAttribute("contratos", contratos);

		//Solo mando el parametro si se consulto consultando un cliente que no tiene contratos
		if(contratos.size() == 0)
			modelo.addAttribute("idCliente_", idCliente);
		
		return "getContratos";
	}
	
	//obtiene el conrato en funcion del id de entrada
	@RequestMapping(value = URLS.GET_CONTRATO_BY_ID, method = RequestMethod.GET)
	public String getContratoByid(@PathVariable(value = "id") Integer idContrato, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getContratoByid/{"+idContrato+"} clase "+this.getClass().getName());
		
		AfstContrato contrato = service.getContratoByIdContrato(idContrato);
		modelo.addAttribute("contrato", contrato);
		return "frmContrato";
	}
	
	//salva o actualiza un contrato en la bd
	@RequestMapping(value = URLS.SET_CONTRATO, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setContrato(@RequestBody AfstContrato contrato)
	{
		logger.info("\t\t****************** VHM: metodo setContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setContrato contrato: "+contrato.getIdContrato()+", "+contrato.getNoContrato()+", "+contrato.getNomContrato()+", "+contrato.getInicioContrato()+", "+contrato.getPlazo()+", "+contrato.getNoUnidades()+", "+contrato.getAfstCliente().getIdCliente());
		service.saveOrUpdateContrato(contrato);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar un contrato
	@RequestMapping(value = URLS.CONTRATO)
	public String openModalContrato(@PathVariable(value = "id") Integer idCliente, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalContrato/"+idCliente+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idCliente", idCliente);
		return "frmContrato";
	}
}
