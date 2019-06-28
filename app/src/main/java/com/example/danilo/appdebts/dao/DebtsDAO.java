package com.example.danilo.appdebts.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.classes.Category;
import com.example.danilo.appdebts.classes.Debts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 27/06/19.
 */

public class DebtsDAO {
    private SQLiteDatabase mConnection;

    public DebtsDAO(SQLiteDatabase conection){
        mConnection = conection;
    }

    public void insert(Debts deb){
        ContentValues contentValues = new ContentValues();
        contentValues.put("descricao", deb.getDescricao());
        contentValues.put("valor", deb.getValor());
        contentValues.put("data_vencimento", deb.getDataVencimento());
        contentValues.put("data_pagamento", deb.getDataPagamento());
        contentValues.put("cod_cat", deb.getCategoria().getId());
        mConnection.insertOrThrow("divida", null, contentValues);
        Log.d("DebtsDAO", "Inserção realizada com sucesso!");

    }

    public void remove(long id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("Debts", "id = ?", params);
    }

    public void alter(Debts deb){
        ContentValues contentValues = new ContentValues();
        contentValues.put("descricao", deb.getDescricao());
        contentValues.put("valor", deb.getValor());
        contentValues.put("data_vencimento", deb.getDataVencimento());
        contentValues.put("data_pagamento", deb.getDataPagamento());
        contentValues.put("cod_cat", deb.getCategoria().getId());
        String[] params = new String[1];
        params[0] = String.valueOf(deb.getId());
        mConnection.update("divida", contentValues, "id = ?", params);
    }

    public List<Debts> listDebts(){
        List<Debts> divida = new ArrayList<Debts>();

        Cursor result = mConnection.rawQuery("select id, tipo from divida", null);

        if(result.getCount()>0){
            result.moveToFirst();
            CategoryDAO categoryDAO = new CategoryDAO(mConnection);
            do{
                Debts deb = new Debts();
                Category cat = categoryDAO.getCategory(result.getInt(result.getColumnIndexOrThrow("cod_cat")));
                deb.setId(result.getInt(result.getColumnIndexOrThrow("id")));
                deb.setValor(result.getFloat(result.getColumnIndexOrThrow("valor")));
                deb.setDescricao(result.getString(result.getColumnIndexOrThrow("descricao")));
                deb.setDataVencimento(result.getString(result.getColumnIndexOrThrow("data_vencimento")));
                deb.setDataPagamento(result.getString(result.getColumnIndexOrThrow("data_pagamento")));
                deb.setCategoria(cat);
                divida.add(deb);
                Log.d("DebtsDAO","Listando -- Id: "+ deb.getId()+" -- Descrição "+ deb.getDescricao()+" -- Valor " + deb.getValor());
            }while(result.moveToNext());
            result.close();
        }



        return divida;
    }


    public Debts getDebts(long id){
        Debts deb = new Debts();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        CategoryDAO categoryDAO = new CategoryDAO(mConnection);
        Cursor result = mConnection.rawQuery("Select * from categoria where id='?'",params);
        if(result.getCount()>0){
            result.moveToFirst();
            Category cat = categoryDAO.getCategory(result.getInt(result.getColumnIndexOrThrow("cod_cat")));
            deb.setId(result.getLong(result.getColumnIndexOrThrow("id")));
            deb.setValor(result.getFloat(result.getColumnIndexOrThrow("valor")));
            deb.setDescricao(result.getString(result.getColumnIndexOrThrow("descricao")));
            deb.setDataVencimento(result.getString(result.getColumnIndexOrThrow("data_vencimento")));
            deb.setDataPagamento(result.getString(result.getColumnIndexOrThrow("data_pagamento")));
            deb.setCategoria(cat);
            result.close();
            return deb;
        }

        return null;

    }

}


