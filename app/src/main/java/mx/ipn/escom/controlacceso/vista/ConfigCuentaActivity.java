package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.ipn.escom.R;
import mx.ipn.escom.controlacceso.map.Empresa;

public class ConfigCuentaActivity extends AppCompatActivity {

    private TextInputEditText txtNombreComercial;
    private TextInputEditText txtDominio;
    private TextInputEditText txtCorreoElectronico;
    private TextInputEditText txtPassword;
    private TextInputEditText txtConfirmarPassword;
    private FloatingActionButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_cuenta);

        txtNombreComercial = findViewById(R.id.txtNombreComercial);
        txtDominio = findViewById(R.id.txtDominio);
        txtCorreoElectronico = findViewById(R.id.txtCorreo);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmarPassword = findViewById(R.id.txtConfirmarPassword);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfigCuentaActivity.this, ManejoUsuariosActivity.class);
                intent.putExtra("datosEmpresa", new Empresa(txtNombreComercial.getText().toString(),
                        txtDominio.getText().toString(), txtCorreoElectronico.getText().toString(),
                        txtPassword.getText().toString()));
                startActivity(intent);
            }
        });

    }
}
