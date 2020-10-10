package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button btnCadastroCargo = findViewById(R.id.btnCadastroCargo);
        btnCadastroCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCadastroCargoActivity = new Intent(InicioActivity.this, CadastroCargoActivity.class);
                startActivity(abrirCadastroCargoActivity);
            }
        });

    }
}