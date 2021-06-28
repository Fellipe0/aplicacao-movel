package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author felipe-ll
 *
 */
@Getter
public enum SituacaoExecucaoFiscalEnum {
	AJUIZADO("Ajuizado"),
	NAO_AJUIZADO("Não Ajuizado"),
	SUSPENSAO_JUDICIAL("Suspenção Judicial"),
	QUITADO("Quitado"),
	SUSPENSO("Suspensão da Execução Fiscal"),
	PRESCRICAO_INTERCORRENTE("Prescrição Intercorrente");
	
	private String descricao;

	private SituacaoExecucaoFiscalEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoExecucaoFiscalEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				if(nome.toUpperCase().equals("SUSPENSO")) {
					return SituacaoExecucaoFiscalEnum.SUSPENSAO_JUDICIAL;
				}
			}
		} catch (Exception e) {}
		return SituacaoExecucaoFiscalEnum.AJUIZADO;
	}
	
	public static SituacaoExecucaoFiscalEnum get(SitucaoDebitoEnum situacao) {
		try {
			switch (situacao) {
			case SUSPENSAO_JUDICIAL:
				return SUSPENSAO_JUDICIAL;
			case QUITADO:
				return QUITADO;
			default:
				return AJUIZADO;
			}
		} catch (Exception e) {}
		return AJUIZADO;
	}
}
