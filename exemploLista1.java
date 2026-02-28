import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Scanner;

public class exemploLista1 {

    public static void main(String[] args) {
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String nome;

            listaNomes.add("Guilherme");
            listaNomes.add("Pedro");
            listaNomes.add("Maria");

            System.out.println(listaNomes);

            if (listaNomes.size() != 0){
                System.out.println("Digite um nome: ");
                nome = teclado.Nextline();
                if(listaNomes.contains(nome)){
                listaNomes.remove(nome);
                }else{
                System.out.println("nome não localizado");
                }
                System.out.println("total de elementos" + listaNomes.size());
                System.out.println(listaNomes);
                
            }
    }
}
