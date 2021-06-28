package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author felipe-ll
 *
 */
@Getter
public enum SituacaoValorBloqueadoEnum {

	NAO_ABATIDO("Não Abatido"),
	ABATIDO("Abatido"), 
	ABATIDO_E_DEVOLVIDO("Abatido e Devolvido");

	private String descricao;

	private SituacaoValorBloqueadoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoValorBloqueadoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoValorBloqueadoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoValorBloqueadoEnum.NAO_ABATIDO;
	}
}
