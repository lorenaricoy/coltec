/* Crie uma classe chamada Pessoa. Uma pessoa possui um nome e uma idade.
▶ crie 2 construtores: 1 que recebe o nome e a idade como parâmetros de entrada e um que
não recebe parâmetros e inicializa os atributos com um valor padrão (ÒindefinidoÓ para
Strings e 0 para inteiros).
▶ crie os métodos de acesso para os atributos (GET e SET).*/

package ex2;

class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade){
        this.setNome(nome);
        this.setIdade(idade);
    }

    public Pessoa(){
        this.setNome("indefinido");
        setIdade(0);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}

/* Crie uma classe Amigo, que herda Pessoa, e possui uma data de aniversário.
▶ crie um construtor que não recebe parâmetros de entrada, e inicializa o atributo com um
valor padrão ("indefinido", por exemplo).
▶ crie os métodos de acesso para o atributo data de nascimento. */

package ex2;

public class amigo extends Pessoa {
    private String dataDeAniversario;

    public amigo(){
        this.setDataDeAniversario("indefinido");
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }
    
}

/*Crie uma classe Conhecido, que herda Pessoa, e possui um email.
▶ crie um construtor que não recebe parâmetros de entrada, e inicializa o e-mail com um valor
padrão (ÒindefinidoÓ, por exemplo).
▶ crie os métodos de acesso para este atributo. */

package ex2;

public class Conhecido extends Pessoa {
    private String email;

    public Conhecido(){
        this.setEmail("indefinido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*8. Crie agora, uma classe Agenda, que possui pessoas (em um array) e dois atributos que
controlam: a quantidade de amigos e a quantidade de conhecidos.
▶ crie um construtor que recebe por parâmetro a quantidade de pessoas que a agenda terá, e
inicializa o array de Pessoa. Neste construtor, inicialize todas as posições do array criando
ALEATORIAMENTE um Conhecido ou um Amigo
utilize o comando 1 + (int) (Math.random() * 2) para sortear valores entre 1 e 2. Se o valor
encontrado for 1, crie um Amigo. Se o valor encontrado for 2, crie um Conhecido.
▶ Crie os métodos GET para todos os atributos da classe Agenda.
▶ crie um método chamado addInformacoes, que não recebe parâmetros de entrada. Para cada
Pessoa na agenda, peça para o usuário digitar (via teclado) as informações cabíveis para cada
tipo de Pessoa, e acesse os métodos SET para atribuir as informações.
▶ crie um método chamado imprimeAniversários, que imprime os aniversários de todos os
amigos que estão armazenados na agenda.
▶ crie um método chamado imprimeEmail, que imprime os e-mails de todos os conhecidos que
estão armazenados na agenda.*/

package ex2;
import java.util.Random;
import java.util.Scanner;

public class Agenda {
    private int qntAmigos;
    private int qntConhecidos;
    private int qntPessoas;
   
    Pessoa[] pessoas;
    Scanner ler = new Scanner(System.in);
    Random aleatorio = new Random();

    public Agenda(int qntPessoas){
        this.pessoas = new Pessoa[qntPessoas];
        this.setQntPessoas(qntPessoas);
        
        for(int i=0; i<getQntPessoas();i++){
            int valor = aleatorio.nextInt(2) + 1;
            
            if(valor==1){
                amigo amigos = new amigo();
                this.setPessoas(amigos,i);
            } else{
                if(valor==2){
                    Conhecido conhecidos = new Conhecido();
                    this.setPessoas(conhecidos, i);
                }
            }
        }
    }

    public Pessoa getPessoas( int i) {
        return pessoas[i];
    }
    public void setPessoas(Pessoa pessoas, int i) {
        this.pessoas[i] = pessoas;
    } 
    public int getQntPessoas() {
        return qntPessoas;
    }
    public void setQntPessoas(int qntPessoas) {
        this.qntPessoas = qntPessoas;
    }
    public int getQntAmigos() {
        return qntAmigos;
    }
    public void setQntAmigos(int qntAmigos) {
        this.qntAmigos = qntAmigos;
    }
    public int getQntConhecidos() {
        return qntConhecidos;
    }
    public void setQntConhecidos(int qntConhecidos) {
        this.qntConhecidos = qntConhecidos;
    }

    public void addInformacoes(){
        for(int i=0; i<this.getQntPessoas(); i++){
            if(pessoas[i] instanceof amigo){
                amigo amigos =(amigo) pessoas[i];
                System.out.println("Adicione o nome da Pessoa: ");
                amigos.setNome(ler.nextLine());
                System.out.println("Adicione o aniversario da Pessoa: ");
                amigos.setDataDeAniversario(ler.nextLine());
                System.out.println("Adicione a idade da Pessoa: ");
                amigos.setIdade(ler.nextInt());
                String aux= ler.nextLine();
            } else{
                if(pessoas[i] instanceof Conhecido){
                    Conhecido conhecidos =(Conhecido) pessoas[i];
                    System.out.println("Adicione o nome da Pessoa: ");
                    conhecidos.setNome(ler.nextLine());
                    System.out.println("Adicione o email da Pessoa: ");
                    conhecidos.setEmail(ler.nextLine());
                    System.out.println("Adicione a idade da Pessoa: ");
                    conhecidos.setIdade(ler.nextInt());
                    String aux=ler.nextLine();
                }
            }
        }
    }

    public void qntAmigosConhecidos(){
        int numAmigos=0, numConhecidos=0;
        for(int i=0; i<this.getQntPessoas(); i++){
            if(pessoas[i] instanceof amigo){
                numAmigos++;
            } else{
                if(pessoas[i] instanceof Conhecido){
                    numConhecidos++;
                }
            }
        }
        System.out.println("Número de amigos: " + numAmigos + " Número de conhecidos: " + numConhecidos);
    }

    public void imprimeAniversarios(){
        System.out.println("Aniversários cadastrados:");
        for(int i=0; i<this.getQntPessoas(); i++){
            if(pessoas[i] instanceof amigo){
                amigo amigos =(amigo) pessoas[i];
                System.out.println(amigos.getNome() + " - " + amigos.getDataDeAniversario());
            }
        }
    }

    public void imprimeEmail(){
        System.out.println("Emails cadastrados:");
        for(int i=0; i<this.getQntPessoas(); i++){
            if(pessoas[i] instanceof Conhecido){
                Conhecido conhecidos =(Conhecido) pessoas[i];
                System.out.println(conhecidos.getNome()+ " - " + conhecidos.getEmail());
            }
        }
    }
}

/* 9. Crie uma classe de teste para a Agenda.
▶ peça para o usuário informar (via teclado) quantas pessoas ele deseja colocar na agenda, e
crie uma Agenda com esta informação.
▶ imprima na tela a quantidade de amigos e de conhecidos na agenda.
▶ adicione informações à agenda.
▶ imprima todos os aniversários dos amigos presentes na agenda.
▶ imprima todos os e-mails dos conhecidos armazenados na agenda. */

package ex2;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        System.out.println("A agenda terá quantas pessoas?");
        int numpessoas = ler.nextInt();

        Agenda agendas = new Agenda(numpessoas);
        agendas.qntAmigosConhecidos();
        agendas.addInformacoes();
        agendas.imprimeAniversarios();
        agendas.imprimeEmail();


    }
}
