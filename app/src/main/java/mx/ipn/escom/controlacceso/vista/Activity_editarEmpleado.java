package mx.ipn.escom.controlacceso.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import mx.ipn.escom.R;
import mx.ipn.escom.controlacceso.map.Usuario;

public class Activity_editarEmpleado extends AppCompatActivity {

    private ManejoUsuariosActivity manejoUsuariosActivity;

    public Activity_editarEmpleado(ManejoUsuariosActivity manejoUsuariosActivity) {
        this.manejoUsuariosActivity = manejoUsuariosActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_empleado);
        manejoUsuariosActivity.getIntent().putExtra("retrono",new Usuario((String) getIntent().getSerializableExtra("lol"),"123456"));
    }
}
