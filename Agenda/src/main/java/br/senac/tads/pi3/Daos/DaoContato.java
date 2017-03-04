package br.senac.tads.pi3.Daos;

import br.senac.tads.pi3.Classes.Contato;
import br.senac.tads.pi3.Exceptions.AgendaException;
import br.senac.tads.pi3.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoContato {

    public static void inserir(Contato contato)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO agenda (contatoNome, contatoTelefone, "
                + "contatoEmail, dataNasc, adicionadoEm, contatoEnabled) VALUES (?, ?, ?, ?, ?, ?);";

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
            statement.setString(5, contato.getAdicionadoEm());
            statement.setString(6, "true");

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
        String sql = "UPDATE agenda SET contatoEnabled = ?"
                + "WHERE contatoId = ?; ";

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
            statement.setString(2, "" + id);

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
        String sql = "UPDATE agenda SET contatoNome = ?, "
                + "contatoTelefone = ?, "
                + "contatoEmail = ?, "
                + "dataNasc = ?, "
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
            statement.setString(5, "" + id);

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

    //Obter o contato na tabela "contato" do banco de dados
    public static List<Contato> obterContato(int id)
            throws SQLException, Exception {

        //Monta a string de pesquisa de um contato no BD,
        //utilizando os dados do contato passados como parâmetro
        String sql = "SELECT * FROM agenda "
                + " WHERE contatoId = ? AND contatoEnabled = 'true';";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;

        List<Contato> listaContatos = new LinkedList<>();
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

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
                contato.setDataNascimento(result.getString("DataNasc"));
                contato.setAdicionadoEm(result.getString("adicionadoEm"));

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

    //Pesquisa um contato na tabela "contato" do banco de dados
    public static List<Contato> pesquisarContato(String contatoNome)
            throws SQLException, Exception {

        //Monta a string de pesquisa de um contato no BD,
        //utilizando os dados do contato passados como parâmetro
        String sql = "SELECT * FROM agenda "
                + " WHERE contatoId = ? AND contatoEnabled = 'true';";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;

        List<Contato> listaContatos = new LinkedList<>();
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, contatoNome);

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
                contato.setDataNascimento(result.getString("DataNasc"));
                contato.setAdicionadoEm(result.getString("adicionadoEm"));

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

    //Retorna todos os contatos da tabela "contato" do banco de dados
    public static List<Contato> retornarTodos()
            throws SQLException, Exception {
        //Monta a string de listagem de contatos no banco, considerando
        //apenas a coluna de ativação de contatos ("enabled")
        String sql = "SELECT * FROM agenda WHERE contatoEnabled = 'true'";

        //Lista de contatos de resultado
        List<Contato> listaContatos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
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
                contato.setAdicionadoEm(result.getString("AdicionadoEm"));

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

    public static List<Contato> executarConsulta(String sql) throws
            AgendaException, SQLException, Exception {
        //Lista de produtos de resultado
        List<Contato> listaContatos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = Conexao.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaContatos == null) {
                    listaContatos = new ArrayList<Contato>();
                }

                Contato contato = new Contato();
                contato.setIdContato(result.getInt("IdContato"));
                contato.setNomeContato(result.getString("NomeContato"));
                contato.setTelefoneContato(result.getString("TelefoneContato"));
                contato.setEmailContato(result.getString("EmailContato"));
                contato.setDataNascimento(result.getString("DataNascimento"));
                contato.setAdicionadoEm(result.getString("AdicionadoEm"));

                listaContatos.add(contato);
            }
        } finally {

            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //S
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaContatos;
    }

    //Lista todos os produtos da tabela quartos
    public static List<Contato> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        String sql = "SELECT * FROM agenda WHERE contatoEnabled = 'true'";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    public static Contato obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM agenda WHERE contatoId = ? AND "
                + "contatoEnabled = 'true';";
        PreparedStatement statement = null;
        Connection connection = null;

        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        List<Contato> listaContatos = (List<Contato>) executarConsulta(sql);

        if (listaContatos != null && listaContatos.size() > 0) {

            return listaContatos.get(0);
        }

        return null;
    }

}
