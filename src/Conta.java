public abstract class Conta implements Comparable<Conta> {
    private int numeroConta;
    private float saldo;
    private Cliente cliente;

    public Conta(int numeroConta,Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }
    
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void debitar(float valor) {
        if (valor > 0) {
            this.saldo -= valor;
        }else{
            System.out.println("Entre com um valor maior que zero!");
        }
    }

    public void creditar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
        }else{
            System.out.println("Entre com um valor maior que zero!!");
        }
    }

    public abstract void addCliente(Cliente cliente); 
    // esses metodos poderiam ser implementado diretamente aqui, mas como no UML diz para cada
	// subclasse implementar fizemos os metodos abstratos para garantir essa implementação
    public abstract void removeCliente();
    
    @Override
    public int compareTo(Conta outraConta) {
        return Integer.compare(this.numeroConta, outraConta.getNumeroConta());
    }

}
