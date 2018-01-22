package com.example.hector.sqlactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarAsignaturas extends AppCompatActivity {
    ListView lv ;
    ArrayList<String> listaA;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_listar_asignaturas);
            lv = (ListView)findViewById(R.id.listaAsignaturas);
            MyDBAdapter db = new MyDBAdapter(getApplicationContext(),null,null,1);
            listaA = db.llenar_lvAsignaturas();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaA);
            lv.setAdapter(adaptador);
    }
}
