package mx.ipn.escom.inventario;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import mx.ipn.escom.BD;
import mx.ipn.escom.R;
import mx.ipn.escom.producto.ListaProductosActivity;

public class ListaInventariosActivity extends AppCompatActivity {
    private ListView listaInventarios;
    private SimpleCursorAdapter adaptador;
    private TextView nohay;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        listaInventarios = (ListView) findViewById(R.id.listaInventarios);
        nohay = findViewById(R.id.nohay);
        bd = BD.getInstance(getApplicationContext());

        registerForContextMenu(listaInventarios);

        actualizarListView();

        listaInventarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteCursor cursor = (SQLiteCursor) listaInventarios.getItemAtPosition(position);
                String idInventario = cursor.getString(cursor.getColumnIndex("idInventario"));

                Intent abrir = new Intent(getBaseContext(), ListaProductosActivity.class);
                Bundle datos = new Bundle();
                datos.putString("ID", idInventario);
                abrir.putExtras(datos);

                startActivity(abrir);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_crud_usuario, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        SQLiteCursor cursor = (SQLiteCursor) listaInventarios.getItemAtPosition(info.position);
        String idInventario = cursor.getString(cursor.getColumnIndex("idInventario")),
                nombre = cursor.getString(cursor.getColumnIndex("nb_nombre"));

        switch (item.getItemId()) {
            case R.id.menuEditar:
                Intent abrir = new Intent(getBaseContext(), NuevoInventarioActivity.class);
                Bundle datos = new Bundle();
                datos.putString("Nombre", nombre);
                datos.putString("Número", idInventario);
                datos.putString("Descripción", cursor.getString(cursor.getColumnIndex("tx_descripcion")));
                abrir.putExtras(datos);
                startActivity(abrir);

                return true;
            case R.id.menuEliminar:
                bd.execSQL("DELETE FROM Inventario WHERE idInventario = ?;", new String[]{ idInventario});
                Toast.makeText(getApplicationContext(), "Inventario eliminado", Toast.LENGTH_SHORT).show();
                actualizarListView();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
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
        Cursor cursor = bd.rawQuery("SELECT rowid _id,* FROM Inventario", null);

        if(!cursor.moveToFirst()){
            nohay.setVisibility(View.VISIBLE);
        }else{
            nohay.setVisibility(View.INVISIBLE);
        }

        String from[] = new String []{"nb_nombre", "tx_descripcion"};
        int to[] = new int[]{R.id.nombre, R.id.descripcion};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_inventario, cursor, from, to, 0);
        listaInventarios.setAdapter(adaptador);

    }
}
