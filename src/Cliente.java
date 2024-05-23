public class Cliente implements Comparable<Cliente>{
    private int id;
    private String nome;
    private String telefone;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    
	public Cliente(int id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.contaCorrente = null;	
		this.contaPoupanca = null;
	}
	
	@Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome()); 
    }
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", contaCorrente=" + contaCorrente
				+ ", contaPoupanca=" + contaPoupanca + "]";
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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