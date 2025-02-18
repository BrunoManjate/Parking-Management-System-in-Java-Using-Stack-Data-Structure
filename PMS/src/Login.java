import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame
{
	private JPasswordField passwordField;
	private JTextField nome;
	private JButton emitir,voltar;
	public  Login ()
	{
		aparencia();
		
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,1500,100);
		heading.setLayout(null);
		
		//login Panel
		JPanel login = new JPanel();
		login.setSize(400,350);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(500,370,550,380);
	   
	    ImageIcon backGroundImage = new ImageIcon("logi.jpg");
	     
	    Image img =  backGroundImage.getImage();
	    Image temp_img = img.getScaledInstance(1500, 1000,Image.SCALE_SMOOTH);
	    JLabel backGround = new JLabel("",backGroundImage, JLabel.CENTER);
	    
	    backGround.add(login);
	    login.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(BorderFactory.createTitledBorder(""));
	    panel.setLayout(null);
	    panel.setBackground(new Color(0,0,0,60));
	    panel.setBounds(29, 268, 467, 109);
	    login.add(panel);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Color.BLUE);
	    panel_3.setBounds(12, 5, 443, 44);
	    panel.add(panel_3);
	    panel_3.setLayout(null);
	    
	    JLabel lbltub = new JLabel("--tub[][];--");
	    lbltub.setForeground(Color.WHITE);
	    lbltub.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 80));
	    lbltub.setBounds(62, 50, 416, 90);
	    login.add(lbltub);
	    login.add(lbltub);
	    
	    emitir = new JButton("Entrar");
	    emitir.setBounds(12, 0, 419, 44);
	    panel_3.add(emitir);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBackground(Color.RED);
	    panel_4.setBounds(22, 60, 422, 36);
	    panel.add(panel_4);
	    panel_4.setLayout(null);
	    
	    voltar = new JButton("Sair");
	    voltar.setBackground(Color.red);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    voltar.setBounds(12, 0, 398, 36);
	    voltar.setForeground(Color.white);
	    panel_4.add(voltar);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(0, 0, 0, 50));
	    panel_2.setBounds(12, 183, 504, 81);
	    login.add(panel_2);
	    panel_2.setLayout(null);
	    
	    JLabel lblName = new JLabel("Nome");
	    lblName.setForeground(Color.WHITE);
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblName.setBounds(12, 13, 74, 16);
	    panel_2.add(lblName);
	    
	    JLabel lblPassword = new JLabel("Senha");
	    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblPassword.setForeground(Color.WHITE);
	    lblPassword.setBounds(12, 49, 74, 16);
	    panel_2.add(lblPassword);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.BLACK);
	    panel_1.setBounds(107, 0, 410, 79);
	    
	    panel_2.add(panel_1);
	    panel_1.setLayout(null);
	    
	    nome = new JTextField();
	    nome.setBounds(0, 0, 398, 41);
	    panel_1.add(nome);
	    
	    passwordField = new JPasswordField();    
	    passwordField.addKeyListener(new KeyListener() {
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
	    passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
	    passwordField.setBounds(0, 44, 216, 35);
	    panel_1.add(passwordField);
	    
	    JCheckBox chckbxNewCheckBox = new JCheckBox("Exibir Senha");
	    chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    chckbxNewCheckBox.setForeground(Color.WHITE);
	    chckbxNewCheckBox.setBounds(224, 44, 174, 35);
	    chckbxNewCheckBox.addItemListener(new ItemListener()
	    {
	    	public void itemStateChanged(ItemEvent e) 
	    	{
	    		if (chckbxNewCheckBox.isSelected()) 
	    			passwordField.setEchoChar((char)0);
	            else 
	            	passwordField.setEchoChar('*');
	    	}
	    });
	    panel_1.add(chckbxNewCheckBox);
	  
	    Tratar tr = new Tratar();
	    
	    emitir.addActionListener(tr);
	    emitir.setBackground(Color.blue);
	    emitir.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    emitir.setForeground(Color.WHITE);
	    
	    voltar.addActionListener(tr);
	    
	    backGround.add(login);
	    backGround.add(heading);
	    backGround.setBounds(0,0,1500,1000);
	    
	    //frame
	    setSize(1500,1000);
	    getContentPane().setLayout(null);
	    getContentPane().add(backGround);
	    setResizable(true);
	    setLocationRelativeTo(null);
	    setUndecorated(true);
	    setVisible(true);
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
	
	public class Tratar implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()==emitir)
			{
				if(!passwordField.getText().equalsIgnoreCase("") && !passwordField.getText().equalsIgnoreCase("123456"))
					JOptionPane.showMessageDialog(null,"Codigo Invalido!","Erro Codigo",JOptionPane.ERROR_MESSAGE);
				else
				{
					if(!nome.getText().equalsIgnoreCase("") && !nome.getText().equalsIgnoreCase("Francisco Saiete") && !nome.getText().equalsIgnoreCase("Henrique Rosa") && !nome.getText().equalsIgnoreCase("EDA2"))
					{
						JOptionPane.showMessageDialog(null,"Nome Invalido!\nNao e usuario desse Sistema","Erro Nome",JOptionPane.ERROR_MESSAGE);
						nome.setText("");
				        passwordField.setText("");
					}
					else
					{
						dispose();
				        new MenuJ(getLogin());
				        nome.setText("");
				        passwordField.setText("");
					}   
				}	
			}else
			{
				if(ev.getSource()==voltar)
				{
					JOptionPane.showMessageDialog(null, "Passar bem Sr(a) "+nome.getText());
					System.exit(0);
				}
			}
		}	
	}	
	
	public Login getLogin()
	{
		return this;
	}
}	
