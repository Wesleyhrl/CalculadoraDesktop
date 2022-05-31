package calculadora.modelo;



import calculadora.modelo.Memoria.TipoComando;

 class Logica {
     static String operacao(TipoComando ultimaOperacao,String textoBuffer, String textoAtual){
        double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
        double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
        double resultado = 0;
        
        
        if(ultimaOperacao == TipoComando.SOMA){
            resultado = numeroBuffer + numeroAtual;
        }
        if(ultimaOperacao == TipoComando.SUB){
            resultado =  numeroBuffer - numeroAtual;
        }
        if(ultimaOperacao == TipoComando.MULT){
            resultado =  numeroBuffer * numeroAtual;
        }
        if(ultimaOperacao == TipoComando.DIV){
            resultado =  numeroBuffer / numeroAtual;
        }
        if(ultimaOperacao == TipoComando.PORCENTAGEM){
            resultado =  (numeroBuffer / 100) * numeroAtual;
        }
        
        
        String resultadoString = Double.toString(resultado).replace(".", ",");
        return resultadoString;
    }
    
}
