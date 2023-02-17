/*1. Vamos criar uma classe Conta, que possua um saldo, os métodos para pegar saldo,
depositar e sacar.
2. Adicione um método na classe Conta, que atualiza essa conta de acordo com uma taxa
percentual fornecida.*/
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

/*3. Crie duas subclasses da classe Conta: ContaCorrente e ContaPoupanca. Ambas terão o
método atualiza reescrito: A ContaCorrente deve atualizar-se com o dobro da taxa e a
ContaPoupanca deve atualizar-se com o triplo da taxa. Além disso, a ContaCorrente deve
reescrever o método deposita, a fim de retirar uma taxa bancária de dez centavos de cada
depósito.*/
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

/*5. Vamos criar uma classe que seja responsável por fazer a atualização de todas as contas
bancárias e gerar um relatório com o saldo anterior e saldo novo de cada uma das contas.*/
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

/*6. Crie uma classe Banco que possui um array de Conta. Repare que num array de Conta
você pode colocar tanto ContaCorrente quanto ContaPoupanca. Crie um método public
void adiciona(Conta c), um método public Conta pegaConta(int x) e outro public int
pegaTotalDeContas(), muito similar a relação anterior de Empresa-Funcionario.
Faça com que seu método main crie diversas contas, insira-as no Banco e depois, com um
for, percorra todas as contas do Banco para passá-las como argumento para o
AtualizadorDeContas.*/
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
