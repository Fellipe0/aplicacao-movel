package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SituacaoAbatimentoDebitoEnum {

	ABATIDO("Abatido"), 
	QUITADO("Quitado");

	private String descricao;

	private SituacaoAbatimentoDebitoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoAbatimentoDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoAbatimentoDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoAbatimentoDebitoEnum.ABATIDO;
	}
}
