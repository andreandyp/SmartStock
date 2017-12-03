package mx.ipn.escom.inventario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mx.ipn.escom.R;

public class InventariosActivity extends AppCompatActivity {
    private ListView listaInventarios;
    private SimpleCursorAdapter adaptador;
    ArrayList<String> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        listaInventarios = (ListView) findViewById(R.id.listaInventarios);

        SQLiteDatabase bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);
        bd.execSQL("DELETE FROM Inventario");
        bd.execSQL("INSERT INTO Inventario VALUES('Inventario 1 ','André')");
        bd.execSQL("INSERT INTO Inventario VALUES('Inventario 2','Alma')");

        Cursor cursor = bd.rawQuery("SELECT rowid _id,* FROM Inventario", null);

        String from[] = new String []{"nombre","autor"};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_inventario, cursor, from, new int[]{ R.id.nombre, R.id.autor}, 0);
        listaInventarios.setAdapter(adaptador);

        listaInventarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"hue", Toast.LENGTH_LONG);
            }
        });
    }

    public void nuevoInventario(View v){

    }

}
