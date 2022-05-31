package calculadora.visao;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton {

    public Botao(String texto ,Color color) {
        setFocusable(false);
        setText(texto);
        setFont(new Font("courier",Font.PLAIN,26));
        setOpaque(true);
        setBackground(color); // cor do fundo por parâmetro
        setForeground(Color.WHITE); // cor da fonte
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Definição da borda
        
    }

    
}
