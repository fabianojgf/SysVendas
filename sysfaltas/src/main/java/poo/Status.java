package poo;

abstract public class Status {

	public final long AGUARDANDO_CHEFIA = 1l;
	public final long AGUARDANDO_RH = 2l;
	public final long APROVADA = 3l;
	public final long NOVA_SOLICITACAO = 4l;
	public final long RECUSADA = 5l;
	public final long CANCELADA = 6l;
	
	protected Solicitacao solicitacao;

	abstract public void solicitar();

	abstract public void aprovar();

	abstract public void recusar();

	abstract public void retornar();
	
	abstract public void cancelar();

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
}
