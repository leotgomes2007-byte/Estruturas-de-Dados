import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
 
public class Principal {
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
 
        List<Aluno> lista = new ArrayList<Aluno>();
        String alunoFile = "alunos.csv";
 
        try {
            // Leitura do CSV e passagem dos valores para a lista de objetos Aluno
            BufferedReader leitor = new BufferedReader(new FileReader(alunoFile));
 
            String linha;
            boolean primeiraLinha = true;
 
            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) { primeiraLinha = false; continue; }
 
                String[] dados = linha.split(","); // vetor temporário com os campos separados por ","
                Aluno aluno = new Aluno(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]));
                lista.add(aluno);
            }
            leitor.close();
 
            // Ordena por ano de ingresso usando o atributo AnoIngresso
            Collections.sort(lista, (a, b) -> Integer.compare(a.AnoIngresso, b.AnoIngresso));
 
            System.out.println("--Lista ordenada por Ano de Ingresso--");
            for (Aluno a : lista) {
                System.out.println(a);
            }
 
            // Busca por nome exato usando o equals definido na classe Aluno
            System.out.println("\nDigite o nome de um aluno que deseja procurar na lista:");
            String nomeBusca = teclado.nextLine();
 
            boolean encontrado = false;
            for (Aluno a : lista) {
                Aluno buscado = new Aluno(nomeBusca, "", "", 0);
                if (a.equals(buscado)) { // usa o equals que compara pelo Nome
                    System.out.println("Aluno Encontrado");
                    System.out.println("--Dados do Aluno--");
                    System.out.println(a);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Aluno não Encontrado");
            }
 
            // Contagem por ano usando dois vetores paralelos
            String[] anos     = new String[lista.size()];
            int[]    contagem = new int[lista.size()];
            int totalAnos = 0; // controla quantos anos diferentes foram encontrados
 
            for (Aluno a : lista) {
                boolean achou = false; // verifica se o ano do aluno já está no vetor
                for (int i = 0; i < totalAnos; i++) {
                    if (anos[i].equals(String.valueOf(a.AnoIngresso))) {
                        contagem[i]++; // incrementa a contagem do ano encontrado
                        achou = true;
                        break;
                    }
                }
                if (!achou) { // ano ainda não registrado: adiciona no vetor e inicia contagem em 1
                    anos[totalAnos]     = String.valueOf(a.AnoIngresso);
                    contagem[totalAnos] = 1;
                    totalAnos++;
                }
            }
 
            System.out.println("\nAlunos por ano:");
            for (int i = 0; i < totalAnos; i++) {
                System.out.println(anos[i] + ": " + contagem[i]);
            }
 
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
