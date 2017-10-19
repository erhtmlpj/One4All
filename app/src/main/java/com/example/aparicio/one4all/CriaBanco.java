package com.example.aparicio.one4all;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aparicio on 17/10/2017.
 */

public class CriaBanco extends SQLiteOpenHelper{


    private static final String NOME_DB = "one4all.db";

    private static final int VERSAO_BD = 1;

    private static final String LOG_TAG = "one4all";

    private final Context contexto = null;


    public CriaBanco(Context context)
    {
        super(context, NOME_DB,null,VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+"rede"+"("
                + "codigo" + "text primary key,"
                + "IPv4Admin" + "text,"
                + "nome" + "text,"
                + "nomeAdmin" + "text,"
                + "senha" + "text"
                +")";
        db.execSQL(sql);

        sql = "CREATE TABLE"+"membro"+"("
                + "codigoMembro" + "text primary key,"
                + "codigoRede" + "text,"
                + "codigoUsuario" + "text"
                +")";
        db.execSQL(sql);

        sql = "CREATE TABLE"+"usuario"+"("
                + "codigoUsuario" + "text primary key,"
                + "IPv4" + "text,"
                + "nome" + "text,"
                + "caminhoD" + "text,"
                + "caminhoP" + "text"
                +")";
        db.execSQL(sql);

        sql = "CREATE TABLE"+"arqUsuario"+"("
                + "codigoArquivo" + "text primary key,"
                + "caminho" + "text,"
                + "tamanho" + "text,"
                + "nome" + "text,"
                + "codigoUsuario" + "text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE TABLE IF EXISTS rede");
        db.execSQL("DROP TABLE TABLE IF EXISTS membros");
        db.execSQL("DROP TABLE TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE TABLE IF EXISTS arqUsuario");
        onCreate(db);
    }


}
