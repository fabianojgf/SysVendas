package poo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NovaSolicitacao extends Status {

	@Id
	private Long id;

	public NovaSolicitacao() {
		this.id = super.NOVA_SOLICITACAO;
	}
	
	@Override
	public void solicitar() {
		this.solicitacao.setStatus(new AguardandoChefia());
	}

	@Override
	public void aprovar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser aprovada pois é nova");
	}

	@Override
	public void recusar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser recusada pois é nova");
	}

	@Override
	public void retornar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser retornada pois é nova");
	}

	@Override
	public String toString() {
		return "NovaSolicitação";
	}

	@Override
	public int hashCode() {
		int hash = 31;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NovaSolicitacao))
			return false;

		return true;
	}

}
