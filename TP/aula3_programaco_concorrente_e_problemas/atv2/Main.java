package TP.aula3_programaco_concorrente_e_problemas.atv2;

public class Main {
    public static void main(String[] args){
        PilhaSincronizada pilha = new PilhaSincronizada();
        Producer produtor = new Producer(pilha);
        Consumer consumidor = new Consumer(pilha);

        produtor.run();
        consumidor.run();
    }
}
