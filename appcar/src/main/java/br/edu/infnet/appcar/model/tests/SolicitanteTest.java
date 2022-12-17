package br.edu.infnet.appcar.model.tests;

import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.exceptions.SolicitanteInvalidoException;

public class SolicitanteTest {
    public static void main(String[] args) {

        try {
            Solicitante s1 = new Solicitante("Pedrinho", "12300045600", "pedrinho@pedrinho.com.br");
            System.out.println(s1);
        } catch (SolicitanteInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Solicitante s2 = new Solicitante(null, "12345678900", "jo@jo.com.br");
            System.out.println(s2);
        } catch (SolicitanteInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Solicitante s3 = new Solicitante("Larissinha", null, "lari@lari.com");
            System.out.println(s3);
        } catch (SolicitanteInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Solicitante s4 = new Solicitante("Amandinha", "12345678900", null);
            System.out.println(s4);
        } catch (SolicitanteInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }
}
