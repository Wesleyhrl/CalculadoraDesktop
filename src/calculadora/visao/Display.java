package calculadora.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calculadora.modelo.Memoria;
import calculadora.modelo.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador {
    private JLabel label;

    public Display() {
        Memoria.getInstancia().addObservador(this);

        setBackground(new Color(38, 38, 38));
        label = new JLabel(Memoria.getInstancia().getTextoAtual());
        label.setForeground(Color.WHITE); // cor do texto
        label.setFont(new Font("courier", Font.PLAIN, 40)); // fonte do texto
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25)); // Gerenciando layout,posição
        add(label);

    }

    @Override
    public void valorAlterado(String valor) {

        label.setText(valor);
        if (valor.length() > 19) {
            label.setFont(new Font("courier", Font.PLAIN, 16));
        } else if (valor.length() > 12) {
            label.setFont(new Font("courier", Font.PLAIN, 24));
        } else if (valor.length() > 5) {
            label.setFont(new Font("courier", Font.PLAIN, 32));
        } else {
            label.setFont(new Font("courier", Font.PLAIN, 40));
        }

    }

}
