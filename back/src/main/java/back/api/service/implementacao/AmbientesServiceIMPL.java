package back.api.service.implementacao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.api.model.Ambientes;
import back.api.persistencia.hql.GenericDAO;
import back.api.persistencia.jpa.AmbientesDAO;
import back.api.service.AmbientesService;
import lombok.Getter;

@Getter
@Service
public class AmbientesServiceIMPL implements AmbientesService {

	private static final Log logger = LogFactory.getLog(AmbientesService.class);

	@Override
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private GenericDAO genericDAO;

	@Autowired
	private AmbientesDAO persistencia;

	@Override
	public Ambientes save(Ambientes objeto) throws Exception {
		List<Ambientes> itens = findAll();
		objeto.setId(itens.get(itens.size() - 1).getId() + 1);
		return AmbientesService.super.save(objeto);
	}
}
