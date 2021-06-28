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
@Table(name = "embarcados")
public class Embarcados implements Serializable {
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

	@Column(name = "descricao_embarcado")
	private String descricaoEmbarcado;

	private String firmware;

	@Column(name = "ip_embarcado")
	private String ipEmbarcado;

	@Column(name = "ip_gateway")
	private String ipGateway;

	private String mac;

	@Column(name = "password_wifi")
	private String passwordWifi;

	private String ssid;

	private String status;

	@Column(name = "tipo_rede")
	private String tipoRede;

	@Column(name = "ambiente_id")
	private Integer ambienteId;

	@PreUpdate
	public void preUpdate() {
		this.dataCriacao = new Date();
		this.status = "ATIVO";
	}
}
