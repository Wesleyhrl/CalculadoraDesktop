package calculadora.visao;
import java.awt.*;


import javax.swing.JFrame;


public class Calculadora extends JFrame {

    public Calculadora() {
        setTitle("Calculadora");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        organizarLayout();
        setVisible(true);
        setSize(300,420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
    }
    
    private void organizarLayout() {
        
        setLayout(new BorderLayout()); //para organizar posições do layout
        Display display = new Display();
        display.setPreferredSize(new Dimension(300, 70));
        add(display, BorderLayout.NORTH); //adiciona display no JFrame e coloca na posição norte
        
        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER); //adiciona teclado no JFrame e coloca na posição central
    }

    public static void main(String[] args) {
        new Calculadora();
    }
    
}
