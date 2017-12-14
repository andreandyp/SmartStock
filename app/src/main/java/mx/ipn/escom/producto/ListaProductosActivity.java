package mx.ipn.escom.producto;

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

import mx.ipn.escom.R;

public class ListaProductosActivity extends AppCompatActivity {

    private ListView listaProductos;
    private SimpleCursorAdapter adaptador;
    private TextView nohay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        listaProductos = findViewById(R.id.listaProductos);

        String id = this.getIntent().getExtras().getString("ID");
        actualizarListView(id);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //actualizarListView();
    }

    public void agregarProducto(View v){
        //startActivity(new Intent(this, NuevoInventarioActivity.class));
    }

    public void actualizarListView(String id){
        SQLiteDatabase bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);
        Cursor cursor = bd.rawQuery("SELECT rowid _id,idDispostivo FROM inventario_dispositivo WHERE idInventario = "+id, null);

        if(!cursor.moveToFirst()){
            return;
        }

        Cursor productos = bd.rawQuery("SELECT rowid _id, * FROM Dispositivo WHERE idDispositivo = "+cursor.getColumnName(cursor.getColumnIndex("idDispostivo")),null);

        nohay = findViewById(R.id.nohay);
        nohay.setVisibility(View.INVISIBLE);

        String from[] = new String []{"idDispositivo",  "nb_dispositivo", "marca"};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_producto, productos, from, new int[]{ R.id.dispositivoID, R.id.nombre, R.id.marca}, 0);
        listaProductos.setAdapter(adaptador);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),"Lista productos", Toast.LENGTH_LONG).show();
            }
        });

        cursor.close();
        productos.close();
    }
}