package arvore;
//cria a estrutura da arvore com os seus nós 

public class Arvore {

    No raiz;
    //inicializa a raiz com nulo

    public Arvore() {
        raiz = null;
    }

    public void setRaiz(No novoNo) {
        this.raiz = novoNo;
    }

    public void inserirNo(int valor) {
        raiz = inserir(raiz, valor);

    }
    //insere elemento na arvore

    public No inserir(No no, int valor) {
        if (no == null) { //se o nó for nulo insere o elemento
            System.out.println(" - Inserido com sucesso!");
            return new No(valor, null, null);

        } else if (valor == no.getValor()) { // se encontrar o valor informa que ja existe
            System.out.println(" - Este valor já existe na arvore! ");
        } else if (valor < no.getValor()) {
            no.setEsquerdo(inserir(no.getEsquerdo(), valor));// seta o nó a esquerda 
        } else { //
            no.setDireito(inserir(no.getDireito(), valor));// seta o nó a direita

        }
        return no;
    }

    //usado pela classe principal
    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private No remover(No no, int valor) {
      
        if (raiz == null) {  //se nao tiver valor na raiz, informa a que a arvore esta vazia
            System.out.println("Árvore vazia");
            // Caso a raíz não seja nula Avalio se o valor que quero remover é maior ou menor 
            //que o nó que estou avaliando 

        } else if (valor < no.getValor()) {
            no.setEsquerdo(remover(no.getEsquerdo(), valor)); //usa o metodo remover de forma recursiva para setar o no esquerdo
        } else if (valor > no.getValor()) {
            no.setDireito(remover(no.getDireito(), valor)); //usa o metodo remover de forma recursiva para setar o no direito
        } else if (no.getEsquerdo() != null && no.getDireito() != null) {
            //2 filhos          
            no.setValor(encontraNo(no.getDireito()).getValor());
            no.setDireito(removeNo(no.getDireito()));
            //remove o nó 
            System.out.println("  Nó removido com sucesso!");
        } else {
            no = (no.getEsquerdo() != null) ? no.getEsquerdo() : no.getDireito(); //forma de representar o if e else atravez do operador ternario ? e :
            System.out.println("  Nó removido com sucesso!");
            
        }
        return no;
    }
    //remove o minimo

    public No removeNo(No no) {

        if (no == null) {
            System.out.println("  ERRO ");
        } else if (no.getEsquerdo() != null) {
            no.setEsquerdo(removeNo(no.getEsquerdo()));
            return no;
        } else {
            return no.getDireito();
        }
        return null;
    }

    //encontra o minimo
    private No encontraNo(No no) {
        if (no != null) {
            while (no.getEsquerdo() != null) {
                no = no.getEsquerdo();
            }
        }
        return no;
    }

    // usado pela classe principal
    public void buscarNo(int valor) {
        raiz = buscar(raiz, valor);

    }

    //busca elemento na arvore
    public No buscar(No no, int valor) {
        if (no == null) {
            System.out.println(" - Este valor não exite na arvore! ");

        } else if (valor == no.getValor()) {
            System.out.println(" - Este valor existe na arvore! ");
        } else if (valor < no.getValor()) {
            no.setEsquerdo(buscar(no.getEsquerdo(), valor));
        } else {
            no.setDireito(buscar(no.getDireito(), valor));

        }
        return no;
    }

    // é usado pela classe principal 
    public void imprimirInOrdem() {
        inOrdem(raiz);

    }

    //percorre a arvore de modo InOrdem de forma recursiva
    private void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.getEsquerdo());
            System.out.print(" - " + no.getValor());
            inOrdem(no.getDireito());

        }
    }
    // é usado pela classe principal 

    public void imprimirPreOrdem() {
        PreOrdem(raiz);
    }

    //percorre a arvore de modo PreOrdem de forma recursiva
    private void PreOrdem(No no) {

        if (no != null) {
            System.out.print(" - " + no.getValor());
            PreOrdem(no.getEsquerdo());
            PreOrdem(no.getDireito());
        }
    }

    // é usado pela classe principal 
    public void imprimirPosOrdem() {
        PosOrdem(raiz);
    }

    //percorre a arvore de modo PosOrdem de forma recursiva 
    private void PosOrdem(No no) {

        if (no != null) {
            PosOrdem(no.getEsquerdo());
            PosOrdem(no.getDireito());
            System.out.print(" - " + no.getValor());

        }
    }
}
