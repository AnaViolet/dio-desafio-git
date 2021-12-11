package dio.pilha;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public No top(){
        return this.refNoEntradaPilha;
    }

    public void push(No novoNo){
        No refAux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAux);
    }

    public No pop(){
        if(!isEmpty()){
            No noPopped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPopped;
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null ? true : false;
    }

    @Override
    public String toString() {
        String strReturn = "--------------\n     Pilha\n--------------\n";

        No noAux = refNoEntradaPilha;

        while(true){
            if(noAux != null){
                strReturn += "[No{dado = " + noAux.getDado() + "}]\n";
                noAux = noAux.getRefNo();
            } else {
                break;
            }
        }

        strReturn += "--------------\n";
        return strReturn;
    }
}