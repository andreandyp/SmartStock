package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gambo.demo_proyecto.R;

public class ManejoUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejo_usuarios);
        final Button button4 = (Button)findViewById(R.id.button4);
        final ImageView image7=(ImageView)findViewById(R.id.imageView7);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManejoUsuariosActivity.this,InicioSesionActivity.class);
                startActivity(intent);
                finish();
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManejoUsuariosActivity.this,ConfigCuentaActivity.class);
                startActivity(intent);
            }
        });
    }
}
