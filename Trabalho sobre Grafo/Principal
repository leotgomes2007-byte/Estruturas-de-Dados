import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<>();
        String caminhoArquivo = "mapa.csv";

        // O bloco try envolve a abertura do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            
            // Correção dos parênteses do while
            while ((linha = br.readLine()) != null) {
                String[] partes = line.split(",");
                
                if (partes.length == 2) {
                    String v1 = partes[0].trim();
                    String v2 = partes[1].trim();
                    
                    // Os verificadores DEVEM ficar aqui dentro para conseguirem usar v1 e v2
                    if (!vertices.contains(v1)) {
                        vertices.add(v1);
                    }
                    if (!vertices.contains(v2)) {
                        vertices.add(v2);
                    }
                }
            }
        } catch (IOException e) { // Catch movido para o lugar correto dentro do main
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
            return;
        }

        // C maiúsculo em Collections
        Collections.sort(vertices);

        // Seu código original do Grafo segue perfeitamente aqui:
        Grafo gAssimetrico = new Grafo(vertices);
        
        // a,b
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("a"), gAssimetrico.pegarIndice("b"));
        
        // b,c
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("c"));
        
        // b,d
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("d"));
        
        // c,e
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("c"), gAssimetrico.pegarIndice("e"));

        // d,a
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("a"));

        // d,b
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("b"));

        // d,c
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("c"));

        // e,d
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("e"), gAssimetrico.pegarIndice("d"));

        gAssimetrico.mostrarMatriz();
        System.out.println();
        gAssimetrico.mostrarGrafo();
    }
}
