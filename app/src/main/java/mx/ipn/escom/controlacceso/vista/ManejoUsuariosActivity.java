package mx.ipn.escom.controlacceso.vista;

import android.app.ActionBar;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.escom.R;
import mx.ipn.escom.controlacceso.bs.EmpresaBs;
import mx.ipn.escom.controlacceso.map.Empresa;
import mx.ipn.escom.controlacceso.map.Usuario;

public class ManejoUsuariosActivity extends AppCompatActivity {

    private TextInputEditText txtNombreUsuario;
    private FloatingActionButton btnAgregarUsuario;
    private FloatingActionButton btnRetroceder;
    private FloatingActionButton btnConfirmar;
    private ListView listUsuarios;
    private Spinner spinUsuarios;
    private Menu menuUsuario;
    private ArrayList<Usuario> listUsuariosGuardar;
    private EmpresaBs empresaBs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejo_usuarios);
        txtNombreUsuario = findViewById(R.id.txtUsuario);
        btnAgregarUsuario = findViewById(R.id.btnAgregarUsuario);
        btnRetroceder = findViewById(R.id.btnAgregarUsuario);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        listUsuarios=findViewById(R.id.listUsuario);

        final ArrayList<String> listUsuario=new ArrayList<>();
        getIntent().putExtra("listUsuario",listUsuario);
        listUsuariosGuardar=new ArrayList<>();
        getIntent().putExtra("listUsuariosGuardar",listUsuariosGuardar);
        btnAgregarUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                List<String> listUsuarioSpinner=getIntent().getStringArrayListExtra("listUsuario");
                Empresa empresa= (Empresa) getIntent().getSerializableExtra("datosEmpresa");
                if(listUsuarioSpinner!=null) {
                    listUsuario.add(txtNombreUsuario.getText().toString()+"@"+empresa.getDominio());
                    ArrayAdapter<String> adapter =new ArrayAdapter<String>(
                            ManejoUsuariosActivity.this,
                            android.R.layout.simple_spinner_item,listUsuario);
                    listUsuarios.setAdapter(adapter);
                 }
                System.out.println(empresa);
               }
        });

    /**
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empresaBs=new EmpresaBs();
                empresaBs.guardarInformacionEmpresa((Empresa)getIntent().getSerializableExtra("datosEmpresa"),
                        (List<Usuario>)getIntent().getSerializableExtra("listUsuarioGuardar"));
            }
        });**/


        registerForContextMenu(listUsuarios);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Usuario> listUsuarios= (List<Usuario>) getIntent().getSerializableExtra("listUsuariosGuardar");
        if ((resultCode == RESULT_OK)){
            listUsuarios.add((Usuario) data.getSerializableExtra("usuarioEditado"));
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        if(v.getId()==R.id.listUsuario){
            ListView lv= (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi=(AdapterView.AdapterContextMenuInfo)menuInfo;
            String nbUsuario= (String) lv.getItemAtPosition(acmi.position);
            getIntent().putExtra("nbUsuario",nbUsuario);
        getMenuInflater().inflate(R.menu.menu_crud_usuario,menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.menuEditar:
                Intent intent=new Intent(this,EditarUsuarioActivity.class);
                intent.putExtra("listaUsuario",listUsuariosGuardar);
                intent.putExtra("nombreUsuario",getIntent().getSerializableExtra("nbUsuario"));
                startActivityForResult(intent,1);
                return true;
            case R.id.menuEliminar:

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
