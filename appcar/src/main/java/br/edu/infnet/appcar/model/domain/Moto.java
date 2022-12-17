package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;

public class Moto extends Veiculo {

    public Moto(String codigo, String nome, String cor, Integer ano, String marca, boolean primeiroDono, float valor, float quilometragem) throws ValorZeradoException {
        super(codigo, nome, cor, ano, marca, primeiroDono, valor, quilometragem);
    }

    @Override
    public float calcularValorVenda() throws QuilometragemVeiculoInvalidoException {
        return 0;
    }
}
