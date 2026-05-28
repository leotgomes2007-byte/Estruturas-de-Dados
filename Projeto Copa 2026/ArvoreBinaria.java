public class ArvoreBinaria {
    private class No {
        Figura figura;
        No esquerdo, direito;

        No(Figura figura) {
            this.figura = figura;
        }
    }

    private No raiz;

    public void inserir(Figura novaFigura) {
        raiz = inserirRec(raiz, novaFigura);
    }

    private No inserirRec(No no, Figura novaFigura) {
        if (no == null) {
            return new No(novaFigura);
        }

        int comp = novaFigura.compareTo(no.figura);
        if (comp < 0) {
            no.esquerdo = inserirRec(no.esquerdo, novaFigura);
        } else if (comp > 0) {
            no.direito = inserirRec(no.direito, novaFigura);
        } else {
            // Se a figurinha já existe na árvore, apenas soma a quantidade
            no.figura.setQuantidade(no.figura.getQuantidade() + novaFigura.getQuantidade());
        }
        return no;
    }

    public void listarInOrdem() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        listarRec(raiz);
    }

    private void listarRec(No no) {
        if (no != null) {
            listarRec(no.esquerdo);
            System.out.println(no.figura);
            listarRec(no.direito);
        }
    }

    // Busca se uma figurinha específica existe na árvore
    public boolean contem(Figura f) {
        return buscarRec(raiz, f) != null;
    }

    private Figura buscarRec(No no, Figura f) {
        if (no == null) return null;
        
        int comp = f.compareTo(no.figura);
        if (comp == 0) return no.figura;
        return comp < 0 ? buscarRec(no.esquerdo, f) : buscarRec(no.direito, f);
    }
}
