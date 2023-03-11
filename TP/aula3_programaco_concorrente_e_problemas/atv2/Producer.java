package TP.aula3_programaco_concorrente_e_problemas.atv2;
import java.lang.Math;

public class Producer implements Runnable {
    PilhaSincronizada pilha ;

    public Producer ( PilhaSincronizada pilha ) {
        this.pilha = pilha ;
    }
    public void run () {
        int colorIdx ;
        for (int i=0; i<40; i++) {
            colorIdx = (int)(Math.random()) ;
            pilha.push( colorIdx ) ;
            System.out.println(" Criado : "+ colorIdx );
            try {
                Thread.sleep((int) (Math.random() * 1000) );
            } catch ( InterruptedException e) {}
        }
    }
}
