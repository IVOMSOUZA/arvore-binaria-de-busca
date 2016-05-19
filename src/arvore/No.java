package arvore;
//classe que cria os nós da arvore com seus atributos e metodos 

public class No {

    private int valor;
    private No esquerdo;
    private No direito;
    //construtor No que inicializa seus atributos valor , filho direito  e esquerdo

    public No(int valor, No esquerdo, No direito) {
        this.valor = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean ehFolha() {
        return (this.esquerdo == null && this.direito == null);
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

}
