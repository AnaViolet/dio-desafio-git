package dio.fila;

public class Fila {

    private No refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
    }

    public No first(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() == null)
                    return primeiroNo;
                primeiroNo = primeiroNo.getRefNo();
            }
        }
        return null;
    }

    public void enqueue(No novoNo){
        novoNo.setRefNo(refNoEntradaFila);
        this.refNoEntradaFila = novoNo;
    }

    public No dequeue(){
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
            return primeiroNo;
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
            strReturn = "Fila vazia!";
        }
        return strReturn;
    }
}
