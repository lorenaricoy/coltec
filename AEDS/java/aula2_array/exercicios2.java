/* + Vamos testar tudo o que vimos até agora com o seguinte programa:
     ▶ Classe: Casa Atributos: cor, totalDePortas, portas[] Métodos: void pinta(String s), int
quantasPortasEstaoAbertas(), void adicionaPorta(Porta p), int totalDePortas()
   + Crie uma casa, pinte-a. Crie três portas e coloque-as na casa através do método
adicionaPorta, abra e feche-as como desejar. Utilize o método quantasPortasEstaoAbertas
para imprimir o número de portas abertas e o método totalDePortas para imprimir o total
de portas em sua casa.*/

// Classe Casa

class casa {
    Porta[] casas = new Porta[3];
    String cor;
    int totalDePortas;
    int portas;
    int totalDePortas1 =0;
    
    void pinta(String s){
        this.cor = s;
    }

    void quantasPortasEstaoAbertas(){
        for(int i = 0; i<=3; i++){
            System.out.println("A porta " + i + " está " + this.casas[i].abefec);
        }
    }

    void adicionaPortas(Porta p){
        this.casas[totalDePortas1] = p;
        totalDePortas1 ++;
        this.totalDePortas = totalDePortas1;
    }

    void totalDePortas(){
        System.out.println(this.totalDePortas);
    }
}

//Classe Porta

class Porta{
    String abefec;
    String cor;
}

//Classe main de teste

public class testaCasa {
    public static void main(String[] args) {
        casa Casa = new casa();
        Porta porta1 = new Porta();
        Porta porta2 = new Porta();
        Porta porta3 = new Porta();

        porta1.cor = "azul";
        porta2.cor = "verde";
        porta3.cor = "amarelo";

        porta1.abefec = "Aberto";
        porta2.abefec = "Fechado";
        porta3.abefec = "Fechado";

        Casa.adicionaPortas(porta1);
        Casa.adicionaPortas(porta2);
        Casa.adicionaPortas(porta3);

        Casa.pinta("rosa");

        Casa.quantasPortasEstaoAbertas();

        Casa.totalDePortas();

    }
}
