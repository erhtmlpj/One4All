package com.example.aparicio.one4all;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Aparicio on 18/10/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context)
    {
        banco = new CriaBanco(context);
    }

    //ESSA É A PARTE REFERENTE À INSERÇÃO DE DADOS NO BANCO DE DADOS

    public String insereDadosRede(String codigo, String IPv4Admin, String nome, String nomeAdmin, String senha)
    {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigo",codigo);
        valores.put("IPv4Admin",IPv4Admin);
        valores.put("nome",nome);
        valores.put("nomeAdmin",nomeAdmin);
        valores.put("senha",senha);

        resultado = db.insert("rede",null,valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadosUsuario(String codigoUsuario, String IPv4, String nome, String caminhoD, String caminhoP)
    {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigoUsuario",codigoUsuario);
        valores.put("IPv4",IPv4);
        valores.put("nome",nome);
        valores.put("caminhoD",caminhoD);
        valores.put("caminhoP",caminhoP);

        resultado = db.insert("usuario",null,valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadosMembro(String codigoMembro, String codigoRede, String codigoUsuario)
    {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigoMembro",codigoMembro);
        valores.put("codigoRede",codigoRede);
        valores.put("codigoUsuario",codigoUsuario);

        resultado = db.insert("membro",null,valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadosArqUsuario(String codigoArquivo, String caminho, String tamanho, String nome, String codigoUsuario)
    {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigoArquivo",codigoArquivo);
        valores.put("caminho",caminho);
        valores.put("tamanho",tamanho);
        valores.put("nome",nome);
        valores.put("codigoUsuario",codigoUsuario);

        resultado = db.insert("arqUsuario",null,valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    //ESSA É A PARTE REFERENTE À LISTAGEM DE DADOS

    public Cursor carregaDadosRede()
    {
        Cursor cursor;
        String[] campos = {"codigo","IPv4Admin","nome","nomeAdmin","senha"};
        db = banco.getReadableDatabase();
        cursor = db.query("rede",campos,null,null,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosMembro()
    {
        Cursor cursor;
        String[] campos = {"codigoMembro","codigoRede","codigoUsuario"};
        db = banco.getReadableDatabase();
        cursor = db.query("membro",campos,null,null,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosUsuario()
    {
        Cursor cursor;
        String[] campos = {"codigoUsuario","IPv4","nome","caminhoD","caminhoP"};
        db = banco.getReadableDatabase();
        cursor = db.query("usuario",campos,null,null,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosArqUsuario()
    {
        Cursor cursor;
        String[] campos = {"codigoArquivo","caminho","tamanho","nome","codigoUsuario"};
        db = banco.getReadableDatabase();
        cursor = db.query("arqUsuario",campos,null,null,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    //ESSA É A PARTE REFERENTE À PESQUISA DE DADOS

    public Cursor carregaDadosRedeById(int codigo)
    {
        Cursor cursor;
        String[] campos = {"codigo","IPv4Admin","nome","nomeAdmin","senha"};
        String where = "codigo" + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query("rede",campos,where,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosMembroById(int codigoMembro)
    {
        Cursor cursor;
        String[] campos = {"codigoMembro","codigoRede","codigoUsuario"};
        String where = "codigoMembro" + "=" + codigoMembro;
        db = banco.getReadableDatabase();
        cursor = db.query("membro",campos,where,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosUsuarioById(int codigoUsuario)
    {
        Cursor cursor;
        String[] campos = {"codigoUsuario","IPv4","nome","caminhoD","caminhoP"};
        String where = "codigoUsuario" + "=" + codigoUsuario;
        db = banco.getReadableDatabase();
        cursor = db.query("usuario",campos,where,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosArqUsuarioById(int codigoArquivo)
    {
        Cursor cursor;
        String[] campos = {"codigoArquivo","caminho","tamanho","nome","codigoUsuario"};
        String where = "codigoArquivo" + "=" + codigoArquivo;
        db = banco.getReadableDatabase();
        cursor = db.query("arqUsuario",campos,where,null,null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    //ESSA É A PARTE REFERENTE À ALTERAÇÃO DE DADOS

    public void alteraRegistroRede(String codigo, String IPv4Admin, String nome, String nomeAdmin, String senha)
    {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "codigo" + "=" + codigo;

        valores = new ContentValues();
        valores.put("codigo",codigo);
        valores.put("IPv4Admin",IPv4Admin);
        valores.put("nome",nome);
        valores.put("nomeAdmin",nomeAdmin);
        valores.put("senha",senha);

        db.update("rede",valores,where,null);
        db.close();

    }

    public void alteraRegistroMembro(String codigoMembro, String codigoRede, String codigoUsuario)
    {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "codigoMembro" + "=" + codigoMembro;

        valores = new ContentValues();
        valores.put("codigoMembro",codigoMembro);
        valores.put("codigoRede",codigoRede);
        valores.put("codigoUsuario",codigoUsuario);

        db.update("membro",valores,where,null);
        db.close();

    }

    public void alteraRegistroUsuario(String codigoUsuario, String IPv4, String nome, String caminhoD, String caminhoP)
    {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "codigoUsuario" + "=" + codigoUsuario;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigoUsuario",codigoUsuario);
        valores.put("IPv4",IPv4);
        valores.put("nome",nome);
        valores.put("caminhoD",caminhoD);
        valores.put("caminhoP",caminhoP);

        db.update("usuario",valores,where,null);
        db.close();

    }

    public void alteraRegistroArqUsuario(String codigoArquivo, String caminho, String tamanho, String nome, String codigoUsuario)
    {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "codigoArquivo" + "=" + codigoArquivo;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("codigoArquivo",codigoArquivo);
        valores.put("caminho",caminho);
        valores.put("tamanho",tamanho);
        valores.put("nome",nome);
        valores.put("codigoUsuario",codigoUsuario);

        db.update("arqUsuario",valores,where,null);
        db.close();

    }

    //ESSA É A PARTE REFERENTE À EXCLUSÃO DE DADOS

    public void deletaRegistroRede(String codigo)
    {
        String where = "codigo" + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete("rede",where,null);
        db.close();
    }

    public void deletaRegistroMembro(String codigoMembro)
    {
        String where = "codigoMembro" + "=" + codigoMembro;
        db = banco.getReadableDatabase();
        db.delete("membro",where,null);
        db.close();
    }

    public void deletaRegistroUsuario(String codigoUsuario)
    {
        String where = "codigoUsuario" + "=" + codigoUsuario;
        db = banco.getReadableDatabase();
        db.delete("Usuario",where,null);
        db.close();
    }

    public void deletaRegistroArqUsuario(String codigoArquivo)
    {
        String where = "codigoArquivo" + "=" + codigoArquivo;
        db = banco.getReadableDatabase();
        db.delete("arqUsuario",where,null);
        db.close();
    }

}
