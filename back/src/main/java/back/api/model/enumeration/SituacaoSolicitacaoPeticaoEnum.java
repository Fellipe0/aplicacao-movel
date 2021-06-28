package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author felipe-ll
 *
 */
@Getter
public enum SituacaoSolicitacaoPeticaoEnum {

	EM_ANDAMENTO("Em Andamento"),
	ENVIADO("Enviado"),
	CONCLUIDO("Concluido");

	private String descricao;

	private SituacaoSolicitacaoPeticaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoSolicitacaoPeticaoEnum get(String nome) {
		try {
			if (StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoSolicitacaoPeticaoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {
		}
		return SituacaoSolicitacaoPeticaoEnum.EM_ANDAMENTO;
	}
}
