package poo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AguardandoRH extends Status {

	@Id
	private Long id;
	
	public AguardandoRH() {
		this.id = super.AGUARDANDO_RH;
	}
	
	@Override
	public void solicitar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Solicitada pois está AguardandoRH");
	}

	@Override
	public void aprovar() {
		this.solicitacao.setStatus(new Aprovada());
	}

	@Override
	public void recusar() {
		this.solicitacao.setStatus(new Recusada());
	}

	@Override
	public void retornar() {
		this.solicitacao.setStatus(new AguardandoChefia());
	}

	@Override
	public String toString() {
		return "AguardandoRH";
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
		if (!(obj instanceof AguardandoRH))
			return false;
		return true;
	}

}