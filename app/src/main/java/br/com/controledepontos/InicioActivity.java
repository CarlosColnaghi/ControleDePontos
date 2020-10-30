package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ImageView imgUsuario = findViewById(R.id.imgUsuario);
        imgUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirPerfilActivity = new Intent(InicioActivity.this, PerfilActivity.class);
                startActivity(abrirPerfilActivity);
            }
        });

        Button btnCadastroCargo = findViewById(R.id.btnCadastroCargo);
        btnCadastroCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCadastroCargoActivity = new Intent(InicioActivity.this, CadastroCargoActivity.class);
                startActivity(abrirCadastroCargoActivity);
            }
        });

        Button btnRegistroPonto = findViewById(R.id.btnRegistroPonto);
        btnRegistroPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirRegistroPontoActivity = new Intent(InicioActivity.this, RegistroPontoActivity.class);
                startActivity(abrirRegistroPontoActivity);
            }
        });

        Button btnConsultaPonto = findViewById(R.id.btnConsultaPonto);
        btnConsultaPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirConsultaPontoActivity = new Intent(InicioActivity.this, ConsultaPontoActivity.class);
                startActivity(abrirConsultaPontoActivity);
            }
        });


    }
}