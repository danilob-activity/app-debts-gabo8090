package com.example.danilo.appdebts.classes;

/**
 * Created by aluno on 27/06/19.
 */

public class Debts {

    private long mId;
    private Category mCategoria;
    private float mValor;
    private String mDescricao;
    private String mDataVencimento;
    private String mDataPagamento;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public Category getCategoria() {
        return mCategoria;
    }

    public void setCategoria(Category mCategoria) {
        this.mCategoria = mCategoria;
    }

    public float getValor() {
        return mValor;
    }

    public void setValor(float mValor) {
        this.mValor = mValor;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public void setDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public String getDataVencimento() {
        return mDataVencimento;
    }

    public void setDataVencimento(String mDataVencimento) {
        this.mDataVencimento = mDataVencimento;
    }

    public String getDataPagamento() {
        return mDataPagamento;
    }

    public void setDataPagamento(String mDataPagamento) {
        this.mDataPagamento = mDataPagamento;
    }


    public Debts() {

    }

    public Debts(Category categoria, String descricao, float val, String dataVenc, String dataPg){
        this.mCategoria = categoria;
        this.mDescricao = descricao;
        this.mValor = val;
        this.mDataVencimento = dataVenc;
        this.mDataPagamento = dataPg;
    }


}
