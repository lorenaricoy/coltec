/*1. Volte ao nosso sistema de Funcionario e crie uma classe Empresa dentro do mesmo
arquivo .java. A Empresa tem um nome, cnpj e uma referência a um array de Funcionario,
além de outros atributos que você julgar necessário.
2. A Empresa deve ter um método adiciona, que recebe uma referência a Funcionario
como argumento e guarda esse funcionário.
3. Crie uma classe TestaEmpresa que possuirá um método main. Dentro dele crie algumas
instâncias de Funcionario e passe para a empresa pelo método adiciona.
4. Percorra o atributo empregados da sua instância da Empresa e imprima os salários de
todos seus funcionários. Para fazer isso, você pode criar um método chamado
mostraEmpregados dentro da classe Empresa.
5. Caso o array já esteja cheia no momento de adicionar um outro funcionário, criar um
novo maior e copiar os valores. Isto é, fazer a realocação já que java não tem isso: um
array nasce e morre com o mesmo length.*/

//Classe Funcionario

class Funcionario {
    String nome;
    String departamento;
    int salario;
    int rg;
}

//Classe Empresa

class Empresa{
    Funcionario [] empregados = new Funcionario[3];
    int cnpj;
    int posicaoFuncionario =0;
    int posicaoFuncionario1 =0;
    Funcionario[] empregados1 = new Funcionario[10];

    void adiciona(Funcionario f){

        if(posicaoFuncionario<3){
            this.empregados[posicaoFuncionario] = f;
            posicaoFuncionario++;
        } else{

        if(posicaoFuncionario>=3 && posicaoFuncionario1<3){
            for(int i=0;i<posicaoFuncionario;i++){
                this.empregados1[i] = this.empregados[i];
                posicaoFuncionario1++;
            }
        }  if(posicaoFuncionario>=3 && posicaoFuncionario1>=3){
                this.empregados1[posicaoFuncionario1] = f;
                posicaoFuncionario1++;
            }
        }
    }

    void mostraEmpregados () {
        for (int i = 0; i < 4; i ++) {
        System.out.println ("Funcionario na posicao : " + i);
        System.out.println ("Salário do funcionário: " + this.empregados1[i].salario);
     }
    }
}

//Classe main de teste

public class TestaMetodo {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        Funcionario funcionario2 = new Funcionario();
        Funcionario funcionario3 = new Funcionario();
        Funcionario funcionario4 = new Funcionario();
        Empresa empregado = new Empresa();

        funcionario1.nome = "Lorena";
        funcionario1.departamento = "Administrativo";
        funcionario1.salario = 40000;
        funcionario1.rg = 2021951442;

        funcionario2.nome = "Leandro";
        funcionario2.departamento = "Secretario";
        funcionario2.salario = 10;
        funcionario2.rg = 2021951442;

        funcionario3.nome = "Igor";
        funcionario3.departamento = "Estagiario";
        funcionario3.salario = 20;
        funcionario3.rg = 2021951442;

        funcionario4.nome = "Julia";
        funcionario4.departamento = "Socia";
        funcionario4.salario = 2000;
        funcionario4.rg = 2021951442;
 
        empregado.adiciona(funcionario1);
        empregado.adiciona(funcionario2);
        empregado.adiciona(funcionario3);
        empregado.adiciona(funcionario4);

        empregado.mostraEmpregados();
    }
}


