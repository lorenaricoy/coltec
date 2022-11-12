/*O InstaPet é um rede social para registrar fotos de pets (animais de estimação). Deve ser
possível cadastrar um usuário com um nome e um email. Cada usuário terá sua coleção
de fotos e de seus pets. Deve ser possível cadastrar uma foto de pet passando o email
do usuário, a URL da foto da bichinho e uma descrição. 
O sistema deve permitir:
• listar os usuários cadastrados e as fotos de um usuário específico (retornando uma lista
de urls e descrições)
• pegar a quantidade de usuários do sistema
• pegar a quantidade de fotos de um usuário
• alterar a descrição da N-ésima foto cadastrada.*/

//Classe InstaPet

class InstaPet {
    int qntUsuario, posicaoUsuario = 0;
    String aux, aux2;
    int aux3;

    Usuario [] usuario = new Usuario [qntUsuario];
    InstaPet(int qntUsuario){
        this.qntUsuario = qntUsuario;
        this.usuario = new Usuario [qntUsuario];
    }

    public void cadastra_ususario (Usuario u,String nome, String email){
        this.usuario[posicaoUsuario]=u;
        this.usuario[posicaoUsuario].setNome(nome);
        this.usuario[posicaoUsuario].setEmail(email);
        this.posicaoUsuario ++;
    }

    public void cadastra_foto(Foto f, String email, String url, String descricao){
        for (int i = 0; i< this.posicaoUsuario; i++){
            aux = usuario[i].getEmail();
            if (aux == email){
                this.usuario[i].cadastra_foto(f, url, descricao);
            }
        }
    }

    public int qnt_pets(String email){
        for (int i = 0; i< this.posicaoUsuario; i++){
            aux = this.usuario[i].getEmail();
            if (aux == email){
                aux3 = usuario[i].fotos;
            }
        }
        System.out.println("A quantidade de pets/fotos do usuário " + email + " é " + aux3);
        return aux3;
    }

    public int qnt_usuarios(){
        aux3= this.posicaoUsuario;
        System.out.println("A quantidade de usuários dessa conta é " + aux3);
        return aux3;
    }

    public void listar_pets(String email){
        for (int i = 0; i< this.posicaoUsuario; i++){
            aux = this.usuario[i].getEmail();
            if (aux == email){
                System.out.println("Os pets do usuário " + email + " são:");
                for(int j=0; j< usuario[i].fotos; j++){
                    aux = this.usuario[i].foto[j].getUrl();
                    aux2 = this.usuario[i].foto[j].getDescricao();
                    System.out.println(aux + " - " + aux2);
                }
            }
        }
    }

    public void listar_usuarios(){
        System.out.println("Os usuários no sistema são:");
        for(int j=0; j< this.posicaoUsuario; j++){
            aux2 = this.usuario[j].getEmail();
            aux = this.usuario[j].getNome();
            System.out.println(aux + " - " + aux2);
        }
    }

    public void altera_descricao(String email, int n, String descricao){
        for (int i = 0; i< this.posicaoUsuario; i++){
            aux = this.usuario[i].getEmail();
            if (aux == email){
                this.usuario[i].altera_descricao(n, descricao);
            }
        }
    }
}

//Classe Usuário

class Usuario{
    private String nome;
    private String email;
    int fotos =0, qntFotos;
    
    Foto [] foto = new Foto [qntFotos];
    Usuario (int qntMemoriaFotos){
        this.qntFotos = qntMemoriaFotos;
        this.foto = new Foto [qntFotos];
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void cadastra_foto(Foto f, String url, String descricao){
        this.foto[fotos]=f;
        this.foto[fotos].setUrl(url);
        this.foto[fotos].setDescricao(descricao);
        this.fotos ++;
    }

    public void altera_descricao(int n, String descricao1){
        this.foto[n].setDescricao(descricao1);
    }

}

//Classe Foto

class Foto {
    private String url;
    private String descricao;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    
    public void setDescricao(String descricao1) {
        this.descricao = descricao1;
    }

    public String getDescricao() {
        return descricao;
    }
}

//Classe main teste

public class teste {
    public static void main(String[] args) {
        int qntusuarios, qntpets;

        InstaPet conta = new InstaPet(4);
        Usuario lorena = new Usuario(9);
        Usuario julia = new Usuario(9);
        Foto foto1 = new Foto();
        Foto foto2 = new Foto();
        Foto fotoJulia = new Foto();

        conta.cadastra_ususario(lorena, "lorena", "lricoymartins@gmail.com");
        conta.cadastra_ususario(julia, "julia", "julialunna@gmail.com");
        conta.listar_usuarios();
        
        conta.cadastra_foto(foto1, "lricoymartins@gmail.com", "kkkkkkk", "lindo pet");
        conta.cadastra_foto(foto2, "lricoymartins@gmail.com", "hhhhhhh", "um querido");
        conta.cadastra_foto(fotoJulia, "julialunna@gmail.com", "jjjjjjj", "mel linda");
        conta.listar_pets("lricoymartins@gmail.com");
        conta.listar_pets("julialunna@gmail.com");
        
        conta.altera_descricao("lricoymartins@gmail.com", 0, "feio pet");
        conta.listar_pets("lricoymartins@gmail.com");

        qntusuarios=conta.qnt_usuarios();
        qntpets= conta.qnt_pets("lricoymartins@gmail.com");
        qntpets= conta.qnt_pets("julialunna@gmail.com");

    }
}
