package com.example.danilo.appdebts;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.danilo.appdebts.classes.Category;
import com.example.danilo.appdebts.classes.Debts;
import com.example.danilo.appdebts.dao.CategoryDAO;
import com.example.danilo.appdebts.database.DataBaseHelper;

public class TelaInicial extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DataBaseHelper mDataHelper;
    private ConstraintLayout mLayout;
    //private CategoryDAO mCategoryDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        mLayout = findViewById(R.id.layout);

        createConnection();
        Category cat = new Category("tia do lanche");
        CategoryDAO catDAO = new CategoryDAO(mConection);
        catDAO.insert(cat);
        catDAO.listCategories();
    }



    private void createConnection() {
        try {
            mDataHelper = new DataBaseHelper(this);
            mConection = mDataHelper.getWritableDatabase();
            Snackbar.make(mLayout, R.string.sucess_conection, Snackbar.LENGTH_LONG).show();
        } catch (SQLException e) {
            Snackbar.make(mLayout, e.toString(), Snackbar.LENGTH_LONG).show();
        }
    }

    public void populateDatabase(){
        //createConnection();
        //Category cat1 = new Category("");
        //cat1 = mCategoryDao.insert(cat1);

        //Debts debt1 = new Debts(cat1, (float)79.80, );
        //debt1 = mDebtsDao.insert(debt1);
    }
}
