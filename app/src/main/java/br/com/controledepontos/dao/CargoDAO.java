package br.com.controledepontos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.controledepontos.data.ControlePontoContract;
import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.CargoEntry;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Turno;

public class CargoDAO {
    private SQLiteDatabase sqLiteDatabase;

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

    public List<Cargo> pesquisar(){
        List<Cargo> cargos = new ArrayList<>();
        String[] colunas = {CargoEntry._ID, CargoEntry.COLUNA_NOME, CargoEntry.COLUNA_TURNO};
        Cursor cursor = sqLiteDatabase.query(CargoEntry.TABELA_NOME, colunas, null, null, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                cargos.add(new Cargo(cursor.getInt(0), cursor.getString(1), Turno.valueOf(cursor.getString(2))));
            }while(cursor.moveToNext());
        }
        return cargos;
    }

    public Cargo pesquisar(Integer codigo){
        Cargo cargo = null;
        String[] colunas = {CargoEntry._ID, CargoEntry.COLUNA_NOME, CargoEntry.COLUNA_TURNO};
        String condicoes = CargoEntry._ID + " = ?";
        String[] parametros = {codigo.toString()};
        Cursor cursor = sqLiteDatabase.query(CargoEntry.TABELA_NOME, colunas, condicoes, parametros, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            cargo = new Cargo(cursor.getInt(0), cursor.getString(1), Turno.valueOf(cursor.getString(2)));
        }
        return cargo;
    }

    public List<Cargo> pesquisar(String nome){
        List<Cargo> cargos = new ArrayList<>();
        String[] colunas = {CargoEntry._ID, CargoEntry.COLUNA_NOME, CargoEntry.COLUNA_TURNO};
        String condicoes = CargoEntry.COLUNA_NOME + " = ?";
        String[] parametros = {nome};
        Cursor cursor = sqLiteDatabase.query(CargoEntry.TABELA_NOME, colunas, condicoes, parametros, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                cargos.add(new Cargo(cursor.getInt(0), cursor.getString(1), Turno.valueOf(cursor.getString(2))));
            }while(cursor.moveToNext());
        }
        return cargos;
    }

    public void excluir(String nome){
        sqLiteDatabase.delete(CargoEntry.TABELA_NOME, CargoEntry.COLUNA_NOME + " = ?", new String[]{nome});
    }


}
