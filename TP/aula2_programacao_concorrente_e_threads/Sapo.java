package TP.aula2_programacao_concorrente_e_threads;

public class Sapo extends Thread{
    int distanciaPercorrida=0;
    int distanciaPulo;
    int distanciaCorrida;
    String nome;
    int lugarPodio;
    static int lugar=0;
    static int NumSapos=0;

    public Sapo(String nome, int distanciaCorrida, int distanciaPulo){
        this.nome=nome;
        this.distanciaCorrida= distanciaCorrida;
        this.distanciaPulo=distanciaPulo;
        NumSapos=+1;
    }

    public void SapoPulo(){
        this.distanciaPercorrida += this.distanciaPulo;
    }

    
    public void run(){
        while(this.distanciaPercorrida<this.distanciaCorrida){
            SapoPulo();
            System.out.println("O sapo " + this.nome + " percorreu " + this.distanciaPercorrida);
        }
        System.out.println("O sapo " + this.nome + " chegou");
        lugar= lugar+1;
        this.lugarPodio=lugar;
    }
}
