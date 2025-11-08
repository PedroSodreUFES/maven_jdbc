import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository(){
        conexao = FabricaConexao.getConexao();
    }

    /**
    Inclui um cadastro no banco de dados
    @author Pedro Sodré Malini
    @param cadastro Um objeto cadastro contendo nome e idade
     */
    public void incluir(Cadastro cadastro){
        try {
            String insertSQL = "INSERT INTO public.aluno (nome, idade) VALUES(?, ?);";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.execute();
            System.out.printf("Cadastro de %s realizado com sucesso!\n\n", cadastro.getNome());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro){
        try{
            String insertSQL = "UPDATE public.aluno SET nome=?, idade=? WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.execute();
            System.out.printf("Cadastro de %s atualizado com sucesso!\n", cadastro.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Integer id){
        try{
            String insertSQL = "DELETE FROM public.aluno WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setInt(1, id);
            pst.execute();
            System.out.printf("Cadastro de ID: %d excluído com sucesso!\n", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        List<Cadastro> lista = new ArrayList();
        try{
            String insertSQL = "SELECT id, nome, idade FROM public.aluno;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            ResultSet result = pst.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro(nome, idade, id);

                lista.add(cadastro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cadastro buscar(Integer id){
        Cadastro cadastro = null;
        try{
            String insertSQL = "SELECT nome, idade FROM public.aluno WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()){
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");
                cadastro = new Cadastro(nome, idade, id);
                return cadastro;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cadastro;
    }

    public Cadastro buscarPorNome(String nome){
        Cadastro cadastro = null;
        try{
            String insertSQL = "SELECT id, nome, idade FROM public.aluno WHERE nome=?;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setString(1, nome);
            ResultSet result = pst.executeQuery();
            if (result.next()){
                Integer id = result.getInt("id");
                Integer idade = result.getInt("idade");
                cadastro = new Cadastro(nome, idade, id);
                return cadastro;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cadastro;
    }

    public void excluirPeloNome(String nome){
        try{
            String insertSQL = "DELETE FROM public.aluno WHERE nome=?;";
            PreparedStatement pst = conexao.prepareStatement(insertSQL);
            pst.setString(1, nome);
            pst.execute();
            System.out.printf("\nCadastro de Nome: %s excluído com sucesso!\n", nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
