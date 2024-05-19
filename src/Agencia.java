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

    public void addConta(int numeroConta, boolean tipoConta,String dataAbertura, double paramExtra,Cliente cliente) {     //levando em consideração que a "conta" vai começar com o saldo zerado
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println("Esse numéro de conta já está presente em uma conta!");
                return;
            }
        }
        Conta conta;
        if(tipoConta) {
        	conta = new ContaPoupanca(numeroConta,cliente,dataAbertura,paramExtra);
        }else {
        	conta = new ContaCorrente(numeroConta,cliente,dataAbertura,paramExtra);
        }
		//validar qual tipo de conta ele vai escolher
        this.contas.add(conta);
    }

    public void removeConta(int numeroConta) {      //numeroConta deve ser único, pois será identificador
        for (Conta conta : this.contas) {
            if(conta.getNumeroConta() == numeroConta) {
                this.contas.remove(conta);
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
}
