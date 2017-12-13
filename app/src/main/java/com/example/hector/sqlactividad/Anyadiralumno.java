package com.example.hector.sqlactividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.hector.sqlactividad.R.id.edadNuevoAlumno;
import static com.example.hector.sqlactividad.R.id.nombreNuevoAlumno;

public class Anyadiralumno extends AppCompatActivity {
    EditText Enombre, Eedad, Ecurso, Eciclo, Emedia;
    Button enviarEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadiralumno);

        //Asignamos
        Enombre = (EditText) findViewById(R.id.nombreNuevoAlumno);
        Eedad = (EditText) findViewById(R.id.edadNuevoAlumno);
        Ecurso = (EditText) findViewById(R.id.cursoNuevoAlumno);
        Eciclo = (EditText) findViewById(R.id.cicloNuevoAlumno);
        Emedia = (EditText) findViewById(R.id.mediaAlumnoNuevo);
        enviarEstudiante = (Button) findViewById(R.id.btnenviaralumno);

        enviarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Enombre.getText().toString().isEmpty() || Eedad.getText().toString().isEmpty() ||
                        Eciclo.getText().toString().isEmpty() || Ecurso.getText().toString().isEmpty()
                        || Emedia.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                } else {
                    MyDBAdapter db = new MyDBAdapter(getApplicationContext(), null, null, 1);
                    String nombre = Enombre.getText().toString();
                    String edad = Eedad.getText().toString();
                    String curso = Ecurso.getText().toString();
                    String ciclo = Eciclo.getText().toString();
                    String nota_media = Emedia.getText().toString();
                    String mensaje = db.guardarEstudiantes(nombre, edad, curso, ciclo, nota_media);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}

