import java.time.LocalDateTime;

public class ContaPoupanca extends Conta {
    private double minimoSaldo;
    private String dataAbertura;

    public ContaPoupanca(int numeroConta,Cliente cliente,String dataAbertura, double minimoSaldo) {
        super(numeroConta,cliente);
        this.dataAbertura = dataAbertura;
        this.minimoSaldo = minimoSaldo;
        cliente.setContaPoupanca(this);
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

	@Override
	public String toString() {
		return "ContaPoupanca [minimoSaldo=" + minimoSaldo + ", dataAbertura=" + dataAbertura + "]";
	}

	


}
