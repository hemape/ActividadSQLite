package com.example.hector.sqlactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarEstudiantes extends AppCompatActivity {
    ListView lv ;
    ArrayList<String> listaE;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_listar_estudiantes);
            lv = (ListView)findViewById(R.id.listaEstudiantes);
            MyDBAdapter db = new MyDBAdapter(getApplicationContext(),null,null,1);
            listaE = db.llenar_lvEstudiantes();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaE);
            lv.setAdapter(adaptador);
        }
}
