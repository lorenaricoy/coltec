/* + Modele um funcionário usando UML. Ele deve ter o nome do funcionário, o departamento
onde trabalha, seu salário (double), a data de entrada no banco (String) e seu RG (String).
  + Transforme o modelo acima em uma classe Java. Teste-a, usando uma outra classe que
tenha o main. Você deve criar a classe do funcionário com o nome Funcionario, mas pode
nomear como quiser a classe de testes, contudo, ela deve possuir o método main.
  + Crie um método mostra(), que não recebe nem devolve parâmetro algum e simplesmente
imprime todos os atributos do nosso funcionário. Dessa maneira, você não precisa ficar
copiando e colando um monte de System.out.println() para cada mudança e teste que fizer
com cada um de seus funcionários.
  + Construa dois funcionários com o new e compare-os com o ==. E se eles tiverem os
mesmos atributos? Para isso você vai precisar criar outra referência.
  + Crie duas referências para o mesmo funcionário, compare-os com o ==. Tire suas
conclusões. Para criar duas referências pro mesmo funcionário.
  + Em vez de utilizar uma String para representar a data, crie uma outra classe, chamada
Data. Ela possui 3 campos int, para dia, mês e ano. Faça com que seu funcionário passe a
usá-la. (é parecido com o último exemplo, em que a Conta passou a ter referência para
um Cliente).
  + Modifique seu método mostra para que ele imprima o valor da dataDeEntrada daquele
Funcionario.*/

//Classe Funcionario

class Funcionario {
    String nome;
    String departamento;
    int salario;
    int rg;

    void mostra(){
        System.out.println("Nome:" + this.nome);
        System.out.println("Departamento:" + this.departamento);
        System.out.println("Dia:" + this.funcionarios.dia);
        System.out.println("Mês:" + this.funcionarios.mes);
        System.out.println("Ano:" + this.funcionarios.ano);
        System.out.println("Salario:" + this.salario);
        System.out.println("RG:" + this.rg);
    }

    Data funcionarios;
}

//Classe main de teste para o método mostra

public class imprimeFuncionarios {
    public static void main(String[] args) {
        Data data = new Data();
        Funcionario funcionario = new Funcionario();
        funcionario.funcionarios = data;

        funcionario.nome = "Lorena";
        funcionario.departamento = "Administrativo";
        funcionario.funcionarios.dia = 01;
        funcionario.funcionarios.mes = 06;
        funcionario.funcionarios.ano = 2021;
        funcionario.salario = 40000;
        funcionario.rg = 2021951442;
 
        funcionario.mostra();
 
    }
}

//Classe para comparar

public class comparacao {
    public static void main(String[] args) {
        new Funcionario();
        Funcionario funcionario1 = new Funcionario();
        Funcionario funcionario2 = new Funcionario();
        Funcionario funcionario3 = funcionario1; // esse objeto terá a referência igual a do objeto 1
 
        // inicialização do objeto 1
        funcionario1.nome = "Lorena";
        funcionario1.departamento = "Administrativo";
        funcionario1.salario = 40000;
        funcionario1.rg = 2021951442;

        //inicialização do objeto 2
        funcionario2.nome = "Lorena";
        funcionario2.departamento = "Administrativo";
        funcionario2.salario = 40000;
        funcionario2.rg = 2021951442;
 
        /*comparação dos objetos 1 e 2, de atributos iguais porém referências distintas
        eles serão diferentes pois suas referências não são as mesmas*/
        if(funcionario2 == funcionario1){
            System.out.println("Funcionarios 1 e 2 iguais!");
        } else{
            System.out.println("Funcionarios 1 e 2 diferentes!");
        }


        /*comparação dos objetos 1 e 3, de referências iguais
        eles serão iguais pois suas referências são as mesmas*/
        if(funcionario3 == funcionario1){
            System.out.println("Funcionarios 1 e 3 iguais!");
        } else{
            System.out.println("Funcionarios 1 e 3 diferentes!");
        }

    }
}

// Classe Data

class Data {
    int dia;
    int mes;
    int ano;
}



