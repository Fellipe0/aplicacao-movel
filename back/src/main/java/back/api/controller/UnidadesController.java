package back.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Unidades;
import back.api.service.UnidadesService;
import lombok.Getter;

@RestController
@RequestMapping("/api/peticaoareapge")
public class UnidadesController extends ManterControllerBeanBasic<Unidades> {

	@Getter
	@Autowired
	private UnidadesService service;

}
