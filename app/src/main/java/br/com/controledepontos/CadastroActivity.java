package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.controledepontos.dao.CargoDAO;
import br.com.controledepontos.dao.FuncionarioDAO;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Turno;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtNomeCompleto;
    private EditText edtUsuario;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtConfimacaoSenha;
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

        edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfimacaoSenha = findViewById(R.id.edtConfimacaoSenha);

        Button btnCadastarUsuario = findViewById(R.id.btnCadastrarUsuario);
        btnCadastarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    Cargo cargo = new Cargo(1, "Cargo", Turno.MANHA);
                    Funcionario funcionario = new Funcionario(null, edtUsuario.getText().toString(), edtSenha.getText().toString(), edtEmail.getText().toString(), edtNomeCompleto.getText().toString(), cargo);
                    new FuncionarioDAO(CadastroActivity.this).inserir(funcionario);
                    Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean validar(){
        if(TextUtils.isEmpty(edtNomeCompleto.getText().toString())){
            edtNomeCompleto.setError("O campo " + edtNomeCompleto.getHint().toString() + " precisa ser preenchido");
            edtNomeCompleto.requestFocus();
        }else if(TextUtils.isEmpty(edtUsuario.getText().toString())){
            edtUsuario.setError("O campo " + edtUsuario.getHint().toString() + " precisa ser preenchido");
            edtUsuario.requestFocus();
        }else if(TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("O campo " + edtEmail.getHint().toString() + " precisa ser preenchido");
            edtEmail.requestFocus();
        }else if(TextUtils.isEmpty(edtSenha.getText().toString())){
            edtSenha.setError("O campo " + edtSenha.getHint().toString() + " precisa ser preenchido");
            edtSenha.requestFocus();
        }else if(TextUtils.isEmpty(edtConfimacaoSenha.getText().toString())){
            edtConfimacaoSenha.setError("Campo " + edtConfimacaoSenha.getHint().toString() + " precisa ser preenchido");
            edtConfimacaoSenha.requestFocus();
        }else if(!edtSenha.getText().toString().equals(edtConfimacaoSenha.getText().toString())){
            edtConfimacaoSenha.setError("Os campos "+ edtSenha.getHint().toString() + " e " + edtConfimacaoSenha.getHint().toString() + " precisam ser iguais");
            edtConfimacaoSenha.requestFocus();
        }else{
            return true;
        }
        return false;
    }
}