import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Clima> lista = new ArrayList<>();
        String nomeBase = "base.csv";

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {
            
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                String[] dadosLinha = linha.split(",");
                
                Clima objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

            if (!lista.isEmpty()) {
                Clima maior = lista.get(0); 
                for (Clima item : lista) {
                    double tempAtual = Double.parseDouble(item.temperatura);
                    double tempMaior = Double.parseDouble(maior.temperatura);

                    if (tempAtual > tempMaior) {
                        maior = item;
                    }
                }

                System.out.println("\n>>> Registro de Maior Temperatura Encontrado:");
                System.out.println(maior);
            }
            // ----------------------------------------------

        } catch (Exception e) {
            System.err.println("Ocorreu algum erro... " + e.getMessage());
        }
    }
}

