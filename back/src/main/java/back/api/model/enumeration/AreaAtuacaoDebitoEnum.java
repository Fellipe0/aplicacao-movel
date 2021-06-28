package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum AreaAtuacaoDebitoEnum {

	REGULAR("Regular"), 
	VINCULADO("Vinculado"), 
	ESCOLAR("Escolar"), 
	TURISMO("Turismo"), 
	CLANDESTINO("Clandestino"), 
	NAO_REGULAR("Não Regular"),
	SANEAMENTO("Saneamento"), 
	ENERGIA("Energia"), 
	REGULACAO_ECONOMICO_DESESTATIZACAO("Regulação Econômico e Desestatização");

	private String descricao;

	private AreaAtuacaoDebitoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static AreaAtuacaoDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return AreaAtuacaoDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return AreaAtuacaoDebitoEnum.CLANDESTINO;
	}
}
