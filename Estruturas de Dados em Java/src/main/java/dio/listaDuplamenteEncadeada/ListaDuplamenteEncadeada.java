package dio.listaDuplamenteEncadeada;

import dio.listaEncadeada.No;

public class ListaDuplamenteEncadeada <T>{

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamLista = 0;
    }

    public int size(){ return this.tamLista; }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAux = primeiroNo;
        for(int i = 0; (i <= index) && (noAux != null); i++){
            noAux = noAux.getNoProx();
        }
        return noAux;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    //adiciona ao final
    public void add(T conteudo){
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProx(null);
        novoNo.setNoAnterior(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setNoProx(novoNo);
        }
        ultimoNo = novoNo;
        tamLista++;
    }

    public void add(T conteudo, int index){
        NoDuplo<T> noAux = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProx(noAux);

        if(novoNo.getNoProx() != null){
            novoNo.setNoAnterior(noAux.getNoAnterior());
            novoNo.getNoProx().setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo;
        } else {
            novoNo.getNoAnterior().setNoProx(novoNo);
        }
        tamLista++;
    }
    
    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProx();
            if(primeiroNo != null){
                primeiroNo.setNoAnterior(null);
            }
        }else{
            NoDuplo<T> noAux = getNo(index);
            noAux.getNoAnterior().setNoProx(noAux.getNoProx());
            if(noAux != ultimoNo){
                noAux.getNoProx().setNoAnterior(noAux.getNoAnterior());
            } else{
                ultimoNo = noAux;
            }
        }
        tamLista--;
    }

    @Override
    public String toString() {
        NoDuplo<T> noAux = primeiroNo;
        String str = "Lista Duplamente Encadeada = ";
        for(int i = 0; i < this.size(); i++){
            str += noAux + " ---> ";
            noAux = noAux.getNoProx();
        }
        str += "null";
        return str;
    }
}
