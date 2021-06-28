package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum OrigemCadastroDebitoEnum {

	SISTEMA_S506("Sistema s506"), 
	AGR_FISCAL("AGR Fiscal"), 
	SEI("SEI");

	private String descricao;

	private OrigemCadastroDebitoEnum(String descricao) {
		this.descricao = descricao;
	}

	public static OrigemCadastroDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return OrigemCadastroDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return OrigemCadastroDebitoEnum.SEI;
	}
}
