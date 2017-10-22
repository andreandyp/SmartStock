package mx.ipn.escom.controlacceso.vista;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.controlacceso.bs.InicioSesionBs;

public class InicioSesionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        final Button button1 = (Button)findViewById(R.id.button);
        final TextView label2 =(TextView)findViewById(R.id.textView);
        final TextView label3 =(TextView)findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_usuario_inicio);
                Intent intent =new Intent(InicioSesionActivity.this,UsuarioInicioActivity.class);
                startActivity(intent);
            }
        });
        label2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InicioSesionActivity.this,OlvideContrasenaActivity.class);
                startActivity(intent);
            }
        });

        label3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InicioSesionActivity.this,RegistrarEmpresaActivity.class);
                startActivity(intent);
            }
        });
    }
    }
