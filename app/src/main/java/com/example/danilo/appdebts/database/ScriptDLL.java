package com.example.danilo.appdebts.database;

/**
 * Created by aluno on 26/06/19.
 */

public class ScriptDLL {

    public static String createTableCategory(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE categoria (");
        sql.append(" id INTEGER NOT NULL PRIMARY KEY,");
        sql.append(" tipo TEXT NOT NULL");
        sql.append(");");
        return sql.toString();
    }


    public static String createTableDebts(){
        StringBuilder sql1 = new StringBuilder();
        sql1.append("CREATE TABLE divida (");
        sql1.append(" id INTEGER PRIMARY KEY,");
        sql1.append(" cod_cat INTEGER NOT NULL,");
        sql1.append(" valor REAL NOT NULL,");
        sql1.append(" descricao TEXT NOT NULL,");
        sql1.append(" data_vencimento DATE NOT NULL,");
        sql1.append(" data_pagamento DATE,");
        sql1.append(" FOREIGN KEY (cod_cat) REFERENCES categoria(id)");
        sql1.append(");");
        return sql1.toString();
    }

    public static String getCategories(){
        return "select * from categoria";
    }

    public static String setCategories(){
        return "select * from categoria where id=?";
    }
}
