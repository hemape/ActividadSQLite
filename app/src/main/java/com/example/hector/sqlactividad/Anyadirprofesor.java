package com.example.hector.sqlactividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Anyadirprofesor extends AppCompatActivity {
    EditText Pnombre, Pedad, Pcurso, Pciclo, Pdespacho ;
    Button enviarProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadirprofesor);

        //Asignamos
        Pnombre = (EditText) findViewById(R.id.nombreNuevoProfesor);
        Pedad = (EditText) findViewById(R.id.edadNuevoProfesor);
        Pcurso = (EditText) findViewById(R.id.cursoNuevoProfesor);
        Pciclo = (EditText) findViewById(R.id.cicloNuevoProfesor);
        Pdespacho = (EditText) findViewById(R.id.despachoNuevoProfesor);
        enviarProfesor = (Button) findViewById(R.id.btnenviarprofe);

        enviarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pnombre.getText().toString().isEmpty() || Pedad.getText().toString().isEmpty() ||
                        Pciclo.getText().toString().isEmpty() || Pcurso.getText().toString().isEmpty()
                        || Pdespacho.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                } else {
                    MyDBAdapter db = new MyDBAdapter(getApplicationContext(), null, null, 1);
                    String nombre = Pnombre.getText().toString();
                    String edad = Pedad.getText().toString();
                    String curso = Pcurso.getText().toString();
                    String ciclo = Pciclo.getText().toString();
                    String despachito = Pdespacho.getText().toString();
                    String mensaje = db.guardarProfesores(nombre, edad, curso, ciclo, despachito);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}

