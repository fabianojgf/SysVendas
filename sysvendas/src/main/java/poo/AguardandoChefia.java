package poo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AguardandoChefia extends Status {

	@Id
	private Long id;
	
	public AguardandoChefia() {
		this.id = super.AGUARDANDO_CHEFIA;
	}
	
	@Override
	public void solicitar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Solicitada pois está Aguardando Chefia");
	}

	@Override
	public void aprovar() {
		this.solicitacao.setStatus(new AguardandoRH());
	}

	@Override
	public void recusar() {
		this.solicitacao.setStatus(new Recusada());
	}

	@Override
	public void retornar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Retorada pois está Aguardando Chefia");
	}

	@Override
	public void cancelar() {
		this.solicitacao.setStatus(new Cancelada());
	}
	
	@Override
	public String toString() {
		return "AguardandoChefia";
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
		if (!(obj instanceof AguardandoChefia))
			return false;
		return true;
	}

}