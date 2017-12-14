package mx.ipn.escom.codigoqr.vista;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.zxing.client.result.TextParsedResult;

import mx.ipn.escom.R;

/**
 * Created by gambo on 05/09/2017.
 */

public class CodigoQrPrincipal extends AppCompatActivity {

    private TextInputEditText txtNombreComercial;
    private TextInputEditText txtDominio;
    private TextInputEditText txtCorreoElectronico;
    private TextInputEditText txtPassword;
    private TextInputEditText txtConfirmarPassword;
    private FloatingActionButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_qr_principal);

        txtNombreComercial= findViewById(R.id.txtNombreComercial);
        txtDominio= findViewById(R.id.txtDominio);
        txtCorreoElectronico=findViewById(R.id.txtCorreo);
        txtPassword=findViewById(R.id.txtPassword);
        txtConfirmarPassword=findViewById(R.id.txtConfirmarPassword);
        btnSiguiente=findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

    }
}

