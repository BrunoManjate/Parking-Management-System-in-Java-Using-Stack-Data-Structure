
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Tabela_Quantidades extends JFrame 
{
	private Parque_Automovel aut; 
	private JTable tabela;
    private JScrollPane scrl;
    private String titulos[] ={"Ligeiros","Pesado","Moto"};
    private String [][]tabelaDados;
    private JButton bVoltar;
    private Container cont;
	public Tabela_Quantidades() 
	{
		super("Quantidades Tipo Automovel");
		cont = getContentPane();
		cont.setBackground(Color.WHITE);
		
		aparencia();
		
		tabelaDados = criarTabela(1, 3);  
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
       
       setSize(600,110);
       setResizable(false);
       setLocationRelativeTo(null);
       setVisible(true);
	}
	 public String [][] criarTabela(int linhas,int colunas)
     {
		 
     	String [][] x = new String[linhas][titulos.length];
     	
     	x[0][0] = Parque_AutomovelJF.c_ligeiro+"";
     	x[0][1] = Parque_AutomovelJF.c_pesado+"";
     	x[0][2] = Parque_AutomovelJF.c_Moto+"";
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
