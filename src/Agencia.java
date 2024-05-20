import java.util.ArrayList;

public class Agencia {
    private int codigoAgencia;
    private String cidade;
    private ArrayList<Conta> contas;

    public Agencia(int codigoAgencia, String cidade) {
        this.codigoAgencia = codigoAgencia;
        this.cidade = cidade;
        this.contas = new ArrayList<Conta>();
    }

    public void addConta(int numeroConta, boolean tipoConta,double paramExtra,Cliente cliente) {     //levando em consideração que a "conta" vai começar com o saldo zerado
        Conta conta = null;
        if(tipoConta) {
            if(cliente.getContaPoupanca() == null) {
                conta = new ContaPoupanca(numeroConta, cliente, paramExtra);
            }else{
                System.out.println("Esse cliente já tem uma conta poupança!");
            }
        }else {
            if(cliente.getContaCorrente() == null) {
                conta = new ContaCorrente(numeroConta, cliente, paramExtra);
            }else{
                System.out.println("Esse cliente já tem uma conta corrente!");
            }
        }
        this.contas.add(conta);
    }

    public void removeConta(int numeroConta) {      //numeroConta deve ser único, pois será identificador
        for (Conta conta : this.contas) {
            if(conta.getNumeroConta() == numeroConta) {
                this.contas.remove(conta);
                if(conta.getClass() == ContaPoupanca.class) {
                    conta.getCliente().setContaPoupanca(null);
                }else{
                    conta.getCliente().setContaCorrente(null);
                }
            }
        }
    }

    public Conta getConta(int numeroConta) {
        for (Conta conta : this.contas) {
            if(conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        System.out.println("Não achamos uma conta com esse numero de conta!");
        return null;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
