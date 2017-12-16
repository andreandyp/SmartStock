package mx.ipn.escom.inventario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.ipn.escom.R;

public class NuevoInventarioActivity extends AppCompatActivity {

    private TextInputLayout nombre, numero, desc;
    private Button aleatorio;
    private boolean edicion = false;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_inventario);

        nombre = findViewById(R.id.nombre);
        numero = findViewById(R.id.numero);
        desc = findViewById(R.id.desc);
        bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);

        if(this.getIntent().getExtras() != null){
            nombre.getEditText().setText(this.getIntent().getExtras().getString("Nombre"));
            numero.getEditText().setText(this.getIntent().getExtras().getString("Número"));

            ((TextView) findViewById(R.id.tituloInventarios)).setText("Editar inventario");
            ((Button) findViewById(R.id.aceptar)).setText("Actualizar");
            aleatorio = findViewById(R.id.aleatorio);
            aleatorio.setEnabled(false);
            numero.setEnabled(false);

            desc.getEditText().setText(this.getIntent().getExtras().getString("Descripción"));
            edicion = true;
        }

    }

    public void nuevo(View v){
        String nNombre = nombre.getEditText().getText().toString(),
                nDesc = desc.getEditText().getText().toString();
        int nNumero = Integer.parseInt(numero.getEditText().getText().toString());

        if(edicion){
            bd.execSQL("UPDATE Inventario SET nb_nombre = ?, tx_descripcion = ? WHERE idInventario = ?;", new Object[]{nNombre, nDesc, nNumero});
            Toast.makeText(getBaseContext(), "Inventario actualizado", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

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
        numero.getEditText().setText(Integer.toString((int) (Math.random()*100)));
    }
}
