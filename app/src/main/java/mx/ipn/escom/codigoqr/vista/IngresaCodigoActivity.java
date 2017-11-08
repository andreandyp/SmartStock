package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.controlacceso.vista.CambiarContrasenaActivity;

public class IngresaCodigoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ingresa_codigo);
        final Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IngresaCodigoActivity.this, CambiarContrasenaActivity.class);
                startActivity(intent);
            }
        });
    }
}
