package back.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Blocos;
import back.api.service.BlocosService;
import lombok.Getter;

@RestController
@RequestMapping("/api/blocos")
public class BlocosController extends ManterControllerBeanBasic<Blocos> {

	@Getter
	@Autowired
	private BlocosService service;

}
