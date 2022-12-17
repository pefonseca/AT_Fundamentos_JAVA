package br.edu.infnet.appcar.model.exceptions;

public class PedidoSemVeiculoException extends Exception {

    private static final long serialVersionUID = 1L;

    public PedidoSemVeiculoException(String mensagem) {
        super(mensagem);
    }
}
