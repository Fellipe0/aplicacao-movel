package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SituacaoPessoaEnum {

	ATIVO("Ativo"), 
	INATIVO("Inativo"), 
	VALIDACAO("Validação"), 
	BLOQUEADO("Bloqueado"), 
	EM_ANDAMENTO_DE_BAIXA("Em Andamento de Baixa"), 
	BAIXADO("Baixado"),
	SOCIO("Sócio");

	private String descricao;

	private SituacaoPessoaEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoPessoaEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return SituacaoPessoaEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return SituacaoPessoaEnum.ATIVO;
	}
}
