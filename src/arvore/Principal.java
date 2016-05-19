package arvore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ivo
 */
public class Principal {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        menu();
        System.out.println("PROGRAMA ENCERRADO !!!.");
    }

    //metodo para criação do menu
    private static void menu() { // menu principal
        //intancia um objeto do tipo arvore
        Arvore a = new Arvore();

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        // entra em loop 
        do {
            System.out.println("\n\n                                 ARVORE BINARIA DE BUSCA \n");
            System.out.println("\n                                           MENU \n           ");
            System.out.println("                              1 - Inserir os nós (arquivo txt) ");
            System.out.println("                              2 - Inserir nó                   ");
            System.out.println("                              3 - pesquisar nó                 ");
            System.out.println("                              4 - excluir nó                   ");
            System.out.println("                              5 - Imprimir a arvore in-ordem   ");
            System.out.println("                              6 - Imprimir a arvore pré-ordem  ");
            System.out.println("                              7 - Imprimir a arvore pós-ordem  ");
            System.out.println("                              0 - Sair                         ");

            System.out.print("Opção -> ");
            opc = sc.nextInt();
            System.out.print("\n");
            switch (opc) {
                //primeira opção é a de inserir os valores que estao no arquivo txt
                case 1:
                    try {
                        //instancia um objeto FileInputStream que recebe o caminhodo arquivo txt
                        //obs: o arquivo precisa estar nesse caminho : C:\ArvoreABB\src\arvore
                        FileInputStream arquivo = new FileInputStream("C:\\ArvoreABB\\src\\arvore\\arquivo.txt");
                        //instancia um objeto InputStreamReader que le o arquivo
                        InputStreamReader input = new InputStreamReader(arquivo);
                        //instancia um objeto BufferedReader que armazena
                        BufferedReader br = new BufferedReader(input);

                        String linha;
                        do {
                            //le cada linha 
                            linha = br.readLine();
                            if (linha != null) {
                                //separa os valor que estão entre ";"
                                String[] numero = linha.split(";");

                                System.out.println("NUMERO(s) QUE ESTÃO NO ARQUIVO TXT :\n");
                                //imprime os numeros do aquivo txt e converte para inteiro, os inserindo na arvore
                                for (int i = 0; i < numero.length; i++) {
                                    System.out.print("numero lido: " + numero[i]);
                                    a.inserirNo(Integer.parseInt(numero[i]));

                                }
                            }

                        } while (linha != null); //repete até encontrar uma linha vazia

                    } catch (IOException ex) { //erro ao encontrar o arquivo
                        System.out.println("erro ao encontrar o arquivo" + ex);
                    }

                    break;
                case 2: //insere os numeros na arvore diretamente
                    int num;
                    System.out.print("Digite o número a ser inserido: ");
                    num = sc.nextInt();
                    if (num >= 0) {
                        a.inserirNo(num);
                    } else {
                        System.out.print("favor informar um numero Inteiro ! ");
                    }

                    break;

                case 3:// pesquisa um numero que pode estar na arvore
                    System.out.print("Digite o número a ser pesquisado: ");
                    num = sc.nextInt();
                    if (num >= 0) {
                        a.buscarNo(num);
                    } else {
                        System.out.print("favor informar um numero Inteiro ! ");
                    }
                    break;

                case 4: // exclui um numero que pode estar na arvore
                    System.out.print("Digite o número a ser excluido: ");
                    num = sc.nextInt();
                    if (num >= 0) {
                        a.remover(num);
                    } else {
                        System.out.print("favor informar um numero Inteiro ! ");
                    }

                    break;
                case 5: //imprime a arvore em modo em ORDEM
                    System.out.print(" IN-ORDEM: ");
                    a.imprimirInOrdem();
                    System.out.println("\n");
                    break;

                case 6: //imprime a arvore em modo pre ORDEM

                    System.out.print(" PRE-ORDEM: ");
                    a.imprimirPreOrdem();
                    System.out.println("\n");
                    break;

                case 7: //imprime a arvore em modo pos ORDEM
                    System.out.print(" POS-ORDEM: ");
                    a.imprimirPosOrdem();
                    System.out.println("\n");
                    break;

                case 0: //sai 
                    break;
                default:
                    System.out.println("- OPÇÃO INVALIDA !!! - Digite uma opção valida do menu (0 à 7) \n");
                    break;
            }
        } while (opc != 0);// repete até o usuario digitar a opção 0

    }

}
