package com.example.hector.sqlactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Anyadirasignatura extends AppCompatActivity {
    EditText Anombre, Ahoras;
    Button enviarAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadirasignatura);


        Anombre = (EditText) findViewById(R.id.nombreNuevaAsignatura);
        Ahoras = (EditText) findViewById(R.id.horasNuevaAsignatura);
        enviarAsignatura = (Button) findViewById(R.id.btnEnviarAsignaturaNueva);

        enviarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Anombre.getText().toString().isEmpty() || Ahoras.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                } else {
                    MyDBAdapter db = new MyDBAdapter(getApplicationContext(), null, null, 1);
                    String nombre = Anombre.getText().toString();
                    String horas = Ahoras.getText().toString();

                    String mensaje = db.guardarAsignaturas(nombre, horas);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}

