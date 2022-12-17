package br.edu.infnet.appcar.model.tests;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Pedido;
import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.domain.Veiculo;
import br.edu.infnet.appcar.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.appcar.model.exceptions.PedidoSemVeiculoException;
import br.edu.infnet.appcar.model.exceptions.SolicitanteInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;

import java.util.ArrayList;
import java.util.List;

public class PedidoTest {
    public static void main(String [] args) {

        List<Veiculo> veiculosV1 = new ArrayList<>();
        List<Veiculo> veiculosV2 = new ArrayList<>();
        List<Veiculo> veiculosV3 = new ArrayList<>();

        try {
            Caminhao c1 = new Caminhao("1", "1113", "Vermelho", 1950, "Mercedes", false,15000, 200000);
            c1.setCarga(10000);
            veiculosV1.add(c1);
            veiculosV2.add(c1);
            veiculosV3.add(c1);
        } catch (ValorZeradoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Caminhao c2 = new Caminhao("2" ,"F-14000", "Branco", 1980, "FORD",true,20000, 0);
            c2.setCarga(10000);
            veiculosV1.add(c2);
            veiculosV2.add(c2);
            veiculosV3.add(c2);
        } catch (ValorZeradoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Pedido p1 = new Pedido(new Solicitante("Pedrinho", "12300045600", "pedrinho@pedrinho.com.br"), veiculosV1);
            p1.setDescricao("Primeiro pedido");
            p1.setWeb(false);
            p1.imprimir();
        } catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Pedido p2 = new Pedido(new Solicitante("Joãozinho", "12345678900", "jo@jo.com.br"), veiculosV2);
            p2.setDescricao("Segundo pedido");
            p2.setWeb(true);
            p2.imprimir();
        } catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Pedido p3 = new Pedido(new Solicitante("Amandinha", "12345678900", "ama@ama.com"), veiculosV3);
            p3.setDescricao("Terceiro pedido");
            p3.setWeb(true);
            p3.imprimir();
        } catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Pedido p4 = new Pedido(null, veiculosV3);
            p4.setDescricao("Quarto pedido");
            p4.setWeb(true);
            p4.imprimir();
        } catch (PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Solicitante s6 = new Solicitante("Larissinha", "98765432100", "lari@lari.com");

            Pedido p6 = new Pedido(s6, null);
            p6.setDescricao("Quinto pedido");
            p6.setWeb(true);
            p6.imprimir();
        } catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }
}
