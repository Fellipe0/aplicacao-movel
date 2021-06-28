package back.api.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseAnexo {
	private String nome;
	private String tipo;
	private String bytes;
	
	public ResponseAnexo(String nome, String tipo, String bytes) {
		this.nome = nome;
		this.tipo = tipo;
		this.bytes = bytes;
	}
}
