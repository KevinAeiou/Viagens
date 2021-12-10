package com.kevin.aluraviagens.ui.activity;

import static com.kevin.aluraviagens.ui.activity.PacoteActivitiesConstantes.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.aluraviagens.R;
import com.kevin.aluraviagens.model.Pacote;
import com.kevin.aluraviagens.util.DataUtil;
import com.kevin.aluraviagens.util.DiasUtil;
import com.kevin.aluraviagens.util.MoedaUtil;
import com.kevin.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String RESUMO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(RESUMO_APPBAR);
        carregaPacoteInserido();
    }

    private void carregaPacoteInserido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoPagamento = findViewById(R.id.botaoRealizarPagamento);
        botaoPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumoPacoteData);
        String dataFormatadaViagem = DataUtil.pediodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }


    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumoPacoteValor);
        String moedaBrasileira = MoedaUtil.formataMoedaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumoPacoteDias);
        String diasEmTexto = DiasUtil.formataTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoPacoteImagem);
        Drawable drawableDoPacote = ResourcesUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumoPacoteLocal);
        local.setText(pacote.getLocal());
    }
}