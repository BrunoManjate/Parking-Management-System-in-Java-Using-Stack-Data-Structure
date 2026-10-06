package pms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class JCarregar extends JFrame {

    public JCarregar() {
        super("WELCOME");
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // -------- Imagem de fundo (independente do PC) --------
        URL url = getClass().getResource("/imagens/lo.jpg");

        JLabel logotipo = new JLabel();
        logotipo.setHorizontalAlignment(JLabel.CENTER);
        if (url != null) {
            logotipo.setIcon(new ImageIcon(url));
        } else {
            System.out.println("Imagem não encontrada: /imagens/lo.jpg");
        }

        // -------- Barra de progresso --------
        JProgressBar pr = new JProgressBar();
        pr.setForeground(Color.BLUE);
        pr.setStringPainted(false);

        add(pr, BorderLayout.SOUTH);
        add(logotipo, BorderLayout.CENTER);

        // -------- Thread de carregamento --------
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    try {
                        pr.setValue(i);
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                return 0;
            }

            @Override
            protected void done() {
                Login lo = new Login();
                lo.setVisible(true);
                dispose();
            }
        };
        w.execute();

        // -------- Janela (cabe em laptops 1366x768) --------
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}