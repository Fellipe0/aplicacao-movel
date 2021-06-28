package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SitucaoDebitoEnum {

	NAO_QUITADO("Não Quitado"),
	CADASTRO_VALIDADO("Cadastro Validado"),
	CADASTRO_RECUSADO("Cadastro Recusado"),
	PRESCRITO("Prescrito"),
	SOBRESTAMENTO_INSCRICAO_AUTOMATICA("Sobrestamento de Inscrição Automática"),
	SUSPENSAO_JUDICIAL("Suspensão Judicial"),
	ANULADO("Anulado"),
	QUITADO("Quitado"),
	PARCELAMENTO_LIQUIDADO("Parcelamento Liquidado"),
	INSCRITO_DA_NAO_AJUIZADO("Inscrito em DA e não ajuizado"),
	INSCRITO_DA_AJUIZADO_EXECUCAO_FISCAL("Inscrito em DA e ajuizado (em execução Fiscal)"),
	TAC_PARCELAMENTO_ABERTO_VENCER("TAC - Parcelamento em aberto (a vencer)"),
	TAD_PARCELAMENTO_ABERTO_VENCER("TAD - Parcelamento em aberto (a vencer)"),
	TAC_PARCELAMENTO_ATRASO_VENCIDAS("TAC - Parcelamento em atraso (vencidas)"),
	TAD_PARCELAMENTO_ATRASO_VENCIDAS("TAD - Parcelamento em atraso (vencidas)"),
	PRESCRICAO_INTERCORRENTE("Prescrição Intercorrente");

	private String descricao;

	private SitucaoDebitoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public static SitucaoDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SitucaoDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SitucaoDebitoEnum.NAO_QUITADO;
	}
	
	public static SitucaoDebitoEnum get(SituacaoExecucaoFiscalEnum situacao) {
		try {
			switch (situacao) {
			case QUITADO:
				return QUITADO;
			case SUSPENSAO_JUDICIAL:
				return SUSPENSAO_JUDICIAL;
			default:
				return INSCRITO_DA_AJUIZADO_EXECUCAO_FISCAL;
			}
		} catch (Exception e) {}
		return SitucaoDebitoEnum.SOBRESTAMENTO_INSCRICAO_AUTOMATICA;
	}

	public static SitucaoDebitoEnum get(SitucaoChecklistDebitoEnum situacao) {
		try {
			switch (situacao) {
			case DOCUMENTACAO_VALIDADA:
				return SitucaoDebitoEnum.CADASTRO_VALIDADO;
			default:
				return SitucaoDebitoEnum.CADASTRO_RECUSADO;
			}
		} catch (Exception e) {}
		return SitucaoDebitoEnum.SOBRESTAMENTO_INSCRICAO_AUTOMATICA;
	}

	public static String getDetalhe(Object nome) {
		try {
			if(nome != null) {
				return SitucaoDebitoEnum.valueOf(nome.toString().toUpperCase()).getDescricao();
			}
		} catch (Exception e) {}
		return "-";
	}
	
	public static Boolean isDividaFechado(SitucaoDebitoEnum situacao) {
		return situacao != null && (situacao.equals(PRESCRITO) 
				|| situacao.equals(SUSPENSAO_JUDICIAL)
				|| situacao.equals(ANULADO)
				|| situacao.equals(PRESCRICAO_INTERCORRENTE)
				|| situacao.equals(QUITADO)
				|| situacao.equals(PARCELAMENTO_LIQUIDADO));
	}
	
	public static Boolean isInscritoDa(SitucaoDebitoEnum situacao) {
		return situacao != null && (situacao.equals(INSCRITO_DA_NAO_AJUIZADO) 
				|| situacao.equals(INSCRITO_DA_AJUIZADO_EXECUCAO_FISCAL));
	}
	
	public static Boolean isInscritoDaOrSuspenso(SitucaoDebitoEnum situacao) {
		return situacao != null && (situacao.equals(INSCRITO_DA_NAO_AJUIZADO) 
				|| situacao.equals(INSCRITO_DA_AJUIZADO_EXECUCAO_FISCAL) 
				|| situacao.equals(SUSPENSAO_JUDICIAL));
	}

	public static Boolean inParcelamento(SitucaoDebitoEnum situacao) {
		return situacao != null && (situacao.equals(TAC_PARCELAMENTO_ABERTO_VENCER) 
				|| situacao.equals(TAD_PARCELAMENTO_ABERTO_VENCER)
				|| situacao.equals(TAC_PARCELAMENTO_ATRASO_VENCIDAS)
				|| situacao.equals(TAD_PARCELAMENTO_ATRASO_VENCIDAS));
	}
}
