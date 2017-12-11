package mx.ipn.escom.inventario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.ipn.escom.R;

public class NuevoInventarioActivity extends AppCompatActivity {

    private EditText nombre, numero, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_inventario);

        nombre = findViewById(R.id.nombre);
        numero = findViewById(R.id.numero);
        desc = findViewById(R.id.desc);
    }

    public void nuevo(View v){
        String nNombre = nombre.getText().toString(),
                nDesc = desc.getText().toString();
        int nNumero = Integer.parseInt(numero.getText().toString());

        SQLiteDatabase bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);
        Cursor cursor = bd.rawQuery("SELECT rowid _id,idInventario FROM Inventario WHERE idInventario = "+nNumero, null);

        if(cursor.moveToFirst()){
            Toast.makeText(getBaseContext(), "Ya hay un inventario con ese ID", Toast.LENGTH_LONG).show();
        }else{
            bd.execSQL("INSERT INTO Inventario VALUES(?, 1, ?, ?);", new Object[]{nNumero, nNombre, nDesc});
            Toast.makeText(getBaseContext(), "¡Inventario agregado!", Toast.LENGTH_LONG).show();
            cursor.close();
            finish();
        }
    }

    public void numAleatorio(View v){
        numero.setText(Integer.toString((int) (Math.random()*100)));
    }
}
