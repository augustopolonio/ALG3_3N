package trabalhofinal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        int vInicial, vFinal;
        
        Scanner scan = new Scanner(System.in);
        Grafo grafo = new Grafo();
        
        grafo.criaGrafo();
        
        System.out.print("Digite o vertice inicial: ");
        vInicial = scan.nextInt();
        System.out.print("\nDigite o vertice final: ");
        vFinal = scan.nextInt();
        System.out.print("\n");
        
        grafo.zeraEtiquetaVerticeInicial(vInicial);
        
        grafo.Dijkstra();
        
        System.out.println(grafo.menorCaminho(vInicial, vFinal));
    }
}