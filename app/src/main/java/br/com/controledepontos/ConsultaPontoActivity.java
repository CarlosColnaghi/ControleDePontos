package br.com.controledepontos;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsultaPontoActivity extends AppCompatActivity {
    public static final String FIRST_COLUMN="First";
    public static final String SECOND_COLUMN="Second";
    public static final String THIRD_COLUMN="Third";
    public static final String FOURTH_COLUMN="Fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_ponto);
        ImageView imgVoltar = findViewById(R.id.imgVoltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ListView lista = findViewById(R.id.ltvLista);
        ArrayList<HashMap<String, String>> dados = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> hashmap = new HashMap<String, String>();
        hashmap.put(FIRST_COLUMN, "20/09/2020");
        hashmap.put(SECOND_COLUMN, "09:00");
        hashmap.put(THIRD_COLUMN, "19:00");
        hashmap.put(FOURTH_COLUMN, "01:00");
        for(int i = 0; i < 100; i++){
            dados.add(hashmap);
        }
        AdaptadorLista adaptador = new AdaptadorLista(this, dados);

        lista.setAdapter(adaptador);

    }
}