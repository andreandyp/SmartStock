package mx.ipn.escom.producto.tipos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.ipn.escom.BD;
import mx.ipn.escom.R;

public class NuevoTipoActivity extends AppCompatActivity {
    private TextInputLayout tipo, descripcion, idTipo;
    private Button aleatorio;
    private boolean edicion = false;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);

        tipo = findViewById(R.id.tipo);
        descripcion = findViewById(R.id.descripcion);
        idTipo = findViewById(R.id.idTipo);
        bd = BD.getInstance(getApplicationContext());

        if(this.getIntent().getExtras() != null){
            tipo.getEditText().setText(this.getIntent().getExtras().getString("Nombre"));
            idTipo.getEditText().setText(this.getIntent().getExtras().getString("Número"));

            ((TextView) findViewById(R.id.tituloTipos)).setText("Editar tipo de dispositivo");
            ((Button) findViewById(R.id.nuevoTipo)).setText("Actualizar");
            aleatorio = findViewById(R.id.aleatTipo);
            aleatorio.setEnabled(false);
            idTipo.setEnabled(false);
            ((Button) findViewById(R.id.eliminarTipo)).setVisibility(View.VISIBLE);
            descripcion.getEditText().setText(this.getIntent().getExtras().getString("Descripción"));
            edicion = true;
        }
    }

    public void agregarTipo(View v){
        String nTipo = tipo.getEditText().getText().toString(),
                nDesc = descripcion.getEditText().getText().toString();
        int nNumero = Integer.parseInt(idTipo.getEditText().getText().toString());

        if(edicion){
            bd.execSQL("UPDATE Tipo_Dispositivo SET nb_tipo = ?, tx_descripcion = ? WHERE idTipo = ?;", new Object[]{nTipo, nDesc, nNumero});
            Toast.makeText(getBaseContext(), "Tipo de dispositivo actualizado", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        Cursor cursor = bd.rawQuery("SELECT rowid _id,idTipo FROM Tipo_Dispositivo WHERE idTipo = ?;", new String[]{Integer.toString(nNumero)});

        if(cursor.moveToFirst()){
            Toast.makeText(getBaseContext(), "Ya hay un tipo con ese ID", Toast.LENGTH_LONG).show();
        }else{
            bd.execSQL("INSERT INTO Tipo_Dispositivo VALUES(?, ?, ?, 1);", new Object[]{nNumero, nTipo, nDesc});
            Toast.makeText(getBaseContext(), "¡Tipo de dispositivo agregado!", Toast.LENGTH_LONG).show();
            cursor.close();
            finish();
        }
    }

    public void numAleatorio(View v){
        idTipo.getEditText().setText(Integer.toString((int) (Math.random()*100)));
    }

    public void eliminarTipo(View v){
        String tipo = idTipo.getEditText().getText().toString();
        bd.execSQL("DELETE FROM Tipo_Dispositivo WHERE idTipo = ?", new String[]{ tipo });
        Toast.makeText(getBaseContext(), "Tipo de dispositivo eliminado", Toast.LENGTH_SHORT).show();
        finish();
    }
}
