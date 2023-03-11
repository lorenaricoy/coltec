package TP.aula2_programacao_concorrente_e_threads;

public class CorridaDeSapos{

    public static void main(String[] args){
        int distanciaCorrida=200;
        Sapo rosa = new Sapo("rosa", distanciaCorrida, 20);
        Sapo roxo = new Sapo("roxo", distanciaCorrida, 10);
        Sapo verdeagua = new Sapo("verdeagua", distanciaCorrida, 40);
        Sapo amarelo = new Sapo("amarelo", distanciaCorrida, 25);

        rosa.start();
        roxo.start();
        verdeagua.start();
        amarelo.start();

    }
}