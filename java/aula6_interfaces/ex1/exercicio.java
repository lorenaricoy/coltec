/*1. Vamos começar com um exercício para praticar a sintaxe. Crie um projeto interfaces e
crie a interface AreaCalculavel:
▶ Crie algumas classes que são AreaCalculavel: Quadrado, Retangulo, Círculo.
▶ Crie uma classe Teste com o main.*/

//Formas

package ex1;
public abstract class Formas {
    protected double altura;
    protected double largura;

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }
}

//Area Calculavel

package ex1;
interface AreaCalculavel{
    double calculaArea();
    void addTamanho();
}

//Quadrado

package ex1;
import java.util.Scanner;

public class Quadrado extends Formas implements AreaCalculavel {
    Scanner ler = new Scanner(System.in);

    @Override
    public void addTamanho(){
        System.out.println("Qual é a medida dos lados do quadrado?");
        double medida=ler.nextDouble();
        this.setAltura(medida);
        this.setLargura(medida);
    }

    @Override
    public double calculaArea() {
        double area =this.getAltura()*this.getLargura();
        return area;
    }
    
}

//Circulo

package ex1;
import java.util.Scanner;

public class Circulo extends Formas implements AreaCalculavel {
    private double raio;
    Scanner ler = new Scanner(System.in);

    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public void addTamanho(){
        System.out.println("Qual é o raio do circulo?");
        this.setRaio(ler.nextDouble());
    }

    @Override
    public double calculaArea() {
        double potencia = Math.pow(this.getRaio(), 2);
        double area= 3.14*potencia;
        return area;
    }
    
}


//Retangulo

package ex1;
import java.util.Scanner;

public class Retangulo extends Formas implements AreaCalculavel{
    Scanner ler = new Scanner(System.in);

    @Override
    public void addTamanho(){
        System.out.println("Qual é a altura do retangulo?");
        this.setAltura(ler.nextDouble());
        System.out.println("Qual é a largura do retangulo?");
        this.setLargura(ler.nextDouble());
    }

    @Override
    public double calculaArea() {
        double area= this.getAltura()* this.getLargura();
        return area;
    }
    
}

//teste

package ex1;
public class teste {
    public static void main(String[] args) throws Exception {
        Quadrado quadrado = new Quadrado();
        Circulo circulo = new Circulo();
        Retangulo retangulo = new Retangulo();

        quadrado.addTamanho();
        circulo.addTamanho();
        retangulo.addTamanho();

        double areaQuadrado = quadrado.calculaArea();
        double areaCirculo =circulo.calculaArea();
        double areaRetangulo =retangulo.calculaArea();

        System.out.println("Area quadrado: " + areaQuadrado + "\n" + "Area Circulo: " + areaCirculo + "\n" + "Area retangulo: " + areaRetangulo);

    }
}
