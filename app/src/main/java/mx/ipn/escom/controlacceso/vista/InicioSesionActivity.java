package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import mx.ipn.escom.R;
import mx.ipn.escom.controlacceso.bs.UsuarioBs;
import mx.ipn.escom.controlacceso.interfaces.APIServce;
import mx.ipn.escom.controlacceso.service.APIUtils;

public class InicioSesionActivity extends AppCompatActivity {
    /**
     * Botón de inicio de sesión
     */
    private Button btnInicioSesion;

    /**
     *  Negoocio para el manejo de la informacion del usuario.
     */
    private UsuarioBs usuarioBs;

    /**
     * TextView que debera tener el login del usuario.
     */
    private EditText login;

    /**
     * TextView que debera tener el password del usuario.
     */
    private EditText password;

    private TextView olvidaPassword;
    private TextView crearCuenta;
    private APIServce mpService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        Button btnInicioSesion = (Button)findViewById(R.id.btnIniciarSesion);
        olvidaPassword=(TextView) findViewById(R.id.linkPassword);
        login =(EditText) findViewById(R.id.txLogin);
        password =(EditText) findViewById(R.id.txPassword);
        APIUtils apiUtils=new APIUtils();
        mpService= apiUtils.getAPIService();

        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    usuarioBs=new UsuarioBs(InicioSesionActivity.this);

                try {
                    usuarioBs.validarInicioSesion(String.valueOf(login.getText()),String.valueOf(password.getText()),mpService);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        olvidaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InicioSesionActivity.this,OlvideContrasenaActivity.class);
                startActivity(intent);
            }
        });

    }
}