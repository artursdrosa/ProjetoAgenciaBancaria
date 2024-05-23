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

    public boolean addConta(int numeroConta, boolean tipoConta,double paramExtra,Cliente cliente) {     //levando em consideração que a "conta" vai começar com o saldo zerado
        Conta conta = null;
        if(tipoConta) {
            if(cliente.getContaPoupanca() == null) {
                conta = new ContaPoupanca(numeroConta, cliente, paramExtra);
            }else{
                System.out.println("Esse cliente já tem uma conta poupança!");
                return false;
            }
        }else {
            if(cliente.getContaCorrente() == null) {
                conta = new ContaCorrente(numeroConta, cliente, paramExtra);
            }else{
                System.out.println("Esse cliente já tem uma conta corrente!");
                return false;
            }
        }
        this.contas.add(conta);
        return true;
    }

    public void removeConta(int numeroConta) {
        for (int i = 0; i < this.contas.size(); i++) {
            Conta conta = this.contas.get(i);
            if (conta.getNumeroConta() == numeroConta) {
                this.contas.remove(i);
                if (conta instanceof ContaPoupanca) {
                    conta.getCliente().setContaPoupanca(null);
                } else {
                    conta.getCliente().setContaCorrente(null);
                }
                break; // Parar o loop após encontrar e remover a conta
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
