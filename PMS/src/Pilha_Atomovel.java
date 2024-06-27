import java.util.*;

import javax.swing.*;

public class Pilha_Atomovel     
{
	public int indTop; // variavel que deve guardar o indice no topo da pilha
	public Parque_Automovel[] lista;  // vector de array de qualquer objecto
	
	// contsructor da classe Pilha_Automovel que implimenta array de Objecto
	
	public Pilha_Atomovel(byte num) 
	{
		this.indTop = -1;
		this.lista = new Parque_Automovel[num];
	}
	// metedos

	
	// Testa se a pilha é vazia. Retorna true se o indice do topo for igual -1 (índice menor que zero)
	public boolean pilhaVazia()
	{
		if(this.indTop ==-1)
			return true;
		else
			return false;
	}
	
	// Tamanho Pilha
	public int tamanho_Pilha()
	{
		if(pilhaVazia())
			return 0;
		else 
				return indTop+1;
	}
	
	//Metedo Empilhar itens dentro da pilha
	public void empilhar(Parque_Automovel aut)
	{
		//push
		if(indTop==lista.length-1)
			JOptionPane.showMessageDialog(null, "Pilha Vazia");
		else
		{	indTop++;
		    lista[indTop] = aut;
		}
	}	
	
	//metedo para pesquisar
	public void pesquisarAutomovel(String matricula)
	{
		boolean ok = false;
		String carro = "";
		if(pilhaVazia())
			JOptionPane.showMessageDialog(null, "Pilha Vazia");
		else
		{
			for(byte i = 0; i < lista.length; i++)
			{
				if(lista[i].getMatricula().equalsIgnoreCase(matricula))
				{
					carro = "Carro Numero"+(i+1)+" "+lista[i].toString()+"\n";
					
					ok = true;
				}
			}
			
			if(ok == false)
				JOptionPane.showMessageDialog(null, "Nao temos um Automovel com a Matricula : "+matricula);
			else
				JOptionPane.showMessageDialog(null, "Dados do Automovel\n"+carro);
		}
	}
	
	// metedo para editar dados()
	public void editar_Dados(String bi)
	{
		boolean ok = false;
		String matricula;
		
		if(pilhaVazia())
			JOptionPane.showMessageDialog(null, "Pilha Vazia");
		else
		{
			for(byte i = 0; i < lista.length; i++)
			{
				if(lista[i].getBi().equalsIgnoreCase(bi))
				{
					matricula = JOptionPane.showInputDialog("Introduz A nova Matricula do Automovel");
					lista[i].setMatricula(matricula);
					ok = true;
				}
			}
		}	
		
		if(ok == false)
			JOptionPane.showMessageDialog(null, "Nao Temos Dados Do Bilhete de Identidade : "+bi);
		else
			JOptionPane.showMessageDialog(null,"Dados Alterados Com Sucesso");
	}
	
	//Metedo Deempilhar
	public void desempilhar()
	{
		if(pilhaVazia())
			JOptionPane.showMessageDialog(null, "Pilha Vazia");
		else
		{
			lista[indTop] = null;
			--indTop;
		}	
	}
	
	public void imprimir()
	{
		System.out.println("--Tub[][];-- Parque\n");
		for(byte i = 0; i < lista.length; i++)
			System.out.println(lista[i]+"\nCarro Numero = "+(i+1)+" "+"\n");
	}
	
	// topo da pilha
	public void topo()
	{
		if(pilhaVazia())
			JOptionPane.showMessageDialog(null, "Pilha Vazia");
		else
			JOptionPane.showMessageDialog(null,lista[this.indTop]); 
	}
}