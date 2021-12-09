package com.kevin.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kevin.aluraviagens.R;
import com.kevin.aluraviagens.model.Pacote;
import com.kevin.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2
                , new BigDecimal("243.99"));

        Button botaoFinalizarPagamento = findViewById(R.id.pagamentoBotaoFinalizar);
        botaoFinalizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                startActivity(intent);
            }
        });

        mostraPreco(pacoteSaoPaulo);
    }
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamentoValor);
        String moedaBrasileira = MoedaUtil
                .formataMoedaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}