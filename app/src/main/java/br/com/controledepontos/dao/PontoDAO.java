package br.com.controledepontos.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.controledepontos.data.ControlePontoContract;
import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.PontoEntry;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Ponto;
import br.com.controledepontos.model.Situacao;
import br.com.controledepontos.model.Turno;
import br.com.controledepontos.data.ControlePontoContract.PontoEntry;

public class PontoDAO {

    private SQLiteDatabase sqLiteDatabase;

    public PontoDAO(Context context){
        ControlePontoHelper controlePontoHelper = new ControlePontoHelper(context);
        sqLiteDatabase = controlePontoHelper.getWritableDatabase();
    }

    @SuppressLint("SimpleDateFormat")
    public void inserir(Ponto ponto){
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        contentValues.put(PontoEntry.COLUNA_DATA, simpleDateFormat.format(ponto.getDataHora()));
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        contentValues.put(PontoEntry.COLUNA_HORARIO, simpleDateFormat.format(ponto.getDataHora()));
        contentValues.put(PontoEntry.COLUNA_SITUACAO, ponto.getSituacao().toString());
        contentValues.put(PontoEntry.COLUNA_FUNCIONARIO, ponto.getFuncionario().getCodigo());
        sqLiteDatabase.insert(PontoEntry.TABELA_NOME, null, contentValues);
    }

    public List<Ponto> pesquisar(Integer codigo) throws ParseException {
        List<Ponto> pontos = new ArrayList<>();
        String[] colunas = {PontoEntry._ID, PontoEntry.COLUNA_DATA, PontoEntry.COLUNA_HORARIO, PontoEntry.COLUNA_SITUACAO, PontoEntry.COLUNA_FUNCIONARIO};
        String condicoes = PontoEntry.COLUNA_FUNCIONARIO + " = ?";
        String[] parametros = {codigo.toString()};
        Cursor cursor = sqLiteDatabase.query(PontoEntry.TABELA_NOME, colunas, condicoes, parametros, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm");
            do{
                String dataHora = cursor.getString(1) + " " + cursor.getString(2);
                pontos.add(new Ponto(cursor.getInt(0), simpleDateFormat.parse(dataHora), Situacao.valueOf(cursor.getString(3)), null));
            }while(cursor.moveToNext());
        }
        return pontos;
    }

    public Situacao pesquisarSituacao(Integer codigo) {
        List<Ponto> pontos = new ArrayList<>();
        String[] colunas = {PontoEntry._ID, PontoEntry.COLUNA_DATA, PontoEntry.COLUNA_HORARIO, PontoEntry.COLUNA_SITUACAO, PontoEntry.COLUNA_FUNCIONARIO};
        String condicoes = PontoEntry.COLUNA_FUNCIONARIO + " = ?";
        String[] parametros = {codigo.toString()};
        Cursor cursor = sqLiteDatabase.query(PontoEntry.TABELA_NOME, colunas, condicoes, parametros, null, null, PontoEntry._ID + " DESC", "1");
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return Situacao.valueOf(cursor.getString(3));
        }
        return Situacao.ENTRADA;
    }


}
