/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.Servicos;

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

}
