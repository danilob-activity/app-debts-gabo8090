package com.example.danilo.appdebts.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.classes.Category;
import com.example.danilo.appdebts.database.ScriptDLL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 27/06/19.
 */

public class CategoryDAO {
    private SQLiteDatabase mConnection;
    public CategoryDAO(SQLiteDatabase conection){
        mConnection = conection;
    }
    public void insert(Category cat){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tipo", cat.getTipo());
        mConnection.insertOrThrow("categoria", null, contentValues);
        Log.d("CategoryDAO", "Inserção realizada com sucesso!");
    }


    public void remove(long id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("categoria","id = ?", params);
    }


    public void alter(Category cat){
        
    }

    public List<Category> listCategories(){

        List<Category> categories = new ArrayList<Category>();
        Cursor result = mConnection.rawQuery(ScriptDLL.getCategories(),null);
        if(result.getCount()>0){
            result.moveToFirst();
            do{
                Category cat = new Category();
                cat.setId(result.getLong(result.getColumnIndexOrThrow("id")));
                cat.setTipo(result.getString(result.getColumnIndexOrThrow("tipo")));
                categories.add(cat);
                Log.d("CategoryDAO","Listando -- Id: "+cat.getId()+"Nome: "+cat.getTipo());
            }while(result.moveToNext());
            result.close();
        }
        return categories;

    }


    public Category getCategory(long id){

        Category cat = new Category();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        Cursor result = mConnection.rawQuery(ScriptDLL.setCategories(),params);
        if(result.getCount()>0){
            result.moveToFirst();
            cat.setId(result.getInt(result.getColumnIndexOrThrow("id")));
            cat.setTipo(result.getString(result.getColumnIndexOrThrow("tipo")));
            result.close();
            return cat;
        }
        return null;
    }


}
