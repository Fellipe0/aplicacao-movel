package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author felipe-ll
 *
 */
@Getter
public enum TipoCertidaoNegativaEnum {

	CND("Certidão Negativa de Débito"), CPEND("Certidão Positiva com Efeito de Negativa de Débito"), NEGADO("Negado");

	private String descricao;

	private TipoCertidaoNegativaEnum(String descricao) {
		this.descricao = descricao;
	}

	public static TipoCertidaoNegativaEnum get(String nome) {
		try {
			if (StringUtil.isNotNullOrEmpity(nome)) {
				return TipoCertidaoNegativaEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {
		}
		return TipoCertidaoNegativaEnum.CND;
	}
}
