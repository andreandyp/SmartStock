package mx.ipn.escom.producto;

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
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.ipn.escom.BD;
import mx.ipn.escom.R;
import mx.ipn.escom.codigoqr.vista.GenerarQRActivity;

public class ListaProductosActivity extends AppCompatActivity {

    private ListView listaProductos;
    private SimpleCursorAdapter adaptador;
    private TextView nohay;
    private String id;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        listaProductos = findViewById(R.id.listaProductos);

        id = this.getIntent().getExtras().getString("ID");
        bd = BD.getInstance(getApplicationContext());
        actualizarListView(id);

        registerForContextMenu(listaProductos);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarListView(id);
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

        SQLiteCursor cursor = (SQLiteCursor) listaProductos.getItemAtPosition(info.position);
        String idDispositivo = cursor.getString(cursor.getColumnIndex("idDispositivo")),
                nombre = cursor.getString(cursor.getColumnIndex("nb_dispositivo")),
                marca = cursor.getString(cursor.getColumnIndex("marca"));

        switch (item.getItemId()) {
            case R.id.menuEditar:
                Intent abrir = new Intent(getBaseContext(), NuevoProductoActivity.class);
                Bundle datos = new Bundle();
                datos.putString("IDInventario", id);
                datos.putString("Nombre", nombre);
                datos.putString("IDDispositivo", idDispositivo);
                datos.putString("Marca", marca);
                abrir.putExtras(datos);
                startActivity(abrir);

                return true;
            case R.id.menuEliminar:
                bd.execSQL("DELETE FROM Dispositivo WHERE idDispositivo = ?;", new String[]{ idDispositivo });
                bd.execSQL("DELETE FROM inventario_dispositivo WHERE idDispositivo = ?;", new String[]{ idDispositivo });
                Toast.makeText(getApplicationContext(), "Dispositivo eliminado", Toast.LENGTH_SHORT).show();
                actualizarListView(id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void agregarProducto(View v){
        Intent abrir = new Intent(this, NuevoProductoActivity.class);
        Bundle datos = new Bundle();
        datos.putString("IDInventario", id);
        abrir.putExtras(datos);
        startActivity(abrir);
    }

    public void generarQR(View v){
        int elementos = listaProductos.getCount();
        ArrayList<Producto> elementosQR = new ArrayList<Producto>();

        for(int i = 0; i < elementos; i++){
            boolean check = ((CheckBox) listaProductos.getChildAt(i).findViewById(R.id.selectQR)).isChecked();
            if(check){
                SQLiteCursor actual = (SQLiteCursor) listaProductos.getItemAtPosition(i);
                String idDispostivo = actual.getString(actual.getColumnIndex("idDispositivo")),
                        nb_dispositivo = actual.getString(actual.getColumnIndex("nb_dispositivo")),
                        marca = actual.getString(actual.getColumnIndex("marca"));
                elementosQR.add(new Producto(idDispostivo, nb_dispositivo, marca, Integer.parseInt(id)));
            }
        }

        if(elementosQR.isEmpty()){
            Toast.makeText(ListaProductosActivity.this, "Selecciona un elemento o más", Toast.LENGTH_LONG).show();
            return;
        }
        Intent abrir = new Intent(ListaProductosActivity.this, GenerarQRActivity.class);
        Bundle datos = new Bundle();
        datos.putParcelableArrayList("elementosQR", elementosQR);
        abrir.putExtras(datos);

        startActivity(abrir);
    }

    public void actualizarListView(String id){
        Cursor cursor = bd.rawQuery("SELECT Dispositivo.rowid AS _id, Dispositivo.idDispositivo, Dispositivo.idTipo, Dispositivo.nb_dispositivo,  Dispositivo.marca FROM Dispositivo INNER JOIN inventario_dispositivo as indi ON Dispositivo.idDispositivo = indi.idDispositivo WHERE idInventario = ?;", new String[]{ id });

        nohay = findViewById(R.id.nohay);
        if(!cursor.moveToFirst()){
            nohay.setVisibility(View.VISIBLE);
        }else{
            nohay.setVisibility(View.INVISIBLE);
        }

        String from[] = new String []{"idDispositivo",  "nb_dispositivo", "marca"};
        adaptador = new SimpleCursorAdapter(this, R.layout.elemento_producto, cursor, from, new int[]{ R.id.dispositivoID, R.id.nombre, R.id.marca}, 0);
        listaProductos.setAdapter(adaptador);
    }
}
