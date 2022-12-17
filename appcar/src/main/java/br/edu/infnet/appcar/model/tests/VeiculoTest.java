package br.edu.infnet.appcar.model.tests;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;

public class VeiculoTest {

    public static void main(String[] args) {
        try {
            Caminhao c1 = new Caminhao("1", "1113", "Vermelho", 1950, "Mercedes", false,15000, 200000);
            c1.setCarga(10000);
            System.out.println(c1);
            System.out.println("Valor de Venda = R$ " + c1.calcularValorVenda());
        } catch (ValorZeradoException | QuilometragemVeiculoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Caminhao c2 = new Caminhao("2" ,"F-14000", "Branco", 1980, "FORD", true,20000, 0);
            c2.setCarga(11000);
            System.out.println(c2);
            System.out.println("Valor de vendas = R$ " + c2.calcularValorVenda());
        } catch (ValorZeradoException | QuilometragemVeiculoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }
}
