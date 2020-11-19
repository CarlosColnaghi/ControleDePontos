package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;


public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        final Funcionario funcionario;
        Intent intent = getIntent();
        if(intent.hasExtra("funcionario")){
            funcionario = (Funcionario) intent.getSerializableExtra("funcionario");
        }else{
            funcionario = null;
        }

        ImageView imgUsuario = findViewById(R.id.imgUsuario);
        imgUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirPerfilActivity = new Intent(InicioActivity.this, PerfilActivity.class);
                abrirPerfilActivity.putExtra("funcionario", funcionario);
                startActivity(abrirPerfilActivity);
            }
        });

        Button btnCadastroCargo = findViewById(R.id.btnCadastroCargo);
        btnCadastroCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCadastroCargoActivity = new Intent(InicioActivity.this, CadastroCargoActivity.class);
                abrirCadastroCargoActivity.putExtra("funcionario", funcionario);
                startActivity(abrirCadastroCargoActivity);
            }
        });

        Button btnRegistroPonto = findViewById(R.id.btnRegistroPonto);
        btnRegistroPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirRegistroPontoActivity = new Intent(InicioActivity.this, RegistroPontoActivity.class);
                abrirRegistroPontoActivity.putExtra("funcionario", funcionario);
                startActivity(abrirRegistroPontoActivity);
            }
        });

        Button btnConsultaPonto = findViewById(R.id.btnConsultaPonto);
        btnConsultaPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirConsultaPontoActivity = new Intent(InicioActivity.this, ConsultaPontoActivity.class);
                abrirConsultaPontoActivity.putExtra("funcionario", funcionario);
                startActivity(abrirConsultaPontoActivity);
            }
        });

        TextView txvSaudacao = findViewById(R.id.txvSaudacao);
        String saudacao = "Bom dia";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date hora = dateFormat.parse(dateFormat.format(new Date()));
            if(hora.after(dateFormat.parse("05:00")) && hora.before(dateFormat.parse("12:00"))){
                saudacao = "Bom dia";
            }else if(hora.after(dateFormat.parse("12:00")) && hora.before(dateFormat.parse("18:00"))) {
                saudacao = "Boa tarde";
            }else if(hora.after(dateFormat.parse("18:00"))){
                saudacao = "Boa noite";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (funcionario != null){
            saudacao += ", " + funcionario.getNome();
        }
        txvSaudacao.setText(saudacao);
    }
}