package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caminhao extends Veiculo {

    private float carga;

    public Caminhao(String codigo, String nome, String cor, Integer ano, String marca, boolean primeiroDono, float valor, float quilometragem) throws ValorZeradoException {
        super(codigo, nome, cor, ano, marca, primeiroDono, valor, quilometragem);
    }

    @Override
    public float calcularValorVenda() throws QuilometragemVeiculoInvalidoException {
        if (this.getQuilometragem() > 30000) {
            return this.getValor() - 10000;
        }

        return this.getValor();
    }
}
