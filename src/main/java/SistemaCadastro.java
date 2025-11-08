import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();

        CadastroRepository repository = new CadastroRepository();

        // Cadastrar uma pessoa
        Cadastro enricao = new Cadastro("Enrico Massariol", 20, 5); // id não importa
        repository.incluir(enricao);

        // Alterar os dados de uma pessoa pelo id
        // Cadastro maria = new Cadastro("Maria", 19, 5); // precisa ter alguém com o id cadastrado
        // repository.alterar(maria);

        // Apagar pelo ID
        // repository.excluir(5); // precisa ter alguém com o ID cadastrado

        // Listar os cadastrados
        List<Cadastro> cadastros = repository.listar();
        for(Cadastro c: cadastros){
            System.out.printf("Id: %d Nome: %s Idade: %d\n", c.getId(), c.getNome(), c.getIdade());
        }

        // Achar alguém pelo id
        Integer id = 1;
        Cadastro alguem = repository.buscar(id);
        if(alguem != null){
            System.out.printf("\nEncontrado(a) pelo Id: %d - Nome: %s - Idade: %d\n", id, alguem.getNome(), alguem.getIdade());
        } else {
            System.out.printf("\nNão foi possível encontrar alguém com o id: %d\n", id);
        }

        // Achar alguém pelo nome
        String nome = "Letícia Carneiro";
        alguem = repository.buscarPorNome(nome);
        if(alguem != null){
            System.out.printf("\nEncontrado(a) pelo nome: %s - Id: - %d Idade: %d\n", nome, alguem.getId(), alguem.getIdade());
        } else {
            System.out.printf("\nNão foi possível encontrar alguém com o nome: %s\n", nome);
        }

        // Apagar alguém pelo nome
        repository.excluirPeloNome("Enrico Massariol");
    }
}
