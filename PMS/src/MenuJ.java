import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MenuJ extends JFrame
{
	private JButton Emitir_Dados,Voltar,Calculos_Dados,Dados_Programaodor,Sobre;
	private JMenuItem item;
	private JMenuBar bar;
	private JMenu menu;
	private JPanel panel;
	private Container cont;
	public MenuJ(Login l)
	{
		super("Menu");
		cont = getContentPane();
		cont.setBackground(Color.BLACK);
		
		
		aparencia();
		
		panel = new JPanel(new GridLayout(5,1));
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBackground(Color.BLACK);
		
		Tratar t = new Tratar();
		
		Emitir_Dados = new JButton("Emitir Dados");
		Emitir_Dados.addActionListener(t);
		Emitir_Dados.setBackground(Color.black);
		Emitir_Dados.setForeground(Color.white);
		Emitir_Dados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(Emitir_Dados);
		
		Calculos_Dados = new JButton("Calculos Dados");
		Calculos_Dados.addActionListener(t);
		Calculos_Dados.setBackground(Color.black);
		Calculos_Dados.setForeground(Color.white);
		Calculos_Dados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(Calculos_Dados);
		
		Dados_Programaodor = new JButton("Dados Programador");
		Dados_Programaodor.addActionListener(t);
		Dados_Programaodor.setBackground(Color.black);
		Dados_Programaodor.setForeground(Color.white);
		Dados_Programaodor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(Dados_Programaodor);
		
		Sobre = new JButton("Sobre");
		Sobre.addActionListener(t);
		Sobre.setBackground(Color.black);
		Sobre.setForeground(Color.white);
		Sobre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(Sobre);
		
		Voltar = new JButton("Sair");
		Voltar.addActionListener(t);
		Voltar.setBackground(Color.red);
		Voltar.setForeground(Color.white);
		Voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel.add(Voltar);
		
		cont.add(panel, BorderLayout.WEST);
		
		ImageIcon ic = new ImageIcon("f.jpg");
        JLabel logotipo = new JLabel();
        logotipo.setIcon(ic);
	
        cont.add(logotipo,BorderLayout.CENTER);
        
        setSize(1900,900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public class Tratar implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()== Emitir_Dados)
			{
				dispose();
				new Parque_AutomovelJF(getMenu());
			}else
			{
				if(ev.getSource()==Voltar)
				{
					JOptionPane.showMessageDialog(null, "Passar bem Sr(a) !");
					System.exit(0);
			    }else
				{
					if(ev.getSource()==Calculos_Dados)
					{
						dispose();
						new JCalculos(getMenu());
				    }else
				    {
					    if(ev.getSource()==Dados_Programaodor)
						 {
							new DadosProgramdor();
						 }else
						 {
							if(ev.getSource()==Sobre)
							 {
								new Sobre("Sobre.txt");
							  }
									
						 }
				     }
				}
			}
		}
	}	
	
	public MenuJ getMenu()
	{
		return this;
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