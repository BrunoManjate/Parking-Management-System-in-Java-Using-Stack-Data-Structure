import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*
;
public class Sobre extends JFrame
{
	private JTextArea campo;
	private JScrollPane scrul;
	private JButton bVoltar;
	
	public Sobre(String str) 
	{
		super("Sobre");
		StringBuilder builder = new StringBuilder();
		try
        {
			 BufferedReader reader = new BufferedReader(new FileReader(str));
			 String line = null;
			 while ((line = reader.readLine()) != null) 
			 {
				 builder.append(line).append(System.lineSeparator());
			 }
			 reader.close();
        }catch(FileNotFoundException xx)
		{
  
        	JOptionPane.showMessageDialog(null,"Ficheiro "+str+" Nao Encontrado"," Erro File Not Found",JOptionPane.ERROR_MESSAGE);
		}catch(IOException zz)
		{
			//System.out.println(zz.getMessage());
			JOptionPane.showMessageDialog(null,zz,"Erro Exception",JOptionPane.ERROR_MESSAGE);
		}
		
		campo =  new JTextArea();
		campo.setFont(new Font("Arial", Font.PLAIN, 15));
		campo.setEditable(false);
		campo.setText(builder.toString());
		scrul=  new JScrollPane(campo);
		bVoltar = new JButton("Voltar");
	    bVoltar.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
	    this.add(bVoltar,BorderLayout.SOUTH);
		this.add(scrul);
		
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	}
}