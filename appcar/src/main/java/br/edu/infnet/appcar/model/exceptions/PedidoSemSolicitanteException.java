package br.edu.infnet.appcar.model.exceptions;

public class PedidoSemSolicitanteException extends Exception {
    private static final long serialVersionUID = 1L;

    public PedidoSemSolicitanteException(String mensagem) {
        super(mensagem);
    }

}
