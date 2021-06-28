package back.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Embarcados;
import back.api.service.EmbarcadosService;
import lombok.Getter;

@RestController
@RequestMapping("/api/embarcados")
public class EmbarcadosController extends ManterControllerBeanBasic<Embarcados> {

	@Getter
	@Autowired
	private EmbarcadosService service;

}
