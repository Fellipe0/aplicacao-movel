package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SituacaoTramiteEnum {

	ENCAMINHADO("Encaminhado"), 
	RETORNADO("Retornado");

	private String descricao;

	private SituacaoTramiteEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoTramiteEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoTramiteEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoTramiteEnum.ENCAMINHADO;
	}

	public static SituacaoTramiteEnum get(Boolean statusNotificacao) {
		return statusNotificacao == null || !statusNotificacao ? RETORNADO : ENCAMINHADO;
	}
}
