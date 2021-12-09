package com.kevin.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataTexto(int quantidadeDias) {
        if (quantidadeDias > 1){
            return  quantidadeDias + PLURAL;
        }
        return quantidadeDias + SINGULAR;
    }

}
