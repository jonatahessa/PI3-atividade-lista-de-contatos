package br.senac.tads.pi3.Classes;

import java.sql.Date;

/**
 *
 * @author jonat
 */
public class Contato {

    private int idContato;
    private String nomeContato;
    private String telefoneContato;
    private String celularContato;
    private String emailContato;
    private String dataNascimento;
    private Date adicionadoEm;

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
    
    public String getCelularContato() {
        return celularContato;
    }

    public void setCelularContato(String CelularContato) {
        this.celularContato = CelularContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDate() {
        return adicionadoEm;
    }

    public void setAdicionadoEm(Date adicionadoEm) {
        this.adicionadoEm = adicionadoEm;
    }

    public Date getAdicionadoEm(){
        return adicionadoEm;
    }
}
