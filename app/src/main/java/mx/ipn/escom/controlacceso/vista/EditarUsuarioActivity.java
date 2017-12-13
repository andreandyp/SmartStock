package mx.ipn.escom.controlacceso.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.List;

import mx.ipn.escom.R;
import mx.ipn.escom.controlacceso.map.Usuario;


public class EditarUsuarioActivity extends AppCompatActivity {

    private FloatingActionButton btnConfirmar;
    private TextInputEditText txtNbUsuario;
    private TextInputEditText txtCorreo;
    private TextInputEditText password;
    private TextInputEditText confirmPassword;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        txtNbUsuario = findViewById(R.id.txtUsuarioEditado);
        txtCorreo = findViewById(R.id.txtCorreoUsuario);
        password = findViewById(R.id.txtPasswordUsuario);
        confirmPassword = findViewById(R.id.txtConfirmPasswordUsuario);
        List<Usuario> listUsuarios= (List<Usuario>) getIntent().getSerializableExtra("listaUsuario");
        txtCorreo.setText(getIntent().getSerializableExtra("nombreUsuario").toString());

        if(listUsuarios!=null && !listUsuarios.isEmpty()){
            for (Usuario usuario:listUsuarios){
                 if(usuario.getLogin().equals(getIntent().getSerializableExtra("nombreUsuario").toString())) {
                    txtNbUsuario.setText(usuario.getNombre()+" "+usuario.getPrimerApellido()+" "+usuario.getSegundoApellido());
                     password.setText(usuario.getPassword());
                 }
            }
        }

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] nombreCompleto =txtNbUsuario.getText().toString().split(" ");
                if(nombreCompleto.length ==1) {
                    usuario = new Usuario(nombreCompleto[0], null, null,
                            getIntent().getSerializableExtra("nombreUsuario").toString(), password.getText().toString());
                }else if(nombreCompleto.length==2){
                    usuario = new Usuario(nombreCompleto[0], nombreCompleto[1], null,
                            getIntent().getSerializableExtra("nombreUsuario").toString(), password.getText().toString());
                }else if(nombreCompleto.length==3){
                    usuario = new Usuario(nombreCompleto[0], nombreCompleto[1], nombreCompleto[2],
                            getIntent().getSerializableExtra("nombreUsuario").toString(), password.getText().toString());
                }else{
                    System.out.println("lol");
                }
                Intent returnIntent = new Intent(EditarUsuarioActivity.this, ManejoUsuariosActivity.class);
                returnIntent.putExtra("usuarioEditado", usuario);
                returnIntent.putExtra("loled", "lol");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


