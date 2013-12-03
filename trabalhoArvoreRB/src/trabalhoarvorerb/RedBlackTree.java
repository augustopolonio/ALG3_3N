package trabalhoarvorerb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @author Junior Moises
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RedBlackTree {

    /**
     * @param args the command line arguments
     */    
        private static String PWD = System.getProperty("user.dir");
	private static String SEPARADOR = "=" ;

	public static void main(String[] args) throws IOException {
		
        //leitura do arquivo
        FileReader arq = new FileReader(PWD + File.separator + "arquivo.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        Arvore arv = new Arvore();
        String linha = lerArq.readLine();
        Scanner aux = new Scanner(System.in);

        while (linha!= null) {
        	
            String parametros[] =  linha.split(SEPARADOR);
            arv.inserir(parametros[0].toLowerCase(), parametros[1].toLowerCase());
            
            linha = lerArq.readLine();            
        }
        
        while (!aux.toString().toLowerCase().equals("fim")){

        	switch (aux.next().toLowerCase()) {
			
        	case "inserir":
        		arv.inserir(aux.next(), aux.next());
				break;
        	
        	case "excluir":			
        		arv.excluir(aux.next());
				break;
				
        	case "consultar":
        		arv.consultar(aux.next());
			default:
				break;
			}	
        }	
	}
}
