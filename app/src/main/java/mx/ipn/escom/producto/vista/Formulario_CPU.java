package mx.ipn.escom.producto.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.ipn.escom.R;

public class Formulario_CPU extends AppCompatActivity {
    private Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__cpu);

        btnFinalizar=(Button) findViewById(R.id.button9);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Formulario_CPU.this,RegistrarProducto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
