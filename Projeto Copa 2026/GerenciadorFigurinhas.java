import java.io.*;
import java.util.Scanner;

public class GerenciadorFigurinhas {
    private static final String CSV_REPETIDAS = "figuras_repetidas_pessoais.csv";
    private static final String CSV_DESEJADAS = "figuras_desejadas_pessoais.csv";

    private static ArvoreBinaria arvoreRepetidasPessoais = new ArvoreBinaria();
    private static ArvoreBinaria arvoreDesejadasPessoais = new ArvoreBinaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialização automática carregando os arquivos existentes
        carregarArquivoPessoal(CSV_REPETIDAS, arvoreRepetidasPessoais);
        carregarArquivoPessoal(CSV_DESEJADAS, arvoreDesejadasPessoais);

        int opcao = 0;
        do {
            System.out.println("\n=== MENU GERENCIADOR DE FIGURINHAS COPA 2026 ===");
            System.out.println("1 - Cadastrar figuras repetidas pessoais");
            System.out.println("2 - Listar figuras repetidas pessoais");
            System.out.println("3 - Cadastrar figuras desejadas pessoais");
            System.out.println("4 - Listar figuras desejadas pessoais");
            System.out.println("5 - Carregar figuras repetidas OUTRO (Match com suas Desejadas)");
            System.out.println("6 - Carregar figuras desejadas OUTRO (Match com suas Repetidas)");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> cadastrarFigura(CSV_REPETIDAS, arvoreRepetidasPessoais);
                    case 2 -> {
                        System.out.println("\n--- Suas Figuras Repetidas ---");
                        arvoreRepetidasPessoais.listarInOrdem();
                    }
                    case 3 -> cadastrarFigura(CSV_DESEJADAS, arvoreDesejadasPessoais);
                    case 4 -> {
                        System.out.println("\n--- Suas Figuras Desejadas ---");
                        arvoreDesejadasPessoais.listarInOrdem();
                    }
                    case 5 -> processarArquivoOutro(true);
                    case 6 -> processarArquivoOutro(false);
                    case 7 -> System.out.println("Saindo do programa... Boa sorte nas trocas!");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        } while (opcao != 7);
    }

    private static void cadastrarFigura(String nomeArquivo, ArvoreBinaria arvore) {
        System.out.println("\n--- Cadastro de Figura ---");
        System.out.print("Nome da Seleção: ");
        String selecao = scanner.nextLine();
        System.out.print("Número da Figura: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição (Jogador/Brasão/Bandeira): ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());
        System.out.print("É rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(scanner.nextLine());

        Figura nova = new Figura(selecao, numero, descricao, qtd, rara);
        
        arvore.inserir(nova);

        try (FileWriter fw = new FileWriter(nomeArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(nova.toCSV());
            System.out.println("Figura salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo CSV: " + e.getMessage());
        }
    }

    private static void carregarArquivoPessoal(String nomeArquivo, ArvoreBinaria arvore) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    arvore.inserir(Figura.fromCSV(linha));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void processarArquivoOutro(boolean ehRepetidaOutro) {
        System.out.print("\nDigite o nome do arquivo CSV da outra pessoa (ex: outro.csv): ");
        String nomeArquivo = scanner.nextLine();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        System.out.println("\n--- Figuras do Arquivo Externo ---");
        ArvoreBinaria arvoreOutro = new ArvoreBinaria();
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    Figura f = Figura.fromCSV(linha);
                    System.out.println(f);
                    arvoreOutro.inserir(f);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        System.out.println("\n--- MATCHES ENCONTRADOS DE INTERESSE DE TROCA ---");
        if (ehRepetidaOutro) {
            buscarMatches(arvoreOutro, arvoreDesejadasPessoais);
        } else {
            buscarMatches(arvoreOutro, arvoreRepetidasPessoais);
        }
    }

    private static void buscarMatches(ArvoreBinaria arvoreOrigem, ArvoreBinaria arvoreBaseComparacao) {
        System.out.println("Verificando combinações possíveis...");
        arvoreOrigem.verificarMatchesContra(arvoreBaseComparacao);
    }
}
