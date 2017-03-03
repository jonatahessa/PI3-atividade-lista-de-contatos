/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.Servicos;

import br.senac.tads.pi3.Classes.Contato;
import br.senac.tads.pi3.Daos.DaoContato;
import br.senac.tads.pi3.Exceptions.AgendaException;
import br.senac.tads.pi3.Exceptions.DataSourceException;
import java.util.List;

/**
 *
 * @author jonat
 */
public class ServicoContato {

    public boolean verificarNomeContato(String nomeContato) {
        boolean verificarNomeContato = true;
        if (nomeContato == null || nomeContato.equals("")) {
            verificarNomeContato = false;
        }
        return verificarNomeContato;
    }

    public boolean verificarEmailContato(String emailContato) {
        boolean verificarEmailContato = true;
        if (emailContato == null || emailContato.equalsIgnoreCase("")) {
            verificarEmailContato = false;
        }
        return verificarEmailContato;
    }

    public boolean verificarDataNascimento(String dataNascimento) {
        boolean verificarDataNascimento = true;
        if (dataNascimento.equals("  /  /    ")) {
            verificarDataNascimento = false;
        }
        return verificarDataNascimento;
    }

    public boolean verificarTelefoneContato(String telefoneContato) {
        boolean verificarTelefoneContato = true;
        if (telefoneContato == null || telefoneContato.equals("    -    ")) {
            verificarTelefoneContato = false;
        }
        return verificarTelefoneContato;
    }

    public static void removerContato(int id)
            throws AgendaException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão da despesa informada
            DaoContato.deletar(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void adicionarContato(Contato contato)
            throws AgendaException, DataSourceException {
        try {
            //Solicita ao DAO a inserção da despesa informada
            DaoContato.inserir(contato);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void alterarContato(Contato contato, int id)
            throws AgendaException, DataSourceException {
        try {
            //Solicita ao DAO a alteração da despesa informada
            DaoContato.alterar(contato, id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static List<Contato> procurarContato(int id)
            throws AgendaException, DataSourceException {
        try {
            //Solicita ao DAO a alteração da despesa informada
            return DaoContato.pesquisar(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}