package dio.fila;

public class Fila<T>{

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
    }

    public T first(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() == null)
                    return (T) primeiroNo.getObjeto();
                primeiroNo = primeiroNo.getRefNo();
            }
        }
        return null;
    }

    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setRefNo(refNoEntradaFila);
        this.refNoEntradaFila = novoNo;
    }

    public T dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }
                else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObjeto();
        }
        return null;
    }

    @Override
    public String toString() {
        String strReturn = "";
        No noAux = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                strReturn += "[No{objeto = " + noAux.getObjeto() + "}] ---> ";
                if(noAux.getRefNo() != null) {
                    noAux = noAux.getRefNo();
                } else{
                    strReturn += "INÍCIO DA FILA";
                    break;
                }
            }
        } else{
            strReturn = "FILA VAZIA!";
        }
        return strReturn;
    }
}
