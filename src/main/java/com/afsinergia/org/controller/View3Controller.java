package com.afsinergia.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View3Controller {

	@RequestMapping(value = "/view3")
	public String loadView3() {
		System.out.println("_VHM ENTROOOOOOO loadView3(). ajajaja");
		return "View3";
	}
}
