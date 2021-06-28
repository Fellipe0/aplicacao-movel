package back.api.service.implementacao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.api.persistencia.hql.GenericDAO;
import back.api.persistencia.jpa.RegionaisDAO;
import back.api.service.RegionaisService;
import lombok.Getter;

@Getter
@Service
public class RegionaisServiceIMPL implements RegionaisService {

	private static final Log logger = LogFactory.getLog(RegionaisService.class);

	@Override
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private GenericDAO genericDAO;

	@Autowired
	private RegionaisDAO persistencia;

}
