package dio.pilha;

public class Main {
    public static void main(String[] args) {

        Pilha minhaPilha = new Pilha();

        minhaPilha.push(new No(1)); //adiciona novo elemento
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        System.out.println(minhaPilha);
        minhaPilha.pop(); //tira o primeiro elemento
        System.out.println(minhaPilha.top());//retorna o primeiro elemento
        System.out.println(minhaPilha);
    }
}
