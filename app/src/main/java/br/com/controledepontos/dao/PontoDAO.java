package br.com.controledepontos.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.PontoEntry;
import br.com.controledepontos.model.Ponto;
import br.com.controledepontos.model.Situacao;

public class PontoDAO {

    private SQLiteDatabase sqLiteDatabase;

    public PontoDAO(Context context){
        ControlePontoHelper controlePontoHelper = new ControlePontoHelper(context);
        sqLiteDatabase = controlePontoHelper.getWritableDatabase();
    }

    @SuppressLint("SimpleDateFormat")
    public static void inserir(Ponto ponto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PontoEntry._ID, ponto.getCodigo());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        contentValues.put(PontoEntry.COLUNA_DATA, simpleDateFormat.format(ponto.getData()));
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        contentValues.put(PontoEntry.COLUNA_HORARIO, simpleDateFormat.format(ponto.getHorario()));
        contentValues.put(PontoEntry.COLUNA_SITUACAO, ponto.getSituacao().toString());
    }

}
