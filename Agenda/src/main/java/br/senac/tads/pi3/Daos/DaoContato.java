package br.senac.tads.pi3.Daos;

import br.senac.tads.pi3.agenda.Contato;
import br.senac.tads.pi3.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
