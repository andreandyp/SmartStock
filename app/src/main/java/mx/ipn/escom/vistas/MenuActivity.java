package mx.ipn.escom.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.codigoqr.vista.EscanearQRActivity;
import mx.ipn.escom.controlacceso.vista.ConfigurarCuenta;
import mx.ipn.escom.controlacceso.vista.InicioSesionActivity;
import mx.ipn.escom.inventario.vista.InventariosPrincipal;
import mx.ipn.escom.reporte.vista.ReportesActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final ImageView image25=(ImageView)findViewById(R.id.imageView25);
        final TextView textView=(TextView) findViewById(R.id.textView29);
        final TextView textView1=(TextView) findViewById(R.id.textView31);
        final TextView textView2=(TextView) findViewById(R.id.textView32);
        final TextView textView3=(TextView) findViewById(R.id.textView33);
        final ImageView  imageView=(ImageView) findViewById(R.id.imageView15);
        final ImageView imageView1=(ImageView) findViewById(R.id.imageView20);
        final ImageView imageView2=(ImageView) findViewById(R.id.imageView22);
        final ImageView imageView3=(ImageView) findViewById(R.id.imageView23);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,InventariosPrincipal.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,InventariosPrincipal.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,EscanearQRActivity.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,EscanearQRActivity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ReportesActivity.class);
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ReportesActivity.class);
                startActivity(intent);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ConfigurarCuenta.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MenuActivity.this,ConfigurarCuenta.class);
                startActivity(intent);
            }
        });


        image25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,InicioSesionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
