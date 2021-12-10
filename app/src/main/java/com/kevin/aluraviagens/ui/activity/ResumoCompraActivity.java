package com.kevin.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.aluraviagens.R;
import com.kevin.aluraviagens.model.Pacote;
import com.kevin.aluraviagens.util.DataUtil;
import com.kevin.aluraviagens.util.MoedaUtil;
import com.kevin.aluraviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraData(pacote);
            mostraPreco(pacote);
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumoCompraPrecoPacote);
        String moedaBrasileira = MoedaUtil
                .formataMoedaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumoCompraDataViajem);
        String pediodoEmTexto = DataUtil
                .pediodoEmTexto(pacote.getDias());
        data.setText(pediodoEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoCompraImagemPacote);
        Drawable drawableDoPacote = ResourcesUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumoCompraLocalPacote);
        local.setText(pacote.getLocal());
    }
}