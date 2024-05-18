public abstract class Conta {
    private int numeroConta;
    private int saldo;
    private Cliente cliente;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void debitar(int valor) {
        if (valor > 0) {
            this.saldo -= valor;
        }else{
            System.out.println("Entre com um valor maior que zero!");
        }
    }

    public void creditar(int valor) {
        if (valor > 0) {
            this.saldo += valor;
        }else{
            System.out.println("Entre com um valor maior que zero!!");
        }
    }

    public abstract void addCliente(Cliente cliente){
        
    }

}
