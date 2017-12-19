package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mx.ipn.escom.R;
import mx.ipn.escom.producto.NuevoProductoActivity;

public class EscanearQRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IntentIntegrator integrator;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanearqr);

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
                if(result.getContents().contains("SSAPP")){
                    Toast.makeText(this, "Código de Smart Stock válido", Toast.LENGTH_SHORT).show();
                    String datos[] = result.getContents().split("\n");
                    Intent intent = new Intent(EscanearQRActivity.this, NuevoProductoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("IDDispositivo", datos[1]);
                    bundle.putString("Nombre", datos[2]);
                    bundle.putString("Marca", datos[3]);
                    bundle.putString("IDInventario", datos[4]);
                    intent.putExtras(bundle);
                    finish();
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Código inválido", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                Toast.makeText(this, "Ningún código QR fue escaneado", Toast.LENGTH_LONG).show();
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
