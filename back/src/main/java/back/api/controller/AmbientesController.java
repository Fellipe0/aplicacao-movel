package back.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Ambientes;
import back.api.service.AmbientesService;
import lombok.Getter;

@RestController
@RequestMapping("/api/ambientes")
public class AmbientesController extends ManterControllerBeanBasic<Ambientes> {

	@Getter
	@Autowired
	private AmbientesService service;

}
