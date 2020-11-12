package br.com.controledepontos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.controledepontos.data.ControlePontoContract.FuncionarioEntry;
import br.com.controledepontos.data.ControlePontoContract.CargoEntry;
import br.com.controledepontos.data.ControlePontoContract.PontoEntry;
import br.com.controledepontos.model.Funcionario;

public class ControlePontoHelper extends SQLiteOpenHelper {
    private static final Integer DB_VERSAO = 1;
    private static final String DB_NOME = "controle_ponto.db";

    public ControlePontoHelper(Context context){
        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + FuncionarioEntry.TABELA_NOME + "(" +
                FuncionarioEntry._ID + " INTEGER PRIMARY KEY, " +
                FuncionarioEntry.COLUNA_USUARIO + " TEXT NOT NULL, " +
                FuncionarioEntry.COLUNA_SENHA + " TEXT NOT NULL, " +
                FuncionarioEntry.COLUNA_EMAIL + " TEXT NOT NULL, " +
                FuncionarioEntry.COLUNA_NOME + " TEXT NOT NULL, " +
                FuncionarioEntry.COLUNA_CARGO + " INTEGER NOT NULL, FOREIGN KEY (" + FuncionarioEntry.COLUNA_CARGO + ") REFERENCES " + CargoEntry.COLUNA_NOME + "(" + CargoEntry._ID + "));");

        sqLiteDatabase.execSQL("CREATE TABLE " + CargoEntry.TABELA_NOME + "(" +
                CargoEntry._ID + " INTEGER PRIMARY KEY, " +
                CargoEntry.COLUNA_NOME + " TEXT NOT NULL, " +
                CargoEntry.COLUNA_TURNO + " TEXT NOT NULL);");

        sqLiteDatabase.execSQL("CREATE TABLE " + PontoEntry.TABELA_NOME + "(" +
                PontoEntry._ID + " INTEGER PRIMARY KEY, " +
                PontoEntry.COLUNA_DATA + " DATE NOT NULL, " +
                PontoEntry.COLUNA_HORARIO + " TIME NOT NULL, " +
                PontoEntry.COLUNA_SITUACAO + " TEXT NOT NULL, " +
                PontoEntry.COLUNA_FUNCIONARIO + " INTEGER NOT NULL, FOREIGN KEY (" + PontoEntry.COLUNA_FUNCIONARIO + ") REFERENCES " + FuncionarioEntry.COLUNA_NOME + "(" + FuncionarioEntry._ID + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
