/*2. Nosso banco precisa tributar dinheiro de alguns bens que nossos clientes possuem. Para
isso, vamos criar uma interface no nosso projeto banco já existente:
▶ Alguns bens são tributáveis e outros não, ContaPoupanca não é tributável, já para
ContaCorrente você precisa pagar 1% da conta e o SeguroDeVida tem uma taxa fixa de 42
reais.
▶ Crie a classe SeguroDeVida, claro ;)
▶ Crie uma classe TestaTributavel com um método main.*/

//Tributavel

package ex2;

interface Tributavel {
    double calculaTributos();
}

//Conta

package ex2;
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

//ContaCorrente

package ex2;

public class ContaCorrente1 extends Conta implements Tributavel {
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

    @Override
    public double calculaTributos() {
        double tributos=this.getSaldo()*0.01;
        return tributos;
    }
}


//ContaPoupança

package ex2;

public class ContaPoupança1 extends Conta {
    @Override
    public void atualiza(double taxa){
        taxa = taxa*3;
        this.setSaldo (this.getSaldo() +  this.getSaldo()*taxa);
    }
}

//SeguroDeVida

package ex2;

public class SeguroDeVida  implements Tributavel{

    @Override
    public double calculaTributos() {
        double taxa = 45;
        return taxa;
    }
    
}


//teste

package ex2;

public class teste {
    public static void main (String[] args){
        ContaCorrente1 cc = new ContaCorrente1();
        ContaPoupança1 cp = new ContaPoupança1();
        SeguroDeVida seguro = new SeguroDeVida();

        cc.deposita (1000);
        cp.deposita (1000);

        double triConta=cc.calculaTributos();
        double triSeguro=seguro.calculaTributos();

        System.out.println("Tributo Conta Corrente: " + triConta + "\n" + "Tributo Seguro de vida: " + triSeguro + "\n" + "Conta Poupança não tem tributos!");
    }
}
