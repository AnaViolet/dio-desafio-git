package dio.listaEncadeada;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada<String> lista = new ListaEncadeada<>();

        lista.add("zero");
        lista.add("um");
        lista.add("dois");
        lista.add("tres");
        lista.add("quatro");
        lista.add("cinco");

        System.out.println(lista);
        //System.out.println("Conteúdo: " + lista.get(7)); //exception
        System.out.println("Conteúdo: " + lista.get(4));
        lista.remove(4);
        System.out.println("Tamanho: " + lista.size());
        System.out.println(lista);

    }
}
