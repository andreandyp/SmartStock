package mx.ipn.escom.producto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import mx.ipn.escom.R;

public class NuevoProductoActivity extends AppCompatActivity {

    private TextInputLayout nombre, serie, marca;
    private Spinner tipos;
    private SQLiteDatabase bd;
    private SimpleCursorAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        nombre = findViewById(R.id.nombre);
        serie = findViewById(R.id.serie);
        marca = findViewById(R.id.marca);
        tipos = findViewById(R.id.tipos);
        bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);

        inicializarTipos();
    }

    public void nuevoProducto(View v){
        String nNombre = nombre.getEditText().getText().toString(),
                nSerie = serie.getEditText().getText().toString(),
                nMarca = marca.getEditText().getText().toString();
        Toast.makeText(getBaseContext(), nNombre+" "+nSerie+" "+nMarca, Toast.LENGTH_LONG).show();
    }

    private void inicializarTipos(){
        //Cursor cursor = bd.rawQuery("SELECT rowid _id,* FROM Tipo_Dispositivo;", null);
        //adaptador = new SimpleCursorAdapter(this, R.layout.elemento_producto, productos, from, new int[]{ R.id.dispositivoID, R.id.nombre, R.id.marca}, 0);
    }
}
