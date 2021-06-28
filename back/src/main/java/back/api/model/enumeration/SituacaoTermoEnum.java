package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SituacaoTermoEnum {

	EXTINTO("Extinto"),
	QUITADO("Quitado"),
	PENDENTE_PAGAMENTO("Pendente de pagamento");

	private String descricao;

	private SituacaoTermoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoTermoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoTermoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoTermoEnum.PENDENTE_PAGAMENTO;
	}
	
	public static Boolean isAtiva(SituacaoTermoEnum situacao) {
		return situacao != null && (situacao.equals(PENDENTE_PAGAMENTO));
	}

	public static Boolean isNotAtiva(SituacaoTermoEnum situacao) {
		return !isAtiva(situacao);
	}
}
