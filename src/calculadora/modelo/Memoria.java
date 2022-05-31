package calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private static Memoria instancia = new Memoria();
    private String textoAtual = "";
    private String textoBuffer = "";
    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private final List<MemoriaObservador> observadores = new ArrayList<>();

    enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, VIRGULA, IGUAL, SINAL, PORCENTAGEM;
    }

    // Construtor 
    private Memoria() {
    }

    // Getters and Setters
    public static Memoria getInstancia() {
        return instancia;
    }

    public String getTextoAtual() {

        if (textoAtual.isEmpty()) {
            return "0";
        } else {
            return textoAtual;
        }
    }

    public void addObservador(MemoriaObservador observador) {
        observadores.add(observador);
    }

    public void processarComando(String texto) {
        TipoComando op = detectarTipoComando(texto);

        if(op == null){
            return;
        }else if(op == TipoComando.ZERAR){
            this.textoAtual = "";
            this.textoBuffer = "";
            this.substituir = false;
            this.ultimaOperacao = null;
        }else if (op == TipoComando.VIRGULA && "".equals(textoAtual)){
            textoAtual = "0,";
                
        }else if (op == TipoComando.SINAL && textoAtual.contains("-")){
            textoAtual = textoAtual.substring(1);
                
        }else if (op == TipoComando.SINAL && !textoAtual.contains("-")){
            textoAtual = "-" + textoAtual;
                
        }else if(op == TipoComando.NUMERO || op == TipoComando.VIRGULA){
            this.textoAtual = this.substituir ? texto : this.textoAtual + texto;
            this.substituir = false;
        }else{
            this.substituir = true;
            this.textoAtual = obterResultadoOp();
            this.textoBuffer = this.textoAtual;
            this.ultimaOperacao = op;
        }
        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));

    }

    private String obterResultadoOp() {
        if(ultimaOperacao == null || ultimaOperacao == TipoComando.IGUAL){
            return textoAtual;
        }
        
        String resultado = Logica.operacao(ultimaOperacao, textoBuffer, textoAtual);
        boolean inteiro = resultado.endsWith(",0"); 
        return inteiro ? resultado.replace(",0", "") : resultado;
    }

    private TipoComando detectarTipoComando(String texto) {
        if (this.textoAtual.isEmpty() && texto == "0") {
            return null;
        }
        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {
            if ("AC".equals(texto)) {
                return TipoComando.ZERAR;
            } else if ("÷".equals(texto)) {
                return TipoComando.DIV;
            } else if ("X".equals(texto)) {
                return TipoComando.MULT;
            } else if ("-".equals(texto)) {
                return TipoComando.SUB;
            } else if ("+".equals(texto)) {
                return TipoComando.SOMA;
            } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            } else if (",".equals(texto) && !this.textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            } else if ("+/-".equals(texto)) {
                return TipoComando.SINAL;
            } else if ("%".equals(texto)) {
                return TipoComando.PORCENTAGEM;
            }

        }
        return null;
    }

}
