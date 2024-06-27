import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Parque_AutomovelJF extends JFrame
{
	public static int c_ligeiro = 0, c_pesado = 0, c_Moto=0, quant=5, quantE=0, click=0;
	public static float v_ligeiro = 0, v_pesado = 0, v_Moto=0, vt=0;
	private Pilha_Atomovel pilha;
	private JLabel jtipoA, jbi, jmodelo, jmarca, jnumh, jmatricula,tipoP,vazio,vazio1,vazio3;
	private TextField tbi, tmodelo, tmarca, tnumh, tmatricula, tpreco;
	private JComboBox box;
	private JRadioButton ligeiro,pesado,moto;
	private ButtonGroup bg;
	private String [] a = {"Dinheiro", "Seguro", "Cheque"};
	private JButton emitir,voltar,remover, visualizarDados, visualizar_topo,procura,editar;
	private JPanel panel,panel4,panel1,panel2,panel3;
	private Container cont;
	private int Pes = 1000, Mot = 250, lig = 500;
	
	
	public Parque_AutomovelJF(MenuJ m)
	{
		super("Parque_AutomovelJF");
		cont = getContentPane();
		cont.setBackground(Color.black);
		
		pilha = new Pilha_Atomovel((byte)3);
		aparencia();
		
		
		
		panel = new JPanel(new GridLayout(20,1));
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBackground(Color.black);
		
		jbi = new JLabel("  Bilhete de Identidade");
		jbi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbi.setForeground(Color.white);
		panel.add(jbi);
		tbi = new TextField();
		panel.add(tbi);
		
		
		jtipoA = new JLabel("  Tipo de Automovel");
		jtipoA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtipoA.setForeground(Color.white);
		panel.add(jtipoA);
		
		panel4 = new JPanel(new GridLayout(1,3));
		panel4.setBackground(Color.WHITE);
		
		ligeiro = new JRadioButton("Ligeiro",true);
		panel4.add(ligeiro);
		
		pesado = new JRadioButton("Pesado",false);
		panel4.add(pesado);
		
		moto = new JRadioButton("Moto",false);
		panel4.add(moto);
		
		bg = new ButtonGroup();
		bg.add(ligeiro);
		bg.add(pesado);
		bg.add(moto);
		
		panel.add(panel4);
		
		jmodelo = new JLabel("  Modelo do Automovel");
		jmodelo.setFont(new Font("Tahoma",Font.PLAIN, 15));
		jmodelo.setForeground(Color.white);
		panel.add(jmodelo);
		tmodelo = new TextField();
		panel.add(tmodelo);
		
		
		jmarca = new JLabel("  Marca do Automovel");
		jmarca.setFont(new Font("Tahoma",Font.PLAIN, 15));
		jmarca.setForeground(Color.white);
		panel.add(jmarca);
		tmarca = new TextField();
		panel.add(tmarca);
		
		jnumh = new JLabel("  Num de Horadas de Estacionamento");
		jnumh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jnumh.setForeground(Color.white);
		panel.add(jnumh);
		
		tnumh = new TextField();
		tnumh.addKeyListener(new KeyListener() {
			  public void keyTyped(KeyEvent e)
	  		  {
		  		char c = e.getKeyChar();
		  		if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c == KeyEvent.VK_ENTER)))
		  		{
		  			getToolkit().beep();
		  			e.consume();
		  			JOptionPane.showMessageDialog(null, "Introduza somente numeros");
		  		}
	  		  }
			  public void keyPressed(KeyEvent arg0) {}
		      public void keyReleased(KeyEvent arg0) {}
	    } );
		panel.add(tnumh);
		
		jmatricula = new JLabel("  Matricula do Automovel");
		jmatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jmatricula.setForeground(Color.white);
		panel.add(jmatricula);
		tmatricula = new TextField();
		panel.add(tmatricula);
		
		tipoP = new JLabel("  Tipo de Pagamento "); 
		tipoP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tipoP.setForeground(Color.white);
		panel.add(tipoP);
		
		Tratar t = new Tratar();
		
		panel1 = new JPanel(new GridLayout(1,2));
		panel1.setBackground(Color.black);
		
		box = new JComboBox(a);
		box.setBackground(Color.ORANGE);
		panel1.add(box);
		
		vazio = new JLabel();
		panel1.add(vazio);
		
		panel.add(panel1);
		
		emitir = new JButton("Emitir");
		emitir.addActionListener(t);
		emitir.setBackground(Color.black);
		emitir.setForeground(Color.white);
		emitir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(emitir);
	    
		visualizarDados = new JButton("Visualizar_Dados");
		visualizarDados.addActionListener(t);
		visualizarDados.setBackground(Color.black);
		visualizarDados.setForeground(Color.white);
		visualizarDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(visualizarDados);

		visualizar_topo = new JButton("Visualizar Topo");
		visualizar_topo.addActionListener(t);
		visualizar_topo.setBackground(Color.black);
		visualizar_topo.setForeground(Color.white);
		visualizar_topo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(visualizar_topo);
		
		panel3 = new JPanel(new GridLayout(1,2));
		panel3.setBackground(Color.BLACK);
		
		procura  =  new JButton("Pesquisar Dados");
		procura.addActionListener(t);
		procura.setBackground(Color.black);
		procura.setForeground(Color.white);
		procura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel3.add(procura);
		
		editar =  new JButton("Editar Dados");
		editar.addActionListener(t);
		editar.setBackground(Color.black);
		editar.setForeground(Color.white);
		editar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel3.add(editar);
		
		panel.add(panel3);
		
		remover =  new JButton("Remover");
		remover.addActionListener(t);
		remover.setBackground(Color.black);
		remover.setForeground(Color.white);
		remover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(remover);
		
		panel2 = new JPanel(new GridLayout(1,3));
		panel2.setBackground(Color.BLACK);
		
		vazio1 = new JLabel();
		panel2.add(vazio1); 
		
		voltar = new JButton("Voltar");
		voltar.addActionListener(t);
		voltar.setBackground(Color.red);
		voltar.setForeground(Color.white);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.add(voltar);
		
		vazio3 = new JLabel();
		panel2.add(vazio3);
		
		panel.add(panel2);
		
		
        cont.add(panel,BorderLayout.SOUTH);
		
		addWindowListener(
   				new WindowAdapter() {
   					public void windowClosing(WindowEvent a) {
   						dispose();
   		                m.setVisible(true);				
   					}
   				});
	    
		
		setSize(800,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public class Tratar implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()==emitir)
			{
				
				if(!tbi.getText().isEmpty() && !tmodelo.getText().isEmpty() && !tmarca.getText().isEmpty() && !tnumh.getText().isEmpty() && !tmatricula.getText().isEmpty())
				{	
					String tipoA = "", bi = "", modelo = "", marca = "",matricula = "",tipoP = "";
					float  vp = 0; byte nh = 0, numH = 0;
					
					try
					{  
					  numH = Byte.parseByte(tnumh.getText());
					}catch(Exception xx)
					{
						JOptionPane.showMessageDialog(null, xx);
					}
					 
					if(numH>=24)
					{
						JOptionPane.showMessageDialog(null,"Hora Invalida o dia tem 24h!","Erro",JOptionPane.ERROR_MESSAGE);
						tnumh.setText("");
					}
					else
					{	
					      if(box.getSelectedIndex()==0 && ligeiro.isSelected())
							{
								bi = tbi.getText();
								tipoA = "Ligeiro";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Dinheiro";
				
							}
							
				    		if(box.getSelectedIndex()==1 && ligeiro.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Ligeiro";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Sghuro";
								
							}
				    		
				    		if(box.getSelectedIndex()==2 && ligeiro.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Ligeiro";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Cheque";
								
							}
				    		
				    		if(box.getSelectedIndex()==0 && pesado.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Pesado";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Dinheiro";
							
							}
							
				    		if(box.getSelectedIndex()==1 && pesado.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Pesado";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Seguro";
								
							}
				    		
				    		if(box.getSelectedIndex()==2 && pesado.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Pesado";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Cheque";
								
							}
				    		
				    		if(box.getSelectedIndex()==0 && moto.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Moto";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Dinheiro";
								
							}
							
				    		if(box.getSelectedIndex()==1 && moto.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Moto";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Seguro";
				
							}
				    		
				    		if(box.getSelectedIndex()==2 && moto.isSelected())
							{
				    			bi = tbi.getText();
								tipoA = "Moto";
								modelo = tmodelo.getText();
								marca = tmarca.getText();
								nh = numH;
								matricula = tmatricula.getText();
								tipoP = "Cheque";
							}
				    		
				    		Parque_Automovel aut = new Parque_Automovel(bi,tipoA,modelo,marca,matricula,nh,tipoP);
				    		
				    		
				    		if(moto.isSelected())
				    		{
				    			vp = Mot * nh;
				    			c_Moto++;
				    			v_Moto+= vp;
				    			vt+=v_Moto;
				    		}
				    		
				    		if(ligeiro.isSelected())
				    		{	
				    			vp = lig * nh;
				    			c_ligeiro++;
				    			v_ligeiro+= vp;
				    			vt+=v_ligeiro;
				    		}	
				    		
				    		if(pesado.isSelected())
				    		{	
				    			vp = Pes * nh;
				    			c_pesado++;
				    			v_pesado+= vp;
				    			vt+=v_pesado;
				    		}
				    		
				    		Parque_Automovel p = new Parque_Automovel(bi,tipoA,modelo,marca,matricula,nh, tipoP);
				    	    pilha.empilhar(p);
				    	    
				    	    JOptionPane.showMessageDialog(null, "Automovel Ensirido Com Sucesso!");
				    	    click++;
					}
				}else
				{
					JOptionPane.showMessageDialog(null,"Preencha Todos Campos!","Erro",JOptionPane.ERROR_MESSAGE);
					tbi.setText("");
					tmodelo.setText("");
					tmarca.setText("");
					tnumh.setText("");
					tmatricula.setText("");
				}
				
				tbi.setText("");
				tmodelo.setText("");
				tmarca.setText("");
				tnumh.setText("");
				tmatricula.setText(""); 
			}else
			{
				if(ev.getSource()==voltar)
				{
					dispose();
					Login lo = new Login();
					lo.setVisible(false);
					new MenuJ(lo);
				}else
				{
					if(ev.getSource()==remover)
					{
						pilha.desempilhar();
						JOptionPane.showMessageDialog(null, "Automovel Removido COm Sucesso!");
					}else
					{
						if(ev.getSource()==visualizarDados)
						{
							if(click<pilha.lista.length)
								JOptionPane.showMessageDialog(null, "Preencha Toda Tabela para poder visualizar");
							else
								pilha.imprimir();
						}else
						{
							if(ev.getSource()==visualizar_topo)
							{
								pilha.topo();
							}else
							{
								//procura,editar
								if(ev.getSource()==procura)
								{	if(click<pilha.lista.length)
										JOptionPane.showMessageDialog(null, "Preencha Toda Tabela para poder Pesquisar");
									else
									{
										String matricula = JOptionPane.showInputDialog("Introduz A matricula do carro\nque pretende Visualizar\nos Dados");
										pilha.pesquisarAutomovel(matricula);
									}	
								}else
								{
									if(ev.getSource()==editar)
									{
										if(click<pilha.lista.length)
											JOptionPane.showMessageDialog(null, "Preencha Toda Tabela para poder Editar");
										else
										{
											String bi = JOptionPane.showInputDialog("Introduz O Bilhete de Identidade\nque pretende Alterar Dados");
											pilha.editar_Dados(bi);
										}	
									}else
									{
										
									}
								}
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