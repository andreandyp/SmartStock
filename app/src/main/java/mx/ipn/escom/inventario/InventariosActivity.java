package mx.ipn.escom.inventario;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.ipn.escom.R;

public class InventariosActivity extends AppCompatActivity {
    private ListView listaInventarios;
    private SimpleCursorAdapter adaptador;
    ArrayList<String> elementos;
    private TextView nohay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        listaInventarios = (ListView) findViewById(R.id.listaInventarios);

        actualizarListView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarListView();
    }

    public void agregarInventario(View v){
        startActivity(new Intent(this, NuevoInventarioActivity.class));
    }

    public void actualizarListView(){
        SQLiteDatabase bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);
        Cursor cursor = bd.rawQuery("SELECT rowid _id,* FROM Inventario", null);

        if(!cursor.moveToFirst()){
            return;
        }

        nohay = findViewById(R.id.nohay);
        nohay.setVisibility(View.INVISIBLE);

        String from[] = new String []{"nb_nombre"};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_inventario, cursor, from, new int[]{ R.id.nombre}, 0);
        listaInventarios.setAdapter(adaptador);

        listaInventarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"hue", Toast.LENGTH_LONG).show();
            }
        });

        cursor.close();
    }

}
