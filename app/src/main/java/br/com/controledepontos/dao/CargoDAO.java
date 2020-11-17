package br.com.controledepontos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.CargoEntry;
import br.com.controledepontos.model.Cargo;

public class CargoDAO {
    private static SQLiteDatabase sqLiteDatabase;

    public CargoDAO(Context context){
        ControlePontoHelper controlePontoHelper = new ControlePontoHelper(context);
        sqLiteDatabase = controlePontoHelper.getWritableDatabase();
    }

    public void inserir(Cargo cargo){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CargoEntry.COLUNA_NOME, cargo.getNome());
        contentValues.put(CargoEntry.COLUNA_TURNO, cargo.getTurno().toString());
        sqLiteDatabase.insert(CargoEntry.TABELA_NOME, null, contentValues);
    }

}
