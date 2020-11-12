package br.com.controledepontos.data;

import android.provider.BaseColumns;

public class ControlePontoContract {
    public static final class FuncionarioEntry implements BaseColumns{
        public static final String TABELA_NOME = "funcionario";
        public static final String COLUNA_USUARIO = "usuario_funcionario";
        public static final String COLUNA_SENHA = "senha_funcionario";
        public static final String COLUNA_EMAIL = "email_funcionario";
        public static final String COLUNA_NOME = "nome_funcionario";
        public static final String COLUNA_CARGO = "cargo_funcionario";
    }
    public static final class CargoEntry implements BaseColumns{
        public static final String TABELA_NOME = "cargo";
        public static final String COLUNA_NOME = "nome_cargo";
        public static final String COLUNA_TURNO = "turno_cargo";
    }
    public static final class PontoEntry implements BaseColumns{
        public static final String TABELA_NOME = "ponto";
        public static final String COLUNA_DATA = "data_ponto";
        public static final String COLUNA_HORARIO = "horario_ponto";
        public static final String COLUNA_SITUACAO = "situacao_ponto";
        public static final String COLUNA_FUNCIONARIO = "funcionario_ponto";
    }
}
