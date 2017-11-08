package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.vistas.MenuActivity;

public class UsuarioInicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_inicio);
        final ImageView image16=(ImageView)findViewById(R.id.imageView16);
        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsuarioInicioActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
