package mx.ipn.escom.producto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;

import mx.ipn.escom.R;
import mx.ipn.escom.producto.tipos.ListaTiposActivity;
import mx.ipn.escom.producto.tipos.TipoActivity;

public class NuevoProductoActivity extends AppCompatActivity {

    private TextInputLayout nombre, serie, marca;
    private BetterSpinner tipos;
    private SQLiteDatabase bd;
    private SimpleCursorAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        nombre = findViewById(R.id.nombre);
        serie = findViewById(R.id.serie);
        marca = findViewById(R.id.marca);
        tipos = (BetterSpinner) findViewById(R.id.tipos);
        bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);

        /*tipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Hue: "+i, Toast.LENGTH_SHORT).show();
            }
        });*/

        inicializarTipos();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        inicializarTipos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editar_tipos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.agregarTipo:
                startActivity(new Intent(NuevoProductoActivity.this, TipoActivity.class));
                return true;
            case R.id.editarTipo:
                startActivity(new Intent(NuevoProductoActivity.this, ListaTiposActivity.class));
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nuevoProducto(View v){
        String nNombre = nombre.getEditText().getText().toString(),
                nSerie = serie.getEditText().getText().toString(),
                nMarca = marca.getEditText().getText().toString(),
                nTipo = tipos.getText().toString();
        Toast.makeText(getBaseContext(), nNombre+" "+nSerie+" "+nMarca+" "+nTipo, Toast.LENGTH_LONG).show();
    }

    private void inicializarTipos(){
        Cursor cursor = bd.rawQuery("SELECT rowid _id,nb_tipo FROM Tipo_Dispositivo;", null);
        ArrayList<String> list = new ArrayList<String>();
        if(!cursor.moveToFirst()){
            tipos.setHint("Agrega tipos en el menú superior");
        }else{
            tipos.setHint("Selecciona un tipo de dispositivo");
            do{
                list.add(cursor.getString(cursor.getColumnIndex("nb_tipo")));
            }
            while (cursor.moveToNext());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipos.setAdapter(dataAdapter);

    }
}
