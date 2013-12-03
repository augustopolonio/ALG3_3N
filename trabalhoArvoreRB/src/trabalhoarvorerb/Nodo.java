package trabalhoarvorerb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Junior Moises
 */

public class Nodo {
	
	public String conteudo;
	public int indice, altura;
	public Nodo direita, esquerda, pai;
	public boolean black = true;
	
	public Nodo(int indice, String valor) {
		
		this.indice = indice;
    	this.conteudo = valor;

        }   
}