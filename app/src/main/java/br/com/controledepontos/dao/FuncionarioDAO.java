package br.com.controledepontos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.FuncionarioEntry;
import br.com.controledepontos.model.Funcionario;

public class FuncionarioDAO {

    private static SQLiteDatabase sqLiteDatabase;

    public FuncionarioDAO(Context context){
        ControlePontoHelper controlePontoHelper = new ControlePontoHelper(context);
        sqLiteDatabase = controlePontoHelper.getWritableDatabase();
    }

    public static void inserir(Funcionario funcionario){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FuncionarioEntry._ID, funcionario.getCodigo());
        contentValues.put(FuncionarioEntry.COLUNA_USUARIO, funcionario.getUsuario());
        contentValues.put(FuncionarioEntry.COLUNA_SENHA, funcionario.getSenha());
        contentValues.put(FuncionarioEntry.COLUNA_EMAIL, funcionario.getEmail());
        contentValues.put(FuncionarioEntry.COLUNA_NOME, funcionario.getNome());
        contentValues.put(FuncionarioEntry.COLUNA_CARGO, funcionario.getCargo().getCodigo());
        sqLiteDatabase.insert(FuncionarioEntry.TABELA_NOME, null, contentValues);
    }

}
