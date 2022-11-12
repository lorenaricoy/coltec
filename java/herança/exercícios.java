//Classe Conta

class Conta {
    protected double saldo;

    void setSaldo (double saldo){
        this.saldo = saldo;
    }

    double getSaldo () {
        return this.saldo;
    }

    public void deposita (double valor){
        this.saldo = this.saldo + valor;
    }

    public void saca (double valor){
        this.saldo = this.saldo - valor;
    }
    
    public void atualiza (double taxa) {
        this .saldo += this .saldo * taxa;
    }
}

//Classe herança ContaPoupança1

public class ContaPoupança1 extends Conta {
    @Override
    public void atualiza(double taxa){
        taxa = taxa*3;
        this .saldo += this .saldo* taxa;
    }
}

//Classe herança ContaCorrente1

public class ContaCorrente1 extends Conta {
    @Override
    public void atualiza(double taxa){
        taxa = taxa*2;
        this .saldo += this.saldo * taxa;
    }

    @Override
    public void deposita(double valor){
        this.saldo = this.saldo + valor;
        this.saldo = this.saldo - 0.10;
    }
}

//Classe Banco

class Banco {
    private int numContas = 0;
    int qntContas;
    Conta [] conta = new Conta [qntContas];

    public Banco(int qntContas){
        this.qntContas= qntContas;
        this.conta = new Conta [qntContas];
    }

    public int getNumContas() {
        return numContas;
    }
    public void setNumContas(int numContas) {
        this.numContas = numContas;
    }


    public void adiciona(Conta c){
        conta[numContas] = c;
        numContas ++;
    }

    public Conta pegaConta(int i){
        return conta[i];
    }

    public int pegaTotalDeContas(){
        return this.numContas;
    }
}

//Classe AtualizaContas

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
        System.out.println("saldo anterior: " + c.saldo);
        c.atualiza(selic);
        System.out.println("saldo atual: " + c.saldo);

        saldoTotal =+ c.saldo;
    }
    Banco b;
}

//Classe main para teste

public class teste {
    public static void main (String[] args){
        Banco b = new Banco(10);
        Conta c = new Conta();
        ContaCorrente1 cc = new ContaCorrente1();
        ContaPoupança1 cp = new ContaPoupança1();
        AtualizaContas a = new AtualizaContas(10);

        c.deposita(1000);
        cc.deposita (1000);
        cp.deposita (1000);

        c.atualiza(0.01);
        cc.atualiza (0.01);
        cp.atualiza (0.01);

        b.adiciona(c);
        b.adiciona(cc);
        b.adiciona(cp);

        b.pegaConta(0);

        for(int i=0; i<b.pegaTotalDeContas();i++){
            a.roda(b.conta[i]);
        }
    }
}
