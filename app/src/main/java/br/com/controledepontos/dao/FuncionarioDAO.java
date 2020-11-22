package br.com.controledepontos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.controledepontos.data.ControlePontoHelper;
import br.com.controledepontos.data.ControlePontoContract.FuncionarioEntry;
import br.com.controledepontos.model.Cargo;
import br.com.controledepontos.model.Funcionario;
import br.com.controledepontos.model.Ponto;
import br.com.controledepontos.model.Turno;

public class FuncionarioDAO {

    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public FuncionarioDAO(Context context){
        ControlePontoHelper controlePontoHelper = new ControlePontoHelper(context);
        sqLiteDatabase = controlePontoHelper.getWritableDatabase();
        this.context = context;
    }

    public void inserir(Funcionario funcionario){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FuncionarioEntry.COLUNA_USUARIO, funcionario.getUsuario());
        contentValues.put(FuncionarioEntry.COLUNA_SENHA, funcionario.getSenha());
        contentValues.put(FuncionarioEntry.COLUNA_EMAIL, funcionario.getEmail());
        contentValues.put(FuncionarioEntry.COLUNA_NOME, funcionario.getNome());
        contentValues.put(FuncionarioEntry.COLUNA_CARGO, funcionario.getCargo().getCodigo());
        sqLiteDatabase.insert(FuncionarioEntry.TABELA_NOME, null, contentValues);
    }

    public Funcionario login(String usuario, String senha){
        Funcionario funcionario = null;
        String[] colunas = {FuncionarioEntry._ID, FuncionarioEntry.COLUNA_USUARIO, FuncionarioEntry.COLUNA_SENHA, FuncionarioEntry.COLUNA_EMAIL, FuncionarioEntry.COLUNA_NOME, FuncionarioEntry.COLUNA_CARGO};
        String condicoes = FuncionarioEntry.COLUNA_USUARIO + " = ? AND "  + FuncionarioEntry.COLUNA_SENHA + " = ?";
        String[] parametros = {usuario, senha};
        Cursor cursor = sqLiteDatabase.query(FuncionarioEntry.TABELA_NOME, colunas, condicoes, parametros, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            Cargo cargo = new CargoDAO(context).pesquisar(cursor.getInt(5));
            funcionario = new Funcionario(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cargo);
        }
        return funcionario;
    }

    public double calcularHoras(Integer codigo) throws ParseException {
        List<Ponto> pontos = new PontoDAO(context).pesquisar(codigo);
        double hora = 0;
        for(int i = 0; ((i+1) < pontos.size()); i+=2){
            Date horaEntrada = pontos.get(i).getDataHora();
            Date horaSaida = pontos.get(i+1).getDataHora();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(horaEntrada);
            double hora1 = calendar.get(Calendar.HOUR) + (calendar.get(Calendar.MINUTE)/60.0);
            calendar.setTime(horaSaida);
            double hora2 = calendar.get(Calendar.HOUR) + (calendar.get(Calendar.MINUTE)/60.0);
            hora += (hora2-hora1);
        }
        Log.i("info", String.valueOf(hora));
        return hora;
    }
}
