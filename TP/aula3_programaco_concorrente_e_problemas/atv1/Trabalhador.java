package TP.aula3_programaco_concorrente_e_problemas.atv1;

public class Trabalhador extends Thread {
    String produto ;
    int tempo ;
    boolean parar = false;

    public Trabalhador ( String produto , int tempo ) {
        this.produto = produto ;
        this.tempo = tempo ;
    }
    
    public void run () {
        int j = 0;
        while(parar=false){
            j++;
            for (int i = 0; i < 50; i ++) {
                System.out.println(i + " " + produto );
                try {
                    sleep(( long ) ( Math.random() * tempo )) ;
                } catch ( InterruptedException e) {}
            }
            System.out.println(" Terminei " + produto );

            if(j==20){
                parar();
                System.out.println("parou");
            }
        }
    }

    public boolean parar() {
        return parar=true;
    }


}
