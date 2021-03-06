package poo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cancelada extends Status {

	@Id
	private Long id;

	public Cancelada() {
		this.id = super.APROVADA;
	}

	@Override
	public void solicitar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Aprovada pois está Aprovada");
	}

	@Override
	public void aprovar() {
		throw new IllegalStateException("A solicitação já está Aprovada");
	}

	@Override
	public void recusar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Recusada pois está Aprovada");
	}

	@Override
	public void retornar() {
		throw new IllegalStateException(
				"A solicitação nao pode ser Retornada pois está Aprovada");
	}
	
	@Override
	public void cancelar() {
		throw new IllegalStateException(
				"A solicitação já está cancelada");
	}

	@Override
	public String toString() {
		return "Aprovada";
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
		if (!(obj instanceof Cancelada))
			return false;
		return true;
	}

}