import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
public class JCarregar extends JFrame
{     
	public JCarregar() 
	{
        super("WELCOME");
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon ic=new ImageIcon("lo.jpg");
        JLabel logotipo = new JLabel();
        logotipo.setIcon(ic);

        JProgressBar pr = new JProgressBar();
        pr.setForeground(Color.blue);
        add(pr,BorderLayout.SOUTH);
        add(logotipo,BorderLayout.NORTH);
        
        final SwingWorker w = new SwingWorker() 
        {
            protected Object doInBackground() throws Exception {
                for (int i = 1; i <=100; i++) {
                    try {
                        pr.setValue(i);
                        pr.setString("");
                        Thread.sleep(20);
                        if(i==100)
                        {
                        	Login lo = new Login();
                        	lo.setVisible(true);
                        	dispose();
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                return 0;
            }
        };
        w.execute();

        setSize(800,1000);
        setVisible(true);
        setLocationRelativeTo(null);
	setResizable(false);
    }
}