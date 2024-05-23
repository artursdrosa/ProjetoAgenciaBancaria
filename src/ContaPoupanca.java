import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends Conta {
    private double minimoSaldo;
    private String dataAbertura;

    public ContaPoupanca(int numeroConta,Cliente cliente, double minimoSaldo) {
        super(numeroConta,cliente);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.dataAbertura = LocalDateTime.now().format(formatter);
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
		return "ContaPoupanca [minimoSaldo= " + minimoSaldo + ", dataAbertura= " + dataAbertura + ", numeroConta= " + super.getNumeroConta() + "]";
	}

	


}
