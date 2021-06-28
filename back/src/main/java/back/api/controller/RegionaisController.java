package back.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Regionais;
import back.api.service.RegionaisService;
import lombok.Getter;

@RestController
@RequestMapping("/api/regionais")
public class RegionaisController extends ManterControllerBeanBasic<Regionais> {

	@Getter
	@Autowired
	private RegionaisService service;

}
