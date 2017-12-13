package com.example.hector.sqlactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarProfesores extends AppCompatActivity {
    ListView lv ;
    ArrayList<String> listaP;
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_profesores);
        lv = (ListView)findViewById(R.id.listaProfesores);
        MyDBAdapter db = new MyDBAdapter(getApplicationContext(),null,null,1);
        listaP = db.llenar_lvProfesores();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaP);
        lv.setAdapter(adaptador);
    }
}
