/* 1. Repare que a nossa classe Conta é uma excelente candidata para uma classe abstrata.
Transforme a classe Conta em abstrata, repare o que acontece no seu main já existente do
TestaContas.
2. Para que o código do main volte a compilar, troque o new Conta() por new
ContaCorrente().
3. Transforme o método atualiza() da classe Conta em abstrato. PROBLEMAS?
4. Reescreva o método atualiza()!*/

//Conta

package ex1;
abstract class Conta {
    protected double saldo;

    void setSaldo (double saldo){
        this.saldo = saldo;
    }

    double getSaldo () {
        return this.saldo;
    }

    public void deposita (double valor){
        this.setSaldo (this.getSaldo() + valor);
    }

    public void saca (double valor){
        this.setSaldo (this.getSaldo() - valor);
    }
    
    abstract public void atualiza (double taxa);
}

// ContaCorrente

package ex1;
public class ContaCorrente1 extends Conta {
    @Override
    public void atualiza(double taxa){
        taxa = taxa*2;
        this.setSaldo (this.getSaldo() +  this.getSaldo()*taxa);
    }

    @Override
    public void deposita(double valor){
        this.setSaldo (this.getSaldo() + valor);
        this.setSaldo (this.getSaldo() - 0.10);
    }
}

//ContaPoupança

package ex1;
public class ContaPoupança1 extends Conta {
    @Override
    public void atualiza(double taxa){
        taxa = taxa*3;
        this.setSaldo (this.getSaldo() +  this.getSaldo()*taxa);
    }
}

//AtualizaConta

package ex1;
public class AtualizaContas {
    private double saldoTotal;
    private double selic;
    
    public void setSaldoTotal(double saltoTotal) {
        this.saldoTotal = saltoTotal;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public AtualizaContas (double selic){
        this.selic = selic;
    }

    public void roda (Conta c){
        System.out.println("saldo anterior: " + c.getSaldo());
        c.atualiza(selic);
        System.out.println("saldo atual: " + c.getSaldo());

        saldoTotal =+ c.getSaldo();
    }
    Banco b;
}


//Banco

package ex1;
class Banco {
    private int numContas = 0;
    Conta[] conta;

    public Conta[] getConta_total() {
        return conta;
    }
    public Conta getConta(int i) {
        return conta[i];
    }
    public void setConta(Conta conta, int i) {
        this.conta[i] = conta;
    }
    public int getNumContas() {
        return numContas;
    }
    public void setNumContas(int numContas) {
        this.numContas = numContas;
    }

    public void adiciona(Conta c){
        if(this.getConta_total()== null){
            this.conta=new Conta[1];
            this.setConta(c, 0);
        } else{
            Conta[] conta02 =new Conta[getConta_total().length];
            for(int i=0; i<getConta_total().length;i++){
                conta02[i]=this.getConta(i);
            }
            this.conta=new Conta[conta02.length+1];
            for(int i=0; i<conta02.length;i++){
                this.setConta(conta02[i], i);
            }
            this.setConta(c, getConta_total().length-1);
        }
    }

    public Conta pegaConta(int i){
        System.out.println(conta[i].getSaldo());
        return conta[i];
    }

    public int pegaTotalDeContas(){
        return getConta_total().length;
    }
}

//teste main

package ex1;
public class teste {
    public static void main (String[] args){
        Banco b = new Banco();
        ContaCorrente1 cc = new ContaCorrente1();
        ContaPoupança1 cp = new ContaPoupança1();
        AtualizaContas a = new AtualizaContas(10);

        cc.deposita (1000);
        cp.deposita (1000);

        cc.atualiza (0.01);
        cp.atualiza (0.01);

        b.adiciona(cc);
        b.adiciona(cp);

        b.pegaConta(0);
        b.pegaConta(1);

        for(int i=0; i<b.pegaTotalDeContas();i++){
            System.out.println(".");
            a.roda(b.conta[i]);
        }
    }
}
