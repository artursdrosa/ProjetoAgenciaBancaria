public class ContaPoupanca extends Conta {
    private double minimoSaldo;
    private String dataAbertura;

    public ContaPoupanca(int numeroConta,Cliente cliente,String dataAbertura, double minimoSaldo) {
        super(numeroConta,cliente);
        this.dataAbertura = dataAbertura;
        this.minimoSaldo = minimoSaldo;
    }

	@Override
	public void addCliente(Cliente cliente) {
		setCliente(cliente);
		cliente.setContaPoupanca(this);
	}

	@Override
	public void removeCliente() {
		setCliente(null);
		getCliente().setContaPoupanca(null);
	}

	


}
