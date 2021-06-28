package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum NaturezaDividaDebitoEnum {

	NAO_TRIBUTARIA("Não Tributária"),
	TRIBUTARIA("Tributária");

	private String descricao;

	private NaturezaDividaDebitoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public static NaturezaDividaDebitoEnum get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				return NaturezaDividaDebitoEnum.valueOf(nome.toUpperCase());
			}
		} catch (Exception e) {}
		return NaturezaDividaDebitoEnum.NAO_TRIBUTARIA;
	}

	public static String getDetalhe(Object nome) {
		try {
			if(nome != null) {
				return NaturezaDividaDebitoEnum.valueOf(nome.toString().toUpperCase()).getDescricao();
			}
		} catch (Exception e) {}
		return "-";
	}
}
