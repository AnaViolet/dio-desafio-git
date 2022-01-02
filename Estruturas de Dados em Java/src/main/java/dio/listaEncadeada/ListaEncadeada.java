package dio.listaEncadeada;

public class ListaEncadeada<T> {

    No<T> refEntrada;

    public ListaEncadeada(){
        this.refEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if(this.isEmpty()){
            refEntrada = novoNo;
            return ;
        }

        No<T> noAux = refEntrada;
        for(int i=0; i<this.size()-1; i++){
            noAux = noAux.getProxNo();
        }

        noAux.setProxNo(novoNo);
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> refAux = refEntrada;

        while(true){
            if(refAux != null){
                tamanhoLista++;
                refAux = refAux.getProxNo();
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    private void validaIndice(int indice){
        if(indice >= size()){
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + indice + " desta lista.");
        }
    }

    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAux = refEntrada;
        No<T> noRet = null;

        for(int i=0; i<=index; i++){
            noRet = noAux;
            noAux = noAux.getProxNo();
        }
        return noRet;
    }
    
    public T get(int index){
        return getNo(index).getConteudo();
    }

    public T remove(int index){
        No <T> noPivo = this.getNo(index);
        if(index == 0){
            refEntrada = noPivo.getProxNo();
            return noPivo.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProxNo(noPivo.getProxNo());
        return noPivo.getConteudo();
    }

    public boolean isEmpty(){
        return refEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        No<T> noAux = refEntrada;
        String str = "Lista Encadeada = ";
        for(int i=0;i<this.size();i++){
            str += noAux + " ---> ";
            noAux = noAux.getProxNo();
        }
        str += "null";
        return str;
    }
}
