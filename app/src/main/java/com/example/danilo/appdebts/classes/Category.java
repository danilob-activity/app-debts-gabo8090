package com.example.danilo.appdebts.classes;

/**
 * Created by aluno on 27/06/19.
 */

public class Category {
    private long mId;
    private String mTipo;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getTipo() {
        return mTipo;
    }

    public void setTipo(String mTipo) {
        this.mTipo = mTipo;
    }

    public Category(String tipo){
        setTipo(tipo);
    }

    public Category(){

    }

}
