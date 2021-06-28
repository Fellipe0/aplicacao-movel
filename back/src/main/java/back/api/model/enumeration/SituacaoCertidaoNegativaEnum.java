package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author felipe-ll
 *
 */
@Getter
public enum SituacaoCertidaoNegativaEnum {

	VALIDADA("Validada"), INVALIDA("Invalida"), VENCIDA("Vencida"), EM_ANALISE("Em Análise");

	private String descricao;

	private SituacaoCertidaoNegativaEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoCertidaoNegativaEnum get(String nome) {
		try {
			if (StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoCertidaoNegativaEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {
		}
		return SituacaoCertidaoNegativaEnum.VALIDADA;
	}

}
