package mx.ipn.escom.producto.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gambo.demo_proyecto.R;

public class Formulario_Perifericos extends AppCompatActivity {

    private Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__perifericos);

        btnFinalizar= (Button) findViewById(R.id.button10);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Formulario_Perifericos.this,RegistrarProducto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
