import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class JCalculos extends JFrame 
{
	private JLabel imagem;
	private JButton voltar,vagas_Disponiveis, q_Viatuaras_Estacionadas,q_Viaturas_tipo,v_Valor_total_tipo, v_valor_total;
	private JPanel panel;
	
	
	private Container cont;
	public JCalculos(MenuJ m)
	{
		super("Calculos");
		cont = getContentPane();
		cont.setBackground(Color.WHITE);

		aparencia();
		
		panel = new JPanel(new GridLayout(5,1));
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBackground(Color.BLACK);
		
		Tratar t = new Tratar();
		
	    q_Viatuaras_Estacionadas = new JButton("Quantidade de Viaturas Estacionadas no parque");
	    q_Viatuaras_Estacionadas.addActionListener(t);
	    q_Viatuaras_Estacionadas.setBackground(Color.WHITE);
	    q_Viatuaras_Estacionadas.setBackground(Color.black);
	    q_Viatuaras_Estacionadas.setForeground(Color.white);
	    q_Viatuaras_Estacionadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    panel.add(q_Viatuaras_Estacionadas);
		
		q_Viaturas_tipo = new JButton("Quantidade de Viaturas Estacionadas por Tipo");
		q_Viaturas_tipo.addActionListener(t);
		q_Viaturas_tipo.addActionListener(t);
		q_Viaturas_tipo.setBackground(Color.black);
		q_Viaturas_tipo.setForeground(Color.white);
		q_Viatuaras_Estacionadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(q_Viaturas_tipo);
		
		v_Valor_total_tipo = new JButton("Valor Total de Viaturas Estacionadas por Tipo");
		v_Valor_total_tipo.addActionListener(t);
		v_Valor_total_tipo.setBackground(Color.WHITE);
		v_Valor_total_tipo.setBackground(Color.black);
		v_Valor_total_tipo.setForeground(Color.white);
		v_Valor_total_tipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(v_Valor_total_tipo);
		
		v_valor_total = new JButton("Valor Total da Empresa");
		v_valor_total.addActionListener(t);
		v_valor_total.setBackground(Color.black);
		v_valor_total.setForeground(Color.white);
		v_valor_total.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(v_valor_total);
		
		voltar =  new JButton("Voltar");
		voltar.addActionListener(t);
		voltar.setBackground(Color.red);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(voltar);
		
		cont.add(panel, BorderLayout.WEST);
		
		ImageIcon ic = new ImageIcon("contabildiade-scaled.jpg");
        JLabel logotipo = new JLabel();
        logotipo.setIcon(ic);

        cont.add(logotipo,BorderLayout.CENTER);

        addWindowListener(
   				new WindowAdapter() {
   					public void windowClosing(WindowEvent a) {
   						dispose();
   		                m.setVisible(true);				
   					}
   				});
        
		setSize(1900,1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public class Tratar implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{		
		    if(ev.getSource()== voltar)
			{
				dispose();
				new MenuJ(null);
			}else
			{
				   if(ev.getSource()== q_Viatuaras_Estacionadas)
					{
						JOptionPane.showMessageDialog(null, "Numero de Automoveis Estacionados no Parque : "+Parque_AutomovelJF.click);
					}else
					{
						if(ev.getSource()== q_Viaturas_tipo)
						{
							new Tabela_Quantidades();
						}else
						{
							if(ev.getSource()==  v_valor_total)
							{
								JOptionPane.showMessageDialog(null, "Valor Total da Empresa : "+Parque_AutomovelJF.vt);
							}else
							{
								if(ev.getSource()== v_Valor_total_tipo)
								{
									JOptionPane.showMessageDialog(null, "Valor Total  de Viaturas Estacionadas Ligeiros :  "+Parque_AutomovelJF.v_ligeiro+"\nValor Total de Viaturas Estacionadas Pesadas :  "+Parque_AutomovelJF.v_pesado+"\nValor Total de Viaturas Estacionadas Motos :  "+Parque_AutomovelJF.v_Moto);
								}	
							}
						}
					}
				}
			}
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
