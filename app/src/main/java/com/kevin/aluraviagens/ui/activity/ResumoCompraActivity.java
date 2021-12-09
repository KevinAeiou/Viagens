package com.kevin.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.aluraviagens.R;
import com.kevin.aluraviagens.model.Pacote;
import com.kevin.aluraviagens.util.DataUtil;
import com.kevin.aluraviagens.util.MoedaUtil;
import com.kevin.aluraviagens.util.ResourcesUtil;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2
                , new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumoCompraLocalPacote);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumoCompraImagemPacote);
        Drawable drawableDoPacote = ResourcesUtil
                .devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView data = findViewById(R.id.resumoCompraDataViajem);
        String pediodoEmTexto = DataUtil
                .pediodoEmTexto(pacoteSaoPaulo.getDias());
        data.setText(pediodoEmTexto);

        TextView preco = findViewById(R.id.resumoCompraPrecoPacote);
        String moedaBrasileira = MoedaUtil
                .formataMoedaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);
    }
}