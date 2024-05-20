import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaCorrente extends Conta{
    private double taxaJuro;
    private String dataAbertura;
    
	public ContaCorrente(int numeroConta,Cliente cliente, double taxaJuro) {
		super(numeroConta,cliente);
		this.taxaJuro = taxaJuro;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.dataAbertura = LocalDateTime.now().format(formatter);
		cliente.setContaCorrente(this);
	}

	@Override
	public void addCliente(Cliente cliente) {
		setCliente(cliente);
		cliente.setContaCorrente(this);
	}

	@Override
	public void removeCliente() {
		setCliente(null);
		getCliente().setContaCorrente(null);
	}

	@Override
	public String toString() {
		return "ContaCorrente [taxaJuro=" + taxaJuro + ", dataAbertura=" + dataAbertura + ", numeroConta=" + super.getNumeroConta() + "]";
	}
}
