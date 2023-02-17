/*1. Adicione o modificador de visibilidade (private, se necessário) para cada atributo e
método da classe Funcionario. Tente criar um Funcionario no main e modificar ou ler um
de seus atributos privados. O que acontece?
2. Crie os getters e setters necessários da sua classe Funcionario.
3. Modifique suas classes que acessam e modificam atributos de um Funcionario para
utilizar os getters e setters recém criados.
4. Faça com que sua classe Funcionario possa receber, opcionalmente, o nome do
Funcionario durante a criação do objeto. Utilize construtores para obter esse resultado.
Dica: utilize um construtor sem argumentos também, para o caso de a pessoa não querer
passar o nome do Funcionario.
5. Adicione um atributo na classe Funcionario de tipo int que se chama identificador. Esse
identificador deve ter um valor único para cada instância do tipo Funcionario. O primeiro
Funcionario instanciado tem identificador 1, o segundo 2, e assim por diante. Você deve
utilizar os recursos aprendidos aqui para resolver esse problema.
6. Crie os getters e setters da sua classe Empresa e coloque seus atributos como private.
Lembre-se de que não necessariamente todos os atributos devem ter getters e setters.
7. Como garantir que datas como 31/2/2012 não sejam aceitas pela sua classe Data?*/

//Classe Funcionario

class Funcionario2 {
    private String nome;
    private String departamento;
    private int salario;
    private static int identificador;
    private int identificador1;
    int rg;

    Funcionario2(String nome){
        this.nome = nome;
        Funcionario2.identificador =Funcionario2.identificador + 1;
        this.identificador1= Funcionario2.identificador;
    }

    public int getIdentificador(){
        return this.identificador1;
    }

    public String getNome(){
        return this.nome;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return this.departamento;
    }

    public void setsalario(int salario){
        this.salario = salario;
    }

    public int getSalario(){
        return this.salario;
    }
    Data2 funcionarios;
}
class Empresa{
    Funcionario2 [] empregados = new Funcionario2[3];
    private int cnpj;
    private int posicaoFuncionario =0;
    private int posicaoFuncionario1 =0;
    Funcionario2[] empregados1 = new Funcionario2[10];

    public void setCnpj(int cnpj){
        this.cnpj = cnpj;
    }

    public int getCnpj(){
        return this.cnpj;
    }

    public void adiciona(Funcionario2 f){

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

    public void mostraEmpregados () {
        for (int i = 0; i < 4; i ++) {
        System.out.println ("Funcionario na posicao : " + i);
        System.out.println ("Salário do funcionário: " + this.empregados1[i].getSalario());
     }
    }
}

// Classe Data

class Data2 {
    private int dia;
    private int mes;
    private int ano;

    public void setDia(int dia){
        if(dia != 31){
            this.dia = dia;
        } else{
            System.out.println("dia inserido impossível");
        }
    }
    public int getDia(){
        return this.dia;
    }

    public void setMes(int mes){
        if(mes!=12){
            this.mes = mes;
        } else{
            System.out.println("mes inserido impossível");
        }
    }
    public int getMes(){
        return this.mes;
    }

    public void setAno(int ano){
        if(ano!=2012){
            this.ano = ano;
        } else{
        String nome = this.funcionarios.getNome();
        System.out.println("ano inserido impossível para: " + nome);
        }
    }
    public int getAno(){
        return this.ano;
    }

    Funcionario2 funcionarios;
}

//Classe main de teste

public class testeConstrutor {
    public static void main(String[] args) {

        Funcionario2 f2 = new Funcionario2("lorena");
        Funcionario2 f3 = new Funcionario2("leandro");
        Data2 data = new Data2();
        Data2 data1 = new Data2();
        f2.funcionarios = data;
        f3.funcionarios = data1;

        int total = f2.getIdentificador();
        System.out.println(total);

        int total1 = f3.getIdentificador();
        System.out.println(total1);

        f2.funcionarios.setDia(31);
        f3.funcionarios.setDia(24);
        f2.funcionarios.setMes(12);
        f3.funcionarios.setMes(03);
        f2.funcionarios.setAno(2012);
        f3.funcionarios.setAno(03);

        int dia1 = f2.funcionarios.getDia();
        int dia2 = f3.funcionarios.getDia();
        int mes1 = f2.funcionarios.getMes();
        int mes2 = f3.funcionarios.getMes();
        int ano1 = f2.funcionarios.getAno();
        int ano2 = f3.funcionarios.getAno();

        String nome1 = f2.getNome();
        String nome2 = f3.getNome();
        System.out.println(nome1);
        System.out.println(nome2);

        System.out.println("data f2: " + dia1 + "/"+ mes1 + "/" +ano1);
        System.out.println("data f3: " + dia2 + "/"+ mes2 + "/" +ano2);
    }
}
