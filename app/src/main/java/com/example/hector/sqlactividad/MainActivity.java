package com.example.hector.sqlactividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
    private Button botonAnyadirAlumno;
    private Button botonEliminarAlumno;
    private Button botonAnyadirProfesor;
    private Button botonEliminarProfesor;
    private Button botonListarAlumno;
    private Button botonListarProfesor;
    private Button botonFiltrar;

    private Button botonAnyadirAsignatura;
    private Button botonBuscarAsignatura;
    private final int SUBACT_1 = 345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        botonAnyadirAlumno = (Button) findViewById(R.id.anyadirest);
        botonAnyadirProfesor = (Button) findViewById(R.id.anyadirprofe);
        botonEliminarAlumno = (Button) findViewById(R.id.eliminarest);
        botonEliminarProfesor = (Button) findViewById(R.id.eliminarprofe);
        botonListarAlumno = (Button) findViewById(R.id.listaest);
        botonListarProfesor = (Button) findViewById(R.id.listaprofe);
        botonFiltrar = (Button) findViewById(R.id.filtrarambos);
        botonAnyadirAsignatura = (Button) findViewById(R.id.btnAnyadirAsignatura);
        botonBuscarAsignatura= (Button) findViewById(R.id.btnBuscarAsignatura);

        botonBuscarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarAsignaturas.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonAnyadirAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Anyadirasignatura.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        botonAnyadirAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Anyadiralumno.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonAnyadirProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Anyadirprofesor.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonEliminarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Eliminaralumno.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonEliminarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Eliminarprofesor.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        botonListarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarEstudiantes.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonListarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarProfesores.class);
                startActivityForResult(i, SUBACT_1);
            }
        });

        botonFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Filtros.class);
                startActivityForResult(i, SUBACT_1);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}