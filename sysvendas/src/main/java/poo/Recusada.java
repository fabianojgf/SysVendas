package poo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recusada extends Status {

	@Id
	private Long id;

	public Recusada() {
		this.id = super.RECUSADA;
	}
	
	@Override
	public void solicitar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Solicitada pois está Recusada");
	}

	@Override
	public void aprovar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Aprovada pois está Recusada");
	}

	@Override
	public void recusar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Recusada pois está Recusada");
	}

	@Override
	public void retornar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Retornada pois está Recusada");
	}

	@Override
	public String toString() {
		return "Recusada";
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
		if (!(obj instanceof Recusada))
			return false;
		return true;
	}
}