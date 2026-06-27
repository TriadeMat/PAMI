package com.matheus.anotacao;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;
    private static final String CHAVE_NOME = "anotacao";

    public AnotacaoPreferencias(Context context){
        preferences = context.getSharedPreferences("arq_preferencias", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao);
        editor.apply();;
    }
    public String recuperarAnotacao(){
        return  preferences.getString(CHAVE_NOME, "");
    }

}
