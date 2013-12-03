package trabalhoarvorerb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Junior Moises
 */
public class Arvore {

	private String chave;
	private String valor;
	private Nodo raiz;
	private Nodo tio;
	private int altura = 0;

	public void inserir(String chave, String valor) {

		Nodo novoNodo = new Nodo(chave.hashCode(), valor);

		if (raiz == null) {

			novoNodo.black = true;
			raiz = novoNodo;
			raiz.altura = 0;
			raiz.pai = null;
			raiz.direita = null;
			raiz.esquerda = null;
			System.out.println("Indice: " + String.valueOf(novoNodo.indice) +"\r\n" + "Raiz: "+ novoNodo.conteudo);

			return;
		}

		Nodo nodoAux = raiz;

		while (novoNodo.pai == null) {

			if (novoNodo.indice > nodoAux.indice) {
				
				altura++;
				
					if (nodoAux.direita == null) {
						
						nodoAux.direita = novoNodo;
						novoNodo.pai = nodoAux;
						novoNodo.direita = null;
						novoNodo.esquerda = null;
						novoNodo.altura = altura;
						System.out.println("Pai: " +novoNodo.pai.conteudo + "\r\n" + "Indice: " + String.valueOf(novoNodo.indice) +"\r\n" + "Conteudo: "+ novoNodo.conteudo);

					}
					
				nodoAux = nodoAux.direita;
				
			//	System.out.println("Indice: " + String.valueOf(nodoAux.indice) +"\r\n" + "Conteudo: "+ nodoAux.conteudo);
			} 
	
			if (novoNodo.indice < nodoAux.indice) {

				altura++;
				
				if (nodoAux.esquerda == null) {
					
					nodoAux.esquerda = novoNodo;
					novoNodo.pai = nodoAux;
					novoNodo.direita = null;
					novoNodo.esquerda = null;
					novoNodo.altura = altura;
					System.out.println("Pai: " +novoNodo.pai.conteudo + "\r\n" + "Indice: " + String.valueOf(novoNodo.indice) +"\r\n" + "Conteudo: "+ novoNodo.conteudo);
				}
			nodoAux = nodoAux.esquerda;	
		}
	}
}
	public void remover(String chave) {

	}
	public void excluir(String next) {
		// TODO Auto-generated method stub
		
	}
	public void consultar(String chave) {
		
		int indice = chave.hashCode();
		Nodo nodoAux = raiz;

		while (nodoAux.indice != indice) {

			if (indice > nodoAux.indice) {
				
					if (nodoAux.direita.indice == indice) {
						
						System.out.println("Pai: " +nodoAux.direita.pai.conteudo + "\r\n" + "Conteudo: "+ nodoAux.direita.conteudo);

					}
					
				nodoAux = nodoAux.direita;
				
			//	System.out.println("Indice: " + String.valueOf(nodoAux.indice) +"\r\n" + "Conteudo: "+ nodoAux.conteudo);
			} 
	
			if (indice < nodoAux.indice) {
				
				if (nodoAux.esquerda == null) {
					
					System.out.println("Pai: " +nodoAux.esquerda.pai.conteudo + "\r\n" + "Conteudo: "+ nodoAux.esquerda.conteudo);
				}
				
			nodoAux = nodoAux.esquerda;			
		}
	}	
	}
}

