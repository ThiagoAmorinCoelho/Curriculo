package istudapraprova;
import java.util.Scanner;

class Conta{
    private String agencia;
    private String titular;
    private int numero;
    private double saldo;

    public Conta(String agencia, int numero, String titular){
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }
    
    public double getSaldo(){
        return saldo;
    }
    public int getNumero(){
        return numero;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setNumero(int numero){
        this.numero= numero;
    }
    public boolean sacar(double valor){
        if ( valor <= this.saldo){
            this.saldo = this.saldo - valor;
        
            System.out.print("Conta="+numero+", saque de "+valor+". Saldo = "+saldo+"\n");
            return true;
        }
        else{
            System.out.print("Valor do saque não permitido\n");
            return false;
        }
    }
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("Conta="+numero+", deposito de "+valor+". Saldo = "+saldo);
    }
    public boolean transferir(Conta c1, double saldo){
        boolean confirma = this.sacar(saldo);
        if (confirma == true){
            c1.depositar(saldo);
            return true;
        }
        return false;
    }
    public String toString(){
      return titular+" Ag=" + agencia + ", num=" + numero + ", saldo=" + saldo ;
    }
}

public class Ex1{
    public static void main(String[]ars){
        Scanner sc = new Scanner(System.in);
        String agencia1 = sc.next();
        int numero1 = sc.nextInt();
        String titular1 = sc.next();
        Conta conta1 = new Conta(agencia1,numero1,titular1);

        String agencia2 = sc.next();
         int numero2 = sc.nextInt();
        String titular2 = sc.next();
        Conta conta2 = new Conta(agencia2,numero2,titular2);
    
        double saldo1 = sc.nextDouble();
        double saldo2 = sc.nextDouble();

        conta1.depositar(saldo1);
        conta2.depositar(saldo2);

        double transfer = sc.nextDouble();
        conta1.transferir(conta2,transfer);

        double saque = sc.nextDouble();
        conta1.sacar(saque);

        System.out.println(conta1.toString());
        System.out.println(conta2.toString());
        
        sc.close();
    }

}