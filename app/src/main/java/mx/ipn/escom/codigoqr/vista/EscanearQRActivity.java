package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mx.ipn.escom.R;

public class EscanearQRActivity extends AppCompatActivity {

    private ImageView codigoQR;
    private TextView contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IntentIntegrator integrator;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanearqr);

        codigoQR = (ImageView) findViewById(R.id.codigoQR);
        contenido = (TextView) findViewById(R.id.contenido);

        integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Escanea el código QR del producto");
        integrator.setOrientationLocked(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() != null) {
                contenido.setText("Contenido del QR: "+result.getContents());
                codigoQR.setImageURI(Uri.parse(result.getBarcodeImagePath()));
            } else {
                Toast.makeText(this, "Ningún código QR fue escaneado", Toast.LENGTH_LONG).show();
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
