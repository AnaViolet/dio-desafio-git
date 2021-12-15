package dio.fila;

public class Main {
    public static void main(String[] args) {

        Fila minhaFila = new Fila();

        minhaFila.enqueue(new No("primeiro"));
        minhaFila.enqueue(new No("segundo"));
        minhaFila.enqueue(new No("terceiro"));
        minhaFila.enqueue(new No("quarto"));

        System.out.println(minhaFila);

        minhaFila.dequeue();
        minhaFila.enqueue((new No("último")));
        System.out.println(minhaFila);

        System.out.println(minhaFila.first());

    }
}
