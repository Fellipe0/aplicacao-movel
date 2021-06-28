package back.api.service.implementacao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.api.model.Embarcados;
import back.api.persistencia.hql.GenericDAO;
import back.api.persistencia.jpa.EmbarcadosDAO;
import back.api.service.EmbarcadosService;
import lombok.Getter;

@Getter
@Service
public class EmbarcadosServiceIMPL implements EmbarcadosService {

	private static final Log logger = LogFactory.getLog(EmbarcadosService.class);

	@Override
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private GenericDAO genericDAO;

	@Autowired
	private EmbarcadosDAO persistencia;

	@Override
	public Embarcados save(Embarcados objeto) throws Exception {
		List<Embarcados> itens = findAll();
		objeto.setId(itens.get(itens.size() - 1).getId() + 1);
		return EmbarcadosService.super.save(objeto);
	}
}
