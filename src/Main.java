import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    	Scanner sc = new Scanner(System.in);
    	Agencia agencia1 = new Agencia(0001,"FLN");	
    	int idCliente = 0;
    	int numeroConta = 1000; // valores identificadores que serão incrementados
    	while(true){
    		System.out.println("============MENU============");
    		mostraMenu();
    		String opt = sc.nextLine();
    		if(validaOpt(opt)) {
    			switch(opt) {
    	    	case("1"):
    	    		String nome;
    	    		String telefone;
    	    		System.out.println("Nome: ");
    	    		nome = sc.nextLine();
    	    		System.out.println("Telefone: ");
    	    		telefone = sc.nextLine();
    	    		clientes.add(new Cliente(idCliente,nome,telefone));
    	    		break;
    	    	case("2"):
    	    		
    	    	}
    		}
    	}
    	
    	
    	
    	
    }
    
    public static void mostraMenu() {
    	System.out.println("Informe a operação desejada:\n"
				+ "1 - Adicionar cliente \n"
				+ "2 - Adicionar conta \n"
				+ "3 - Debitar conta \n"
				+ "4 - Depositar em conta \n"
				+ "5 - Consultar saldo em conta \n"
				+ "6 - Consultar informações do cliente \n"
				+ "7 - Remover conta \n"
				+ "8 - Encerrar programa \n"
				+ ">>");
    }
    
    public static boolean validaOpt(String opt){
    	try {
            int option = Integer.parseInt(opt); // tentando coverter string para inteiro, se falhar é porque a entrada é inválida
            if (option >= 1 && option <= 8) {
                return true;
            } else {
                System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 7.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            return false;
        }
    }
    
}