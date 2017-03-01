package br.senac.tads.pi3.Daos;

import br.senac.tads.pi3.agenda.Contato;
import br.senac.tads.pi3.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoContato {
    public static void inserir(Contato contato)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO contato (NomeContato, TelefoneContato, EmailContato, "
                    + "DataNascimento, ContatoEnabled VALUES (?, ?, ?, ?, ?);";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getNomeContato());
            statement.setString(2, contato.getTelefoneContato());
            statement.setString(3, contato.getEmailContato());
            statement.setString(4, contato.getDataNascimento());
            statement.setString(5, "true");

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //Deleta um contato na tabela "contato" do banco de dados
     public static void deletar(int id)
            throws SQLException, Exception {
        //Monta a string de remoção de um contato no BD,
        //utilizando os dados do contato passados como parâmetro
        String sql = "UPDATE Contato SET ContatoEnabled = ?"
                + "WHERE ContatoId = ?; ";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, "false");
            statement.setString(2, ""+id);
            

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
     
     
    //Altera um cliente na tabela "cliente" do banco de dados
     public static void alterar(Contato contato, int id)
            throws SQLException, Exception {
        //Monta a string de alteracao de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Contato SET NomeContato = ?, "
                + "TelefoneContato = ?,"
                + "EmailContato = ?,"
                + "DataNascimento = ?,"
                + "WHERE ContatoId = ?;";
 
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getNomeContato());
            statement.setString(2, contato.getTelefoneContato());
            statement.setString(3, contato.getEmailContato());
            statement.setString(4, contato.getDataNascimento());
            statement.setString(5, ""+id);
            
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    } 
    
         //Pesquisa um contato na tabela "contato" do banco de dados
     public static List<Contato> pesquisar(String palavra)
            throws SQLException, Exception {

        //Monta a string de pesquisa de um contato no BD,
        //utilizando os dados do contato passados como parâmetro
        String sql = "SELECT * FROM Contato " +
                     " WHERE Contato.NomeContato LIKE ? AND Contato.ContatoEnabled = 'true';";
           
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        
        List <Contato> listaContatos = new LinkedList<>();
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + palavra + "%");
            
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            
            ResultSet result = statement.executeQuery();
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaContatos == null) {
                    listaContatos = new ArrayList<Contato>();
                }
                //Cria uma instância de Contatos e popula com os valores do BD
                Contato contato = new Contato();
                contato.setIdContato(result.getInt("IdContato"));
                contato.setNomeContato(result.getString("NomeContato"));
                contato.setTelefoneContato(result.getString("TelefoneContato"));
                contato.setEmailContato(result.getString("EmailContato"));
                contato.setDataNascimento(result.getString("DataNascimento"));

                //Adiciona a instância na lista
                listaContatos.add(contato);
            }
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaContatos;
    }  
}
