public class ContaCorrente extends Conta{
    private double taxaJuro;
    private String dataAbertura;
    
	public ContaCorrente(int numeroConta,Cliente cliente, String dataAbertura, double taxaJuro) {
		super(numeroConta,cliente);
		this.taxaJuro = taxaJuro;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void addCliente(Cliente cliente) {
		setCliente(cliente);
		cliente.setContaCorrente(this);
	}

	@Override
	public void removeCliente() {
		setCliente(null);
	}

	
}
