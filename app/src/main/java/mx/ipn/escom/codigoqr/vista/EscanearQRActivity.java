package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.gambo.demo_proyecto.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class EscanearQRActivity extends AppCompatActivity {

    private final static int OBTENER_IMAGEN = 1;
    private ImageView codigoQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanearqr);

        codigoQR = (ImageView) findViewById(R.id.codigoQR);

        tomarFoto();
    }

    private void tomarFoto(){
        Intent tomarfoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomarfoto, OBTENER_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        OutputStream os;
        Bitmap codigoEscaneado;
        File archivoTMP;

        if (requestCode == OBTENER_IMAGEN && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            codigoEscaneado = (Bitmap) extras.get("data");
            archivoTMP = new File(getCacheDir(), "qr.png");
            try{
                os = new BufferedOutputStream(new FileOutputStream(archivoTMP));
                codigoEscaneado.compress(Bitmap.CompressFormat.PNG, 100, os);
                os.close();
            }
            catch(Exception ex){

            }

            //codigoQR.setImageBitmap(codigoEscaneado);
        }else{
            //El usuario decidió no guardar la foto
            finish();
        }
    }
}
