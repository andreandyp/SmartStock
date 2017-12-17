package mx.ipn.escom.producto.tipos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import mx.ipn.escom.R;

public class ListaTiposActivity extends AppCompatActivity {
    private ListView listaTipos;
    private SimpleCursorAdapter adaptador;
    private TextView nohay;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tipos);

        listaTipos = (ListView) findViewById(R.id.listaTipos);
        nohay = findViewById(R.id.nohay);
        bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);

        actualizarListView();

        listaTipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteCursor cursor = (SQLiteCursor) listaTipos.getItemAtPosition(position);

                String idTipo = cursor.getString(cursor.getColumnIndex("idTipo")),
                        nombre = cursor.getString(cursor.getColumnIndex("nb_tipo")),
                        descripcion = cursor.getString(cursor.getColumnIndex("tx_descripcion"));

                Intent abrir = new Intent(getBaseContext(), TipoActivity.class);
                Bundle datos = new Bundle();
                datos.putString("Nombre", nombre);
                datos.putString("Número", idTipo);
                datos.putString("Descripción", descripcion);
                abrir.putExtras(datos);

                startActivity(abrir);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarListView();
    }

    public void agregarTipo(View v){
        startActivity(new Intent(this, TipoActivity.class));
    }

    public void actualizarListView(){
        Cursor cursor = bd.rawQuery("SELECT rowid _id,* FROM Tipo_Dispositivo", null);

        if(!cursor.moveToFirst()){
            nohay.setVisibility(View.VISIBLE);
        }else{
            nohay.setVisibility(View.INVISIBLE);
        }

        String from[] = new String []{"nb_tipo", "tx_descripcion"};
        int to[] = new int[]{R.id.nombreTipo, R.id.descripcionTipo};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_tipo, cursor, from, to, 0);
        listaTipos.setAdapter(adaptador);

    }

}
