package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum SitucaoChecklistDebitoEnum {

	DOCUMENTACAO_VALIDADA("Documentação Validada"), DOCUMENTACAO_IMPUGNADA("Documentação Impugnada");

	private String descricao;

	private SitucaoChecklistDebitoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static SitucaoChecklistDebitoEnum get(String nome) {
		try {
			if (StringUtil.isNotNullOrEmpity(nome)) {
				return SitucaoChecklistDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {
		}
		return SitucaoChecklistDebitoEnum.DOCUMENTACAO_IMPUGNADA;
	}
}
