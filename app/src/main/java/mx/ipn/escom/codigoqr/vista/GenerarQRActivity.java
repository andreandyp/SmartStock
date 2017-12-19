package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import mx.ipn.escom.R;
import mx.ipn.escom.producto.Producto;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class GenerarQRActivity extends AppCompatActivity {
    private int WIDTH = 300;
    private int HEIGHT = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_qr);

        Bundle recibidos = this.getIntent().getExtras();
        ArrayList<Producto> elementosQR = recibidos.getParcelableArrayList("elementosQR");

        PdfDocument codigos = new PdfDocument();

        for (int i = 0, pags = 0; i < elementosQR.size(); i += 4, pags++){
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(600, 600, pags).create();
            PdfDocument.Page pagina = codigos.startPage(pageInfo);
            Canvas c = pagina.getCanvas();

            c.drawBitmap(codificarQR(elementosQR.get(i)), 0, 0, null);

            if(i+1 >= elementosQR.size()){
                codigos.finishPage(pagina);
                break;
            }
            c.drawBitmap(codificarQR(elementosQR.get(i+1)), WIDTH, 0, null);

            if(i+2 >= elementosQR.size()){
                codigos.finishPage(pagina);
                break;
            }
            c.drawBitmap(codificarQR(elementosQR.get(i+2)), 0, HEIGHT, null);

            if(i+3 >= elementosQR.size()){
                codigos.finishPage(pagina);
                break;
            }
            c.drawBitmap(codificarQR(elementosQR.get(i+3)), WIDTH, HEIGHT, null);
            codigos.finishPage(pagina);
        }

        File outputFile = new File("/storage/emulated/0/Download/codigosqr.pdf");

        try {
            outputFile.createNewFile();
            OutputStream out = new FileOutputStream(outputFile);
            codigos.writeTo(out);
            codigos.close();
            out.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "Código(s) QR generado(s) y guardado(s) en\n/storage/emulated/0/Download/codigosqr.pdf", Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        File archivoPDF = new File("/storage/emulated/0/Download/codigosqr.pdf");
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(archivoPDF), "application/pdf");
        startActivity(intent);
        finish();
    }

    private Bitmap codificarQR(Producto prod){
        BitMatrix resultado = null;
        StringBuilder contenidoQR = new StringBuilder("SSAPP\n");
        contenidoQR.append(prod.getIdDispositivo()).append("\n");
        contenidoQR.append(prod.getNb_dispositivo()).append("\n");
        contenidoQR.append(prod.getMarca()).append("\n");
        contenidoQR.append(prod.getIdInventario());
        try{
            resultado = new MultiFormatWriter().encode(contenidoQR.toString(), BarcodeFormat.QR_CODE, WIDTH, HEIGHT, null);
        }
        catch (WriterException we){
            Toast.makeText(getApplicationContext(), we.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }

        int width = WIDTH,
            height = HEIGHT;
        int [] pixeles = new int[width * height];

        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixeles[offset + x] = resultado.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixeles, 0, width, 0, 0, width, height);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(prod.getIdDispositivo()+" - "+prod.getMarca()+" "+prod.getNb_dispositivo(), 35, 280, paint);

        return bitmap;
    }
}
