import java.util.TreeSet;

public class Arvore {
    public static void main(String[] args){
        TreeSet<String> arvore = new TreeSet<>();
        arvore.add("abacaxi");
        arvore.add("Uva");
        arvore.add("Pera");
        arvore.add("Manga");

        System.out.println("Elementos na TreeSet");
            for(String fruta : arvore){
                System.out.println(fruta);
            }

            if(arvore.contains("Caqui")){
                System.out.println("A TreeSet contém caqui");
            }else{
                System.out.println("A treeSet não contém caqui");
            }
            arvore.clear();

            System.out.println("Tamanho do TreeSet após limpar"+arvore.size());
    }
}
