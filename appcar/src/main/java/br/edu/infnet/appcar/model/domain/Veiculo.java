package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;
import lombok.Getter;

@Getter
public abstract class Veiculo {

    private String codigo;
    private String nome;
    private String cor;
    private Integer ano;
    private String marca;
    private boolean primeiroDono;
    private float valor;
    private float quilometragem;

    public Veiculo(String codigo, String nome, String cor, Integer ano, String marca, boolean primeiroDono, float valor, float quilometragem) throws ValorZeradoException {
        if(valor == 0) {
            throw new ValorZeradoException("O valor do veículo está zerado!");
        }

        if(valor < 0) {
            throw new ValorZeradoException("O Valor do veículo está negativo!");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.marca = marca;
        this.primeiroDono = primeiroDono;
        this.valor = valor;
        this.quilometragem = quilometragem;
    }

    public abstract float calcularValorVenda() throws QuilometragemVeiculoInvalidoException;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(codigo);
        sb.append(" | ");
        sb.append(nome);
        sb.append(" | ");
        sb.append(cor);
        sb.append(" | ");
        sb.append(ano);
        sb.append(" | ");
        sb.append(marca);
        sb.append(" | ");
        sb.append(primeiroDono);
        sb.append(" | ");
        sb.append(valor);
        sb.append(" | ");
        sb.append(quilometragem);

        return sb.toString();
    }
}
