package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum TipoDebitoEnum {

	AIT("AIT"), 
	TRCF("TRCF"), 
	OUTORGA("Outorga"), 
	AIS("AIS"), 
	AIE("AIE"),
	CONCESSOES("Concessões");

	private String descricao;

	private TipoDebitoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static TipoDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return TipoDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return TipoDebitoEnum.AIT;
	}
}
