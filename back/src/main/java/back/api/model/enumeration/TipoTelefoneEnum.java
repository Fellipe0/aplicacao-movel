package back.api.model.enumeration;

import lombok.Getter;

@Getter
public enum TipoTelefoneEnum {
	FIXO("Fixo"),
	CELULAR("Celular");
	
	private String descricao;
	
	private TipoTelefoneEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoTelefoneEnum get(String nome) {
		TipoTelefoneEnum retorno = TipoTelefoneEnum.valueOf(nome != null ? nome.trim().toUpperCase() : "CELULAR");
		return retorno != null ? retorno : TipoTelefoneEnum.CELULAR;
	}
}
