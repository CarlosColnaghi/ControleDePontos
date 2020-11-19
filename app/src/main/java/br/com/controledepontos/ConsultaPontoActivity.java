package br.com.controledepontos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.controledepontos.dao.PontoDAO;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Ponto;
import br.com.controledepontos.model.Situacao;

public class ConsultaPontoActivity extends AppCompatActivity {
    public static final String FIRST_COLUMN="First";
    public static final String SECOND_COLUMN="Second";
    public static final String THIRD_COLUMN="Third";
    public static final String FOURTH_COLUMN="Fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_ponto);

        final Funcionario funcionario;
        Intent intent = getIntent();
        if(intent.hasExtra("funcionario")){
            funcionario = (Funcionario) intent.getSerializableExtra("funcionario");
        }else{
            funcionario = null;
        }

        ImageView imgVoltar = findViewById(R.id.imgVoltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ListView lista = findViewById(R.id.ltvLista);
        ArrayList<HashMap<String, String>> dados = new ArrayList<HashMap<String,String>>();
        List<Ponto> pontos = null;
        try {
             pontos = new PontoDAO(ConsultaPontoActivity.this).pesquisar(funcionario.getCodigo());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Ponto ponto : pontos){
            HashMap<String,String> hashmap = new HashMap<String, String>();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            hashmap.put(FIRST_COLUMN, data.format(ponto.getDataHora()));
            if((ponto.getSituacao()).equals(Situacao.ENTRADA)){
                hashmap.put(SECOND_COLUMN, hora.format(ponto.getDataHora()));
                hashmap.put(THIRD_COLUMN, "00:00");
            }else{
                hashmap.put(SECOND_COLUMN, "00:00");
                hashmap.put(THIRD_COLUMN, hora.format(ponto.getDataHora()));
            }
            hashmap.put(FOURTH_COLUMN, "00:00");
            dados.add(hashmap);
        }
        AdaptadorLista adaptador = new AdaptadorLista(this, dados);

        lista.setAdapter(adaptador);

    }
}