package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SituacaoEnum {

	ATIVO("Ativo"), 
	INATIVO("Inativo");

	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoEnum.ATIVO;
	}
}
