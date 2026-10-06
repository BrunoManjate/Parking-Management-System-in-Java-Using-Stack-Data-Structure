package pms;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class Login extends JFrame
{
	private JPasswordField passwordField;
	private JTextField nome;
	private JButton emitir, voltar;

	public Login()
	{
		aparencia();

		// -------- dimensões base (laptop 1366x768) --------
		final int LARG = 1200;
		final int ALT  = 700;

		JPanel heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0, 0, LARG, 80);
		heading.setLayout(null);

		// -------- painel de login --------
		JPanel login = new JPanel();
		login.setSize(450, 300);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds((LARG - 450) / 2, 280, 450, 300);
		login.setLayout(null);

		// -------- imagem de fundo (independente do PC) --------
		URL url = getClass().getResource("/imagens/logi.jpg");
		ImageIcon backGroundImage = (url != null)
				? new ImageIcon(url)
				: new ImageIcon();

		Image img = backGroundImage.getImage();
		if (img != null) {
			Image temp_img = img.getScaledInstance(LARG, ALT, Image.SCALE_SMOOTH);
			backGroundImage = new ImageIcon(temp_img);
		}

		JLabel backGround = new JLabel("", backGroundImage, JLabel.CENTER);
		backGround.setBounds(0, 0, LARG, ALT);
		backGround.setLayout(null);
		backGround.add(login);
		backGround.add(heading);

		// -------- painel dos botões --------
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setLayout(null);
		panel.setBackground(new Color(0,0,0,60));
		panel.setBounds(15, 210, 420, 80);
		login.add(panel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(10, 5, 400, 36);
		panel.add(panel_3);
		panel_3.setLayout(null);

		emitir = new JButton("Entrar");
		emitir.setBounds(10, 0, 380, 36);
		panel_3.add(emitir);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(10, 43, 400, 30);
		panel.add(panel_4);
		panel_4.setLayout(null);

		voltar = new JButton("Sair");
		voltar.setBackground(Color.red);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voltar.setBounds(10, 0, 380, 30);
		voltar.setForeground(Color.white);
		panel_4.add(voltar);

		// -------- título --------
		JLabel lbltub = new JLabel("--tub[][];--");
		lbltub.setForeground(Color.WHITE);
		lbltub.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 60));
		lbltub.setBounds(20, 20, 420, 70);
		login.add(lbltub);

		// -------- painel dos campos --------
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 50));
		panel_2.setBounds(15, 110, 420, 90);
		login.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblName = new JLabel("Nome");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 12, 70, 16);
		panel_2.add(lblName);

		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(10, 50, 70, 16);
		panel_2.add(lblPassword);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(85, 5, 325, 80);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		nome = new JTextField();
		nome.setBounds(5, 5, 315, 32);
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
		});
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(5, 42, 160, 32);
		panel_1.add(passwordField);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Exibir Senha");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(170, 42, 150, 32);
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
		emitir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emitir.setForeground(Color.WHITE);

		voltar.addActionListener(tr);

		// -------- janela --------
		setSize(LARG, ALT);
		getContentPane().setLayout(null);
		getContentPane().add(backGround);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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