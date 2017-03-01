/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.Exceptions;
public class AgendaException extends Exception {

    /**
     * Construtor de exceções que permite informar uma mensagem *
     * @param message
     */
    public AgendaException(String message) {
        super(message);
    }
}
