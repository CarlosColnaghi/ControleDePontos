package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.controledepontos.dao.PontoDAO;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Ponto;
import br.com.controledepontos.model.Situacao;

public class RegistroPontoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ponto);

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
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Situacao situacao = new PontoDAO(RegistroPontoActivity.this).pesquisarSituacao(funcionario.getCodigo());
                if (situacao.equals(Situacao.ENTRADA)){
                    situacao = situacao.SAIDA;
                }else{
                    situacao = situacao.ENTRADA;
                }
                new PontoDAO(RegistroPontoActivity.this).inserir(new Ponto(null, new Date(), situacao, funcionario));
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm");

                Toast.makeText(RegistroPontoActivity.this, "Registro " + situacao.toString() + " cadastrado com sucesso às " + hora.format(new Date())+ " do dia " + data.format(new Date()), Toast.LENGTH_LONG).show();
                try {
                    new PontoDAO(RegistroPontoActivity.this).pesquisar(funcionario.getCodigo());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}