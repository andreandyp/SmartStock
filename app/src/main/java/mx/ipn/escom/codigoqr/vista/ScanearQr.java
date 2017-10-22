package mx.ipn.escom.codigoqr.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.vistas.MenuActivity;

public class ScanearQr extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanear_qr);

        imageView=(ImageView) findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScanearQr.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
