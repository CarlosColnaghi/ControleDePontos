package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.controledepontos.dao.CargoDAO;
import br.com.controledepontos.dao.FuncionarioDAO;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Turno;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ImageView imgVoltar = findViewById(R.id.imgVoltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final EditText edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        final EditText edtUsuario = findViewById(R.id.edtUsuario);
        final EditText edtEmail = findViewById(R.id.edtEmail);
        final EditText edtSenha = findViewById(R.id.edtSenha);
        EditText edtConfirmacaoSenha = findViewById(R.id.edtConfimacaoSenha);
        Button btnCadastarUsuario = findViewById(R.id.btnCadastrarUsuario);
        btnCadastarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cargo cargo = new Cargo(1, "Cargo", Turno.MANHA);
                Funcionario funcionario = new Funcionario(null, edtUsuario.getText().toString(), edtSenha.getText().toString(), edtEmail.getText().toString(), edtNomeCompleto.getText().toString(), cargo);
                new FuncionarioDAO(CadastroActivity.this).inserir(funcionario);
            }
        });
    }
}