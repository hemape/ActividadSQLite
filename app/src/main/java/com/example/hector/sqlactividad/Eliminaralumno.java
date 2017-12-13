package com.example.hector.sqlactividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminaralumno extends AppCompatActivity {

    EditText idE;
    Button eliminarEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminaralumno);

        idE = (EditText) findViewById(R.id.idEstudianteABorrar);
        eliminarEstudiante = (Button) findViewById(R.id.btnBorrarAlumno);

        eliminarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idE.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Introduce un ID", Toast.LENGTH_SHORT).show();

                } else {
                    MyDBAdapter db = new MyDBAdapter(getApplicationContext(), null, null, 1);
                    String idEstu = idE.getText().toString();
                    Integer id = Integer.valueOf(idEstu);
                    String mensaje = db.eliminarEstudiante(id);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
