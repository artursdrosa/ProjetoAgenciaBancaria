public abstract class Cliente implements Comparable<Cliente>{
    private int id;
    private String nome;
    private int telefone;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    
	public Cliente(int id, String nome, int telefone, ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.contaCorrente = contaCorrente;	
		this.contaPoupanca = contaPoupanca;
	}
	
	@Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome()); 
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	
    
    
    
    
}