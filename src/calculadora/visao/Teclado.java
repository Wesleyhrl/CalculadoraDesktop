package calculadora.visao;
import java.awt.event.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import calculadora.modelo.Memoria;

public class Teclado extends JPanel implements ActionListener {
    private final Color COR_CINZA_ESCURA = new Color(68,68,68);
    private final Color COR_CINZA_CLARO = new Color(99,99,99);
    private final Color COR_LARANJA = new Color(242,163,60);

    public Teclado() {
        setBackground(Color.BLACK);
        //Grids para organização
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        c.weightx = 1; // peso do elemento para preenche os espaços
        c.weighty = 1; // peso do elemento para preenche os espaços
        c.fill = GridBagConstraints.BOTH; // preenche os botões nas duas direções

        adicionarBotao("AC",COR_CINZA_ESCURA,c,0,0);
        adicionarBotao("+/-",COR_CINZA_ESCURA, c, 1, 0);
        adicionarBotao("%",COR_CINZA_ESCURA, c, 2, 0);
        adicionarBotao("÷",COR_LARANJA, c, 3, 0);

        adicionarBotao("7",COR_CINZA_CLARO,c,0,1);
        adicionarBotao("8",COR_CINZA_CLARO, c, 1, 1);
        adicionarBotao("9",COR_CINZA_CLARO, c, 2, 1);
        adicionarBotao("X",COR_LARANJA, c, 3, 1);

        adicionarBotao("4",COR_CINZA_CLARO,c,0,2);
        adicionarBotao("5",COR_CINZA_CLARO, c, 1, 2);
        adicionarBotao("6",COR_CINZA_CLARO, c, 2, 2);
        adicionarBotao("-",COR_LARANJA, c, 3, 2);

        adicionarBotao("1",COR_CINZA_CLARO,c,0,3);
        adicionarBotao("2",COR_CINZA_CLARO, c, 1, 3);
        adicionarBotao("3",COR_CINZA_CLARO, c, 2, 3);
        adicionarBotao("+",COR_LARANJA, c, 3, 3);

        c.gridwidth = 2; //Definindo a largura do grid
        adicionarBotao("0",COR_CINZA_CLARO,c,0,4);
        c.gridwidth = 1;
        adicionarBotao(",",COR_CINZA_CLARO, c, 2, 4);
        adicionarBotao("=",COR_LARANJA, c, 3, 4);

    }

    private void adicionarBotao(String string, Color cor,GridBagConstraints c, int x, int y) {
        
        c.gridx = x;
        c.gridy = y;
        Botao bt = new Botao(string, cor);
        bt.addActionListener(this); //quando botão for executado
        add(bt,c);
    }
    /**Método para quando um ação foi executada */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt =(JButton) e.getSource();
        Memoria.getInstancia().processarComando(bt.getText());
    }
     
}
