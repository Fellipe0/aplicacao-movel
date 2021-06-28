package back.api.service.implementacao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.api.persistencia.hql.GenericDAO;
import back.api.persistencia.jpa.UnidadesDAO;
import back.api.service.UnidadesService;
import lombok.Getter;

@Getter
@Service
public class UnidadesServiceIMPL implements UnidadesService {

	private static final Log logger = LogFactory.getLog(UnidadesService.class);

	@Override
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private GenericDAO genericDAO;

	@Autowired
	private UnidadesDAO persistencia;

}
