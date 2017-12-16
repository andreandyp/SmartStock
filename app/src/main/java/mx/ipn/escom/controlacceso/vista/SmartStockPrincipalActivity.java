package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.ipn.escom.R;

public class SmartStockPrincipalActivity extends AppCompatActivity {

    private Button btnIniciarSesion;
    private Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_stock_principal);

        btnIniciarSesion = (Button) findViewById(R.id.btnInicioSesion);
        btnCrearCuenta = (Button) findViewById(R.id.btnCrearCuenta);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartStockPrincipalActivity.this, InicioSesionActivity.class);
                startActivity(intent);
            }
        });

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartStockPrincipalActivity.this, ConfigCuentaActivity.class);
                startActivity(intent);
            }
        });
    }
}
