package com.example.hector.sqlactividad;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MyDBAdapter extends SQLiteOpenHelper {
    public MyDBAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Instituto", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table estudiantes(id integer primary key autoincrement, nombre_e text, edad_e text, curso_e text, ciclo_e text, nota_media_e text)");
        db.execSQL("create table profesores(id integer primary key autoincrement, nombre_p text, edad_p text, curso_p text, ciclo_p text, despacho_p text)");
        db.execSQL("create table asignaturas(id integer primary key autoincrement, nombre_a text, horas_a text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardarEstudiantes(String nombre,String edad, String curso, String ciclo, String nota_media) {
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("nombre_e", nombre);
        newValues.put("edad_e", edad);
        newValues.put("curso_e", curso);
        newValues.put("ciclo_e", ciclo);
        newValues.put("nota_media_e", nota_media);
        try {
            database.insertOrThrow("estudiantes", null, newValues);
            mensaje = "Estudiante ingresado correctamente";
        } catch (SQLException e) {
            mensaje = "No se ha podido ingresar el estudiante";
        }
        database.close();
        return mensaje;
    }

    public String guardarProfesores(String nombre, String edad, String curso, String ciclo, String despacho) {
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("nombre_p", nombre);
        newValues.put("edad_p", edad);
        newValues.put("curso_p", curso);
        newValues.put("ciclo_p", ciclo);
        newValues.put("despacho_p", despacho);
        try {
            database.insertOrThrow("profesores", null, newValues);
            mensaje = "Profesor ingresado correctamente";
        } catch (SQLException e) {
            mensaje = "No se ha podido ingresar el profesor";
        }
        database.close();
        return mensaje;
    }

    public String guardarAsignaturas(String nombre, String horas) {
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("nombre_a", nombre);
        newValues.put("horas_a", horas);

        try {
            database.insertOrThrow("asignaturas", null, newValues);
            mensaje = "Asignatura ingresada correctamente";
        } catch (SQLException e) {
            mensaje = "No se ha podido ingresar la asignatura";
        }
        database.close();
        return mensaje;
    }


    public String eliminarEstudiante(Integer idEstudiante) {
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        int cantidad = database.delete("estudiantes", "id='" + idEstudiante + "'", null);
        if (cantidad != 0) {
            mensaje = "Eliminado correctamente el estudiante con id: " + idEstudiante;

        } else {
            mensaje = "No existe";
        }
        database.close();
        return mensaje;
    }

    public String eliminarProfesor(Integer idProfesor) {
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        int cantidad = database.delete("profesores", "id='" + idProfesor + "'", null);
        if (cantidad != 0) {
            mensaje = "Eliminado correctamente el profesor con id: " + idProfesor;

        } else {
            mensaje = "No existe";
        }
        database.close();
        return mensaje;
    }

    public ArrayList llenar_lvEstudiantes() {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM estudiantes";
        Cursor registros = database.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                lista.add(registros.getString(1));
            } while (registros.moveToNext());
        }
        return lista;

    }

    public ArrayList llenar_lvProfesores() {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM profesores";
        Cursor registros = database.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                lista.add(registros.getString(1));
            } while (registros.moveToNext());
        }
        return lista;

    }

    public ArrayList llenar_lvAsignaturas() {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM asignaturas";
        Cursor registros = database.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                lista.add(registros.getString(1));
            } while (registros.moveToNext());
        }
        return lista;

    }
    public ArrayList filtroEstudiantes(String filtros){
        ArrayList<String> todosEstudiantes = new ArrayList<String>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM estudiantes "  + filtros + ";";
        Cursor registrosFiltrosE = database.rawQuery(q, null);

        if (registrosFiltrosE.moveToFirst()) {
            do {
                todosEstudiantes.add(registrosFiltrosE.getString(1));
            } while (registrosFiltrosE.moveToNext());
        }

        return todosEstudiantes;
    }



    public ArrayList filtroProfesores(String filtros){
        ArrayList<String> todosProfesores = new ArrayList<String>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM profesores "  + filtros + ";";
        Cursor registrosFiltrosP = database.rawQuery(q, null);

        if (registrosFiltrosP.moveToFirst()) {
            do {
                todosProfesores.add(registrosFiltrosP.getString(1));
            } while (registrosFiltrosP.moveToNext());

        }

        return todosProfesores;
    }

}
