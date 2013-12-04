package poo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Transactional;

@Entity
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "não pode ser nulo")
	private Funcionario funcionario;

	@NotNull(message = "não pode ser nulo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@NotNull(message = "não pode ser nulo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;

	@NotEmpty(message = "não pode ser vazio")
	private String motivo;

	private String observacao;

	@ManyToOne
	Status status = new NovaSolicitacao();

	@Transactional
	public String solicitar() {
		status.setSolicitacao(this);
		status.solicitar();
		return "Solicitada com sucesso";
	}

	@Transactional
	public String aprovar() {
		status.setSolicitacao(this);
		status.aprovar();
		return "Aprovada com sucesso";
	}

	@Transactional
	public String recusar() {
		status.setSolicitacao(this);
		status.recusar();
		return "Recusada com sucesso";
	}

	@Transactional
	public String retornar(String mensagem) {
		status.setSolicitacao(this);
		status.retornar();
		this.setObservacao(mensagem);
		return "Retornada com sucesso";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		result = prime * result + ((termino == null) ? 0 : termino.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (termino == null) {
			if (other.termino != null)
				return false;
		} else if (!termino.equals(other.termino))
			return false;
		return true;
	}
}
