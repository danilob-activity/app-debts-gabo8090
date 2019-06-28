package com.example.danilo.appdebts.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.danilo.appdebts.classes.Debts;

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

    }

    public void remove(long id){

    }

    public void alter(Debts deb){

    }

    public List<Debts> listDebts(){
        return null;
    }

}
