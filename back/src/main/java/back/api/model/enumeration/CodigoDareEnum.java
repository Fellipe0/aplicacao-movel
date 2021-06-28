package back.api.model.enumeration;

import back.api.util.StringUtil;
import lombok.Getter;

/**
 * 
 * @author suleiman-am
 *
 */
@Getter
public enum CodigoDareEnum {

	TRCF("TRCF", 8, 6l), 
	CONCESSAO("Concessão", 10, 5l), 
	AI("AI", 15, 1l), 
	AIS("AIS", 8, 2l), 
	AIE("AIE", 8, 3l), 
	HONORARIO_ADVOCATICIO("HONORÁRIOS ADVOCATÍCIOS", 26, -1l), 
	OUTORGA("Outorga", 9, 4l);

	private String descricao;
	private Integer valor;
	private Long id;

	private CodigoDareEnum(String descricao, Integer valor, Long id) {
		this.descricao = descricao;
		this.valor = valor;
		this.id = id;
	}
	
	public static String get(String nome) {
		try {
			if(StringUtil.isNotNullOrEmpity(nome)) {
				for(CodigoDareEnum c : CodigoDareEnum.values()) {
					if(nome.contains(c.getDescricao().toString())) {
						return c.getValor().toString();
					}
				}
			}
		} catch (Exception e) {}
		return CodigoDareEnum.AI.getValor().toString();
	}

	public static String get(Long id) {
		try {
			if(id != null) {
				for(CodigoDareEnum c : CodigoDareEnum.values()) {
					if(id.equals(c.getId())) {
						return c.getValor().toString();
					}
				}
			}
		} catch (Exception e) {}
		return CodigoDareEnum.AI.getValor().toString();
	}
}
