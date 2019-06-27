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
