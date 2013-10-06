/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segundotrabalho;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author augusto
 */
public class Shape {
    public static void main(String[] args) {
//        TESTE SPLIT (LER MAIS DE UMA STRING OU NUMERO NUMA MESMA LINHA)
//        String input = "1 fish 25 fish red fish blue fish";
//        String[] str = input.split(" ");
//        System.out.println(str[6]);  //MOSTRARÁ FISH
        
        Scanner entrada = new Scanner(System.in);
        int contErros = 0;
        
        String lerComando;  
        
//        String isExit = null;
        
        String [] comando;// = null;
        
        int largura = 0;
        int altura = 0;
                
        
        do{
            System.out.println(">");
            lerComando = entrada.nextLine();
            
            if (!lerComando.equals("")){
                                
                comando = lerComando.split(" ");
                
//                System.out.println("Comando: " + comando[0]);
                //Se pedir ajuda
                if ((lerComando.equals("help"))||(lerComando.equals("ajuda"))){
                    System.out.println("==============================================\n"
                                        + "Informa a comando: Ex: circulo <largura> <altura>\n"
                                        + "Salva o arquivo: salvar <nome arquivo>\n"
                                        + "Sair do programa: exit\n"
                                        + "==============================================");
                }
                //Se for circulo
                else if (comando[0].equals("circulo")){
                    //System.out.println("Você solicitou um '"+comando+"' com largura '"+largura+"'.\nPara salvar em formato PNM, você deverá digitar o comando 'salvar <nome do arquivo>'.");                
                    try {
                        largura = Integer.parseInt(comando[1]);                        
                        altura = Integer.parseInt(comando[2]);
                        
//                        System.out.println("\nLargura: "+ largura);
//                        System.out.println("Altura: "+altura);                        
                        
                    }
                    catch(Exception ex){
                        System.out.println("Você deve digitar a 'altura' e 'largura' do circulo.");
                    }
                }
                
                else if (comando[0].equals("salvar")){
                    int[][] img = new int[altura][largura];

                        for(int x=0;x<altura;x++){
                            for(int y=0;y<largura;y++){
                                img[x][y] = (x+y * 255)%255;
                            }
                        }

                        try{
                            String nomeArquivo = comando[1];
                            Shape.saveToPNMFile(img, nomeArquivo);
                        }catch(Exception e){
//                            System.err.println(e.getMessage());
//                            e.printStackTrace(System.err);
                            System.out.println("Você não especificou o tamanho da imagem.");
                        }
                }
                
                else if (!"exit".equals(lerComando)){
                    System.out.println("O comando '"+lerComando+"' é inválido.");
                    if (contErros > 1){
                        System.out.println("Você pode digitar o comando 'help' para obter ajuda.");
                    }
                    contErros++;
                }

            }
            else{
                System.out.println("Você deve digitar algum comando.");
            }
        }
        while(!lerComando.equals("exit"));       
        
    }
    
     public static void saveToPNMFile(int[][] mat, String filename) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(filename+".pnm"));
        out.write(String.format("P2\n%d %d\n255\n",mat[0].length,mat.length));
        
        for (int[] linha:mat)
            for(int v:linha)
                out.write(String.format("%d ", v));
    }
     
}
