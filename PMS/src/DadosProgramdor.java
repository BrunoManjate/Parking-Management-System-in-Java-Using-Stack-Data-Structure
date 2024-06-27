import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class DadosProgramdor extends JFrame 
{
	private JTable tabela;
    private JScrollPane scrl;
    private String titulos[] ={"Dados Programador","Informacao"};
    private String [][]tabelaDados;
    private JButton bVoltar;
    private Container cont;
	public DadosProgramdor() 
	{
		super("Dados do Programador");
		cont = getContentPane();
		cont.setBackground(Color.WHITE);
		
		aparencia();
		
		tabelaDados = criarTabela(21, 2);  
		tabela = new JTable(tabelaDados,titulos);
		tabela.setEnabled(false);
		
		scrl = new JScrollPane(tabela);
		cont.add(scrl, BorderLayout.CENTER); 
		
		bVoltar = new JButton("Voltar");
		bVoltar.addActionListener(new ActionListener()
 	    {
  	       public void actionPerformed(ActionEvent ev)
  	       {
  	    	  dispose();
  	    	  
  	       }	
  	    });
		bVoltar.setBackground(Color.red);
        cont.add(bVoltar,BorderLayout.SOUTH);
       
       
       
       setSize(600,250);
       setResizable(false);
       setLocationRelativeTo(null);
       setVisible(true);
	}
	 public String [][] criarTabela(int linhas,int colunas)
     {
     	String [][] x = new String[linhas][titulos.length];
     	
     	x[0][0] = "Nome : ";
     	x[0][1] = "Bruno F.Manjate";
     	x[1][0] = "Codigo : ";
     	x[1][1] = "2020422";
     	x[2][0] = "numero : ";
     	x[2][1] = "845603981";	
     	x[3][0] = "Email : ";
     	x[3][1] = "brunomanjate2@gmail.com";
     	x[4][0] = "";
     	x[4][1] ="";
     	x[5][0] ="Nome : ";
     	x[5][1] ="Kelvin Langa";
     	x[6][0]	="Codigo : ";
     	x[6][1] ="20160787";
     	x[7][0] ="Numero : ";
     	x[7][1] ="842209662";
     	x[8][0] ="Email :";
     	x[8][1] ="kelvinLanga20@gmail.com";
     	x[9][0] ="";
     	x[9][1] ="";
     	x[10][0] = "Nome :";
     	x[10][1] = "Deimos White";
     	x[11][0] = "Codigo:";
     	x[11][1] = "20180372";
     	x[12][0] = "Numero";
     	x[12][1] = "84819987";
     	x[13][0] = "Email:";
     	x[13][1] = "deimosrenzo200@gmail.com";
     	x[14][0] = "";
     	x[14][1] = "";
     	x[15][0] = "Nome : ";
     	x[15][1] = "Matilde Nguenha";
     	x[16][0] = "Codigo:";
     	x[16][1] = "20180274";
     	x[17][0] = "Numero : ";
     	x[17][1] = "820473363";
     	x[18][0] = "Email:";
     	x[18][1] = "Nguenha.titi@gmail.com";
     	x[19][0] = "";
     	x[19][1] = "";
     	x[20][0] ="Engenharia";
     	x[20][1] ="Informatica";
     	
     	
     	return x;
     }
	 
	 public void aparencia()
	 {
			try 
			{
				for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
				{
					if ("Nimbus".equals(info.getName())) 
					{
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
			}
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
	 }
}
