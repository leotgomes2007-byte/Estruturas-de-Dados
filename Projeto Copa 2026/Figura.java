import java.io.Serializable;

public class Figura implements Comparable<Figura> {
    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    // Getters e Setters
    public String getNomeSelecao() { return nomeSelecao; }
    public int getNumeroFigura() { return numeroFigura; }
    public String getDescricao() { return descricao; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public boolean isRara() { return rara; }

    // Converte o objeto para linha de CSV
    public String toCSV() {
        return nomeSelecao + ";" + numeroFigura + ";" + descricao + ";" + quantidade + ";" + rara;
    }

    // Reconstrói o objeto a partir de uma linha CSV
    public static Figura fromCSV(String linha) {
        String[] partes = linha.split(";");
        return new Figura(partes[0], Integer.parseInt(partes[1]), partes[2], Integer.parseInt(partes[3]), Boolean.parseBoolean(partes[4]));
    }

    @Override
    public int compareTo(Figura outra) {
        int compSelecao = this.nomeSelecao.compareToIgnoreCase(outra.nomeSelecao);
        if (compSelecao != 0) {
            return compSelecao;
        }
        return Integer.compare(this.numeroFigura, outra.numeroFigura);
    }

    @Override
    public String toString() {
        return String.format("[%s #%d] %s (Qtd: %d)%s", 
                nomeSelecao, numeroFigura, descricao, quantidade, rara ? " - RARA★" : "");
    }
}
