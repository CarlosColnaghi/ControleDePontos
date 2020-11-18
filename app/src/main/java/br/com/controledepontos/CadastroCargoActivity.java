package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.controledepontos.dao.CargoDAO;
import br.com.controledepontos.dao.FuncionarioDAO;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Turno;

public class CadastroCargoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cargo);
        ImageView imgVoltar = findViewById(R.id.imgVoltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final EditText edtCargo = findViewById(R.id.edtCargo);
        final Button btnExcluirCargo = findViewById(R.id.btnExcluirCargo);
        final Button btnCadastrarCargo = findViewById(R.id.btnCadastrarCargo);
        desabilitar(btnCadastrarCargo);
        desabilitar(btnExcluirCargo);
        btnCadastrarCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CargoDAO(CadastroCargoActivity.this).inserir(new Cargo(null, edtCargo.getText().toString(), Turno.MANHA));
                Toast.makeText(CadastroCargoActivity.this, edtCargo.getText().toString() + " cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                edtCargo.setText("");
                desabilitar(btnCadastrarCargo);
                desabilitar(btnExcluirCargo);
            }
        });
        btnExcluirCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CargoDAO(CadastroCargoActivity.this).excluir(edtCargo.getText().toString());
                Toast.makeText(CadastroCargoActivity.this, edtCargo.getText().toString() + " excluido com sucesso", Toast.LENGTH_SHORT).show();
                edtCargo.setText("");
                desabilitar(btnCadastrarCargo);
                desabilitar(btnExcluirCargo);
            }
        });
        edtCargo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edtCargo.getText().toString().isEmpty()){
                    desabilitar(btnCadastrarCargo);
                    desabilitar(btnExcluirCargo);
                }else{
                    List<Cargo> cargos = new CargoDAO(CadastroCargoActivity.this).pesquisar(edtCargo.getText().toString());
                    if (cargos.size() > 0){
                        desabilitar(btnCadastrarCargo);
                        habilitar(btnExcluirCargo);
                    }else{
                        habilitar(btnCadastrarCargo);
                        desabilitar(btnExcluirCargo);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void desabilitar(Button botao){
        botao.setClickable(false);
        botao.setAlpha(.3f);
    }

    private  void habilitar(Button botao){
        botao.setClickable(true);
        botao.setAlpha(1);
    }
}