package br.edu.infnet.appcar.model.tests;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Pedido;
import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.domain.Veiculo;
import br.edu.infnet.appcar.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.appcar.model.exceptions.PedidoSemVeiculoException;
import br.edu.infnet.appcar.model.exceptions.SolicitanteInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArquivoTest {

    public static void main(String[] args) throws IOException, SolicitanteInvalidoException, PedidoSemVeiculoException, PedidoSemSolicitanteException, ValorZeradoException {
        try {
            String arq = "pedidos.txt";

            try {
                FileReader fileReader = new FileReader(arq);
                BufferedReader read = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter("out_" + arq);
                BufferedWriter writing = new BufferedWriter(fileWriter);

                String line = read.readLine();
                String[] campos = null;

                List<Veiculo> veiculos = new ArrayList<>();
                Pedido pedido = null;

                while(Objects.nonNull(line)) {
                    campos = line.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "P":
                            try {
                                pedido = new Pedido(new Solicitante(campos[5], campos[3], campos[4]), veiculos);
                                pedido.setDescricao(campos[1]);
                                pedido.setWeb(Boolean.parseBoolean(campos[2]));
                            } catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemVeiculoException e) {
                                System.out.println("[ERRO] " + e.getMessage());
                            }
                            break;

                        case "CAM":
                            try {
                                Caminhao caminhao = new Caminhao(campos[1],
                                                                 campos[2],
                                                                 campos[3],
                                                                 Integer.parseInt(campos[4]),
                                                                 campos[5],
                                                                 Boolean.parseBoolean(campos[6]),
                                                                 Float.parseFloat(campos[7]),
                                                                 Float.parseFloat(campos[8]));

                                caminhao.setCarga(Float.parseFloat(campos[9]));
                            } catch (ValorZeradoException e) {
                                System.out.println("[ERRO] " + e.getMessage());
                            }
                            break;
                        case "CAR":
                            break;
                        case "M":
                            break;

                        default:
                            System.out.println("Registrto inválido!!!");
                            break;
                    }

                    line = read.readLine();
                }

                writing.write(Objects.requireNonNull(pedido).obterLinha());

                writing.close();
                read.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("Processamento realizado com sucesso!!!");
        }
    }
}
