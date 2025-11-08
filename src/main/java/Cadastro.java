public class Cadastro {
    private String nome;
    private Integer idade;
    private Integer id;

    public Cadastro(String nome, Integer idade, Integer id){
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
