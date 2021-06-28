package back.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ambientes")
public class Ambientes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_create")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_update")
	private Date dataUpdate;

	private Integer capacidade;

	private String descricao;

	@Column(name = "ip_camera")
	private String ipCamera;

	@Column(name = "nome_ambiente")
	private String nomeAmbiente;

	@Column(name = "tipo_ambiente")
	private String tipoAmbiente;

	@Column(name = "bloco_id")
	private Integer blocoId;

	@PreUpdate
	public void preUpdate() {
		this.dataCriacao = new Date();
	}
}
