package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.controledepontos.dao.CargoDAO;
import br.com.controledepontos.dao.FuncionarioDAO;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Turno;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuarioLogin;
    private EditText edtSenhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuarioLogin = findViewById(R.id.edtUsuarioLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validar()){
                    Funcionario funcionario = new FuncionarioDAO(MainActivity.this).login(edtUsuarioLogin.getText().toString(), edtSenhaLogin.getText().toString());
                    if(funcionario != null){
                        funcionario.setCargo(new CargoDAO(MainActivity.this).pesquisar(funcionario.getCargo().getCodigo()));
                        Intent abrirInicioActivity = new Intent(MainActivity.this, InicioActivity.class);
                        abrirInicioActivity.putExtra("funcionario", funcionario);
                        startActivity(abrirInicioActivity);
                        edtUsuarioLogin.setText(null);
                        edtSenhaLogin.setText(null);
                    }else{
                        Toast.makeText(MainActivity.this, edtUsuarioLogin.getHint().toString() +" e/ou " + edtSenhaLogin.getHint().toString() + " estão incorretas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCadastroActivity = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(abrirCadastroActivity);
            }
        });
    }
    boolean validar(){
        if(TextUtils.isEmpty(edtUsuarioLogin.getText().toString())){
            edtUsuarioLogin.setError("O campo " + edtUsuarioLogin.getHint().toString() + " precisa ser preenchido");
            edtUsuarioLogin.requestFocus();
        }else if(TextUtils.isEmpty(edtSenhaLogin.getText().toString())){
            edtSenhaLogin.setError("O campo " + edtSenhaLogin.getHint().toString() + " precisa ser preenchido");
            edtSenhaLogin.requestFocus();
        }else{
            return true;
        }
        return false;
    }
}